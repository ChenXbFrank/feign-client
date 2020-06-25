package com.frank.decoder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frank.domain.EnumError;
import com.frank.domain.ExceptionInfo;
import com.frank.domain.MyException;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author 小石潭记
 * @date 2020/6/23 20:53
 * @Description: 自定义feign错误异常处理
 */
@Configuration
public class MyErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        /*if (response.status() >= 400 && response.status() <= 499) {
            return new MyException(EnumError.BAD_REQUEST);
        }
        if (response.status() >= 500 && response.status() <= 599) {
            return new MyException(EnumError.SERVER_ERROR);
        }
        return new MyException(EnumError.OTHER_ERROR);*/
        try {
            if (response.body() != null) {
                ObjectMapper mapper = new ObjectMapper();
                ExceptionInfo exceptionInfo =mapper.readValue(Util.toString(response.body().asReader()),
                        new TypeReference<ExceptionInfo>() {});
                Class clazz = Class.forName(exceptionInfo.getException());
                return (Exception) clazz.getDeclaredConstructor(String.class).newInstance(exceptionInfo.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return FeignException.errorStatus(methodKey, response);
    }
}
