package com.hz.yk.listorset;

/**
 * 0:默认,比如pp用户新注册时没有任何身份为0;当审核为门店时为4,同时为门店+供应商时为4+8
 * 1:C端用户,微小店就是现在的C;
 * 2:小二用户;
 * 4:门店用户;
 * 8:供应商用户;
 * 16:服务商;
 * userCompositeType&4=4 表示用户是门店用户;
 * 当一个用户有多种身份时,如PP既是门店又是供应商,userCompositeType=4+8=12
 *
 * @author 木鸢
 * @create by 2019-10-11 11:49
 */
public enum UserCompositeTypeEnum {

    DEFAULT(0, "默认无身份"),
    C(1, "C端用户"),
    ADMIN(2, "小二"),
    SHOP(4, "门店"),
    SELLER(8, "供应商"),
    HSP(16, "服务商"),
    ;

    private int code;

    private String desc;

    UserCompositeTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static UserCompositeTypeEnum getUserCompositeTypeEnum(Integer userCompositeType) {
        if (userCompositeType == null) {
            return null;
        }
        for (UserCompositeTypeEnum userTypeEnum : UserCompositeTypeEnum.values()) {
            if (userTypeEnum.getCode() == userCompositeType) {
                return userTypeEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
