package com.frank.domain;

/**
 * @author 小石潭记
 * @date 2020/6/25 14:09
 * @Description: ${todo}
 */
public class MyException extends RuntimeException{

    public MyException(EnumError enumError){
        super(enumError.getReason());
    }
}
