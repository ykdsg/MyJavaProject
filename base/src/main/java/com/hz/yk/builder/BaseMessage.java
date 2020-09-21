package com.hz.yk.builder;

/**
 * @author wuzheng.yk
 * @date 2020/9/18
 */
public class BaseMessage {

    private String msgtype;
    private Integer agentid;

    private String touser;
    private String toparty;
    private String totag;
    private Integer safe;

    public BaseMessage(String msgtype) {
        this.msgtype = msgtype;
    }

    public BaseMessage() {
    }

    public <T extends BaseMessageBuilder> BaseMessage(BaseMessageBuilder builder) {
        this.msgtype = builder.msgtype;
        this.agentid = builder.agentid;
        this.touser = builder.touser;
        this.toparty = builder.toparty;
        this.totag = builder.totag;
        this.safe = builder.safe;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public Integer getAgentid() {
        return agentid;
    }

    public String getTouser() {
        return touser;
    }

    public String getToparty() {
        return toparty;
    }

    public String getTotag() {
        return totag;
    }

    public Integer getSafe() {
        return safe;
    }

    /**
     * 在父类中使用泛型 根据调用的子类不同 返回子类对应的Builder
     */
    public static class BaseMessageBuilder<T extends BaseMessageBuilder> {

        private String msgtype;
        private Integer agentid;
        private String touser;
        private String toparty;
        private String totag;
        private Integer safe;

        public BaseMessageBuilder(String msgtype) {
            this.msgtype = msgtype;
        }

        public T agentid(Integer agentid) {
            this.agentid = agentid;
            return (T) this;
        }

        public T touser(String touser) {
            this.touser = touser;
            return (T) this;
        }

        public T toparty(String toparty) {
            this.toparty = toparty;
            return (T) this;
        }

        public T totag(String totag) {
            this.totag = totag;
            return (T) this;
        }

        public T safe(Integer safe) {
            this.safe = safe;
            return (T) this;
        }
    }
}
