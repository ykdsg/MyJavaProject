package com.hz.yk.drools.fact;

/**
 * Created by wuzheng.yk on 15/10/28.
 */
public class OrderItem {
    /**
     * 参与的促销类型
     */
    private PromotionType promotionType;
    /**
     * 实际用户购买的数量
     */
    private int qty;
    /**
     * 将产生的赠品的数量
     */
    private int rewardQty;
    public PromotionType getPromotionType() {
        return promotionType;
    }
    public void setPromotionType(PromotionType promotionType) {
        this.promotionType = promotionType;
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
    public int getRewardQty() {
        return rewardQty;
    }
    public void setRewardQty(int rewardQty) {
        this.rewardQty = rewardQty;
    }
    public enum PromotionType {
        ORDINARY,
        STAIR;
    }
}
