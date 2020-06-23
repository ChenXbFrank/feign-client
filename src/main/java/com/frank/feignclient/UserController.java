package com.frank.feignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小石潭记
 * @date 2020/6/20 21:38
 * @Description: ${todo}
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/getSuccessInfo")
    public Object getSuccessInfo(){
        return userFeignClient.getSuccessInfo();
    }

    @GetMapping("/getFailInfo")
    public Object getFailInfo(){
        return userFeignClient.getFailInfo();
    }
}
