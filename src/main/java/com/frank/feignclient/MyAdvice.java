package com.frank.feignclient;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author 小石潭记
 * @date 2020/6/22 21:07
 * @Description: ${todo}
 */
@ControllerAdvice
public class MyAdvice implements ResponseBodyAdvice<Object> {

    /**
     *  判断哪些需要拦截 return true 就会执行beforeBodyWrite
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object obj, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        System.out.println("==>beforeBodyWrite:" + obj.toString() + ","
                + methodParameter);
        return obj;
    }
}
