package com.jd.inventory.tracker.domain.enums;

public enum TemplateStatusEnum {
    INVALID(-1, "无效"), VALID(1, "有效");

    private Integer status;
    private String desc;

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    TemplateStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static TemplateStatusEnum getStatus(String name) {
        try {
            return Enum.valueOf(TemplateStatusEnum.class, name);
        } catch (Exception ex) {
            return null;
        }
    }

    public static TemplateStatusEnum getStatus(Integer code) {
        TemplateStatusEnum ret = null;
        for (TemplateStatusEnum s : TemplateStatusEnum.values()) {
            if (s.getStatus().equals(code)) {
                ret = s;
                break;
            }
        }
        return ret;
    }
}
