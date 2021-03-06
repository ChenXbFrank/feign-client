package com.frank.domain;

import lombok.Data;

/**
 * @author 小石潭记
 * @date 2020/6/25 21:10
 * @Description: ${todo}
 */
@Data
public class ExceptionInfo{

    private Long timestamp;

    private Integer status;
    //异常包结构-"com.crazy.cloud.common.exception.DataConflictException"
    private String exception;
    //信息--手机已注册
    private String message;

    private String path;

    private String error;

}
