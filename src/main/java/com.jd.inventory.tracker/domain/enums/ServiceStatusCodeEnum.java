package com.jd.inventory.tracker.domain.enums;

public enum ServiceStatusCodeEnum {
    SUCCESS(2000, "成功"),
    FAIL(5000, "失败"),

    REQUEST_PARAM_ERROR(4001, "请求参数错误");

    private Integer code;
    private String name;

    ServiceStatusCodeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static ServiceStatusCodeEnum getStatus(String name) {
        try {
            return Enum.valueOf(ServiceStatusCodeEnum.class, name);
        } catch (Exception ex) {
            return null;
        }
    }

    public static ServiceStatusCodeEnum getStatus(Integer code) {
        ServiceStatusCodeEnum ret = null;
        for (ServiceStatusCodeEnum s : ServiceStatusCodeEnum.values()) {
            if (s.getCode().equals(code)) {
                ret = s;
                break;
            }
        }
        return ret;
    }
}