package com.hz.yk.builder;

/**
 * 存在继承关系的builder模式。
 *
 * @author wuzheng.yk
 * @date 2020/9/18
 */
public class TextMessage extends BaseMessage {

    private static final String MSGTYPE = "text";
    private String text;

    public static void main(String[] args) {
        String content = "你的快递已到，请携带工卡前往邮件中心领取。\n出发前可查看<a href=\"http://work.weixin.qq.com\">邮件中心视频实况</a>，聪明避开排队。";
        TextMessage msgBody = TextMessage.builder().touser("UserID1|UserID2|UserID3").toparty("PartyID1|PartyID2")
                .totag("TagID1 | TagID2").agentid(1).safe(0).text(content).build();
        // do something

    }

    public TextMessage(String text) {
        super(MSGTYPE);
        this.text = text;
    }

    public TextMessage(TextMessageBuilder builder) {
        //调用的是父类的构造方法  public <T extends BaseMessageBuilder> BaseMessage(BaseMessageBuilder builder)
        super(builder);
        this.text = builder.text;
    }

    public static TextMessageBuilder builder() {
        return new TextMessageBuilder(MSGTYPE);
    }

    public String getText() {
        return text;
    }

    /**
     * 如果先赋值子类的属性 则返回的是子类的WorkWeiXinContentTextBuilder ,如果先赋值父类的属性 不加泛型的话  返回的是父类的 BaseMessageBuilder 无法转换为子类对象 WorkWeiXinContentText
     */
    public static class TextMessageBuilder extends BaseMessageBuilder<TextMessageBuilder> {

        private String text;

        TextMessageBuilder(String msgtype) {
            super(msgtype);
        }

        public TextMessageBuilder text(String text) {
            this.text = text;
            return this;
        }

        public TextMessage build() {
            return new TextMessage(this);
        }
    }
}
