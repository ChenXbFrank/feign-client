package com.frank.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.frank.domain.EnumError;
import com.frank.domain.MyException;
import com.frank.domain.dto.BaseResponse;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author 小石潭记
 * @date 2020/6/23 21:09
 * @Description: 自定义feign的正常返回结果
 */
@Component
public class MyDecoder implements Decoder {

    @Autowired
    private ObjectMapper mapper;

    /**
     *  这里统一处理，根据状态码判断返回正常还是异常的，
     *  200返回正常的，其他状态码直接抛出异常
     */
    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        if (response.status() >= 200 && response.status() <= 299) {
            String result = Util.toString(response.body().asReader());
            BaseResponse baseResponse = mapper.readValue(result, BaseResponse.class);
            int code = baseResponse.getCode();
            if (code == 200){
                return baseResponse;
            }
            throw new MyException(EnumError.BAD_REQUEST);
        }
        throw new MyException(EnumError.OTHER_ERROR);
    }
}
