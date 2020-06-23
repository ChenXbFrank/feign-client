package com.frank.feignclient;

import org.springframework.stereotype.Component;

/**
 * @author 小石潭记
 * @date 2020/6/23 20:31
 * @Description: ${todo}
 */
@Component
public class UserHihystric implements UserFeignClient {
    @Override
    public String getSuccessInfo(){
        return "getSuccessInfo serve is bad.";
    }

    @Override
    public String getFailInfo() {
        return "getFailInfo serve is bad.";
    }

}
