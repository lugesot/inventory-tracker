package com.jd.inventory.tracker.domain.enums;

public enum UserStatusEnum {
    INVALID(-1, "无效"), VALID(1, "有效");

    private Integer status;
    private String desc;

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    UserStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static UserStatusEnum getStatus(String name) {
        try {
            return Enum.valueOf(UserStatusEnum.class, name);
        } catch (Exception ex) {
            return null;
        }
    }

    public static UserStatusEnum getStatus(Integer code) {
        UserStatusEnum ret = null;
        for (UserStatusEnum s : UserStatusEnum.values()) {
            if (s.getStatus().equals(code)) {
                ret = s;
                break;
            }
        }
        return ret;
    }
}
