package com.frank.web;

import com.frank.client.MyFeignClient;
import com.frank.domain.dto.BaseResponse;
import com.frank.domain.dto.Grade;
import com.frank.domain.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author 小石潭记
 * @date 2020/6/20 21:38
 * @Description: ${todo}
 */
@RestController
@Slf4j
public class ClientController {

    @Autowired
    private MyFeignClient userFeignClient;

    @GetMapping("/getUserInfo")
    public BaseResponse<User> getUserInfo() {
        BaseResponse<User> successInfo = userFeignClient.getUserInfo();
        log.info("client->getSuccessInfo返回数据：{},{}", successInfo, new Date());
        return successInfo;
    }

    @GetMapping("/getGradeInfo")
    public BaseResponse<Grade> getGradeInfo() {
        BaseResponse<Grade> successInfo = userFeignClient.getGradeInfo();
        log.info("client->getGradeInfo返回数据：{},{}", successInfo, new Date());
        return successInfo;
    }

    @GetMapping("/getFailInfo")
    public BaseResponse getFailInfo() {
        BaseResponse failInfo = userFeignClient.getFailInfo();
        log.info("client返回失败数据：{},{}", failInfo, new Date());
        return failInfo;
    }
}
