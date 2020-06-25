package com.frank.domain;


/**
 * @author 小石潭记
 * @date 2020/6/23 21:01
 * @Description: ${todo}
 */
public enum EnumError {

    SERVER_ERROR(500, "服务器异常,请联系系统运维人员"),
    BAD_REQUEST(400, "请求异常"),
    OTHER_ERROR(404, "系统异常");

    private int status;
    private String reason;
    EnumError(int status, String reason){
        this.status = status;
        this.reason = reason;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }}
