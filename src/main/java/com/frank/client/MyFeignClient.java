package com.frank.client;

import com.frank.domain.dto.BaseResponse;
import com.frank.domain.dto.Grade;
import com.frank.domain.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 小石潭记
 * @date 2020/6/22 21:48
 * @Description: ${todo}
 */
@FeignClient(
        //服务名
        name = "user-service",
        //服务地址
        url = "http://localhost:8081/api"
//        ,fallback = UserHihystric.class   暂不开启熔断
)
public interface MyFeignClient {

    //对应的服务里的接口地址，及请求方式
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse getUserInfo();

    @RequestMapping(value = "/getGradeInfo", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse getGradeInfo();

    @RequestMapping(value = "/getFailInfo", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse getFailInfo();

}

