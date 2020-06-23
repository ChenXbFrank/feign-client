package com.frank.feignclient;

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
        url = "http://localhost:8081/api",
        fallback = UserHihystric.class
)
public interface UserFeignClient {

    //对应的服务里的接口地址，及请求方式
    @RequestMapping(value = "/getSuccessInfo", method = RequestMethod.GET)
    @ResponseBody
    String getSuccessInfo();

    @RequestMapping(value = "/getFailInfo", method = RequestMethod.GET)
    @ResponseBody
    String getFailInfo();

}

