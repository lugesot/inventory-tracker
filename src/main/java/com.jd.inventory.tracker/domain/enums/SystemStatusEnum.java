package com.jd.inventory.tracker.domain.enums;

public enum SystemStatusEnum {
    INVALID(-1, "无效"), VALID(1, "有效");

    private Integer status;
    private String desc;

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    SystemStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static SystemStatusEnum getStatus(String name) {
        try {
            return Enum.valueOf(SystemStatusEnum.class, name);
        } catch (Exception ex) {
            return null;
        }
    }

    public static SystemStatusEnum getStatus(Integer code) {
        SystemStatusEnum ret = null;
        for (SystemStatusEnum s : SystemStatusEnum.values()) {
            if (s.getStatus().equals(code)) {
                ret = s;
                break;
            }
        }
        return ret;
    }
}
