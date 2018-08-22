package com.jd.inventory.tracker.exception;

import com.jd.inventory.tracker.domain.enums.ServiceStatusCodeEnum;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String msg = "";
    private int code = -1;

    public ServiceException(Exception e) {
        this.msg = e.getMessage();
    }

    public ServiceException(String msg) {
        this.msg = msg;
    }

    public ServiceException(ServiceStatusCodeEnum marketStatusCode) {
        this.code = marketStatusCode.getCode();
        this.msg = marketStatusCode.getName();
    }


    public ServiceException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return msg;
    }
}
