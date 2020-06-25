package com.frank.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author 小石潭记
 * @date 2020/6/25 12:19
 * @Description: ${todo}
 */

@Data
public class BaseResponse<T> {

    /**
     * 返回的状态码
     */
    @JsonProperty("code")
    private int code;

    /**
     * 返回的信息
     */
    @JsonProperty("msg")
    private String message;

    /**
     * 返回的数据
     */
    @JsonProperty("data")
    private T data;

    public static BaseResponse success(Object object){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setMessage("success");
        baseResponse.setData(object);
        return baseResponse;
    }

    public static BaseResponse fail(Object object){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(404);
        baseResponse.setMessage("fail");
        baseResponse.setData(object);
        return baseResponse;
    }
}
