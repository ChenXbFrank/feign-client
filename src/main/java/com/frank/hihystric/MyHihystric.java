package com.frank.hihystric;

import com.frank.client.MyFeignClient;
import com.frank.domain.dto.BaseResponse;
import com.frank.domain.dto.Grade;
import com.frank.domain.dto.User;

/**
 * @author 小石潭记
 * @date 2020/6/23 20:31
 * @Description: ${todo}
 */
//@Component    暂不开启熔断, 全部返回的null，如果需要使用熔断，返回默认的一个对象即可
public class MyHihystric implements MyFeignClient {

    @Override
    public BaseResponse<User> getUserInfo() {
        return null;
    }

    @Override
    public BaseResponse<Grade> getGradeInfo() {
        return null;
    }

    @Override
    public BaseResponse getFailInfo() {
        return null;
    }

}
