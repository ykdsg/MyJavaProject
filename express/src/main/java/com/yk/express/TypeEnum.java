package com.yk.express;

/**
 * Created by wuzheng.yk on 2017/6/27.
 */
public enum TypeEnum {
    NO(0, "无遮罩"),
    OVER(1,"已抢完"),
    VIP(2,"指定门店专享"),
    NOT_BUY(3,"暂不可买"),
    NOT_SHARE(4,"不可分享"),
    ;

    private int code;
    private String desc;

    TypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static String getValue(int code){
        for(TypeEnum c:values()){
            if(c.code == code){
                return c.desc;
            }
        }
        return "";
    }
}
