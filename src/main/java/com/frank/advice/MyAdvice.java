package com.frank.advice;

import com.frank.domain.MyException;
import com.frank.domain.dto.BaseResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 小石潭记
 * @date 2020/6/22 21:07
 * @Description: ${todo}
 */
@RestControllerAdvice
public class MyAdvice implements ResponseBodyAdvice<Object> {

    /**
     * 抛出该自定义异常就会执行该方法
     */
    @ExceptionHandler(value = MyException.class)
    BaseResponse handleMyException(MyException e, HttpServletRequest request){
        return BaseResponse.fail(e.getMessage());
    }

    /**
     *  判断哪些需要拦截 return true 就会执行beforeBodyWrite
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    /**
     *  经过decoder之后，就会到达这里，返回结果前，可以对结果进行处理
     */
    @Override
    public Object beforeBodyWrite(Object obj, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        System.out.println("==>beforeBodyWrite:" + obj.toString() + ","
                + methodParameter);
        return obj;
    }
}
