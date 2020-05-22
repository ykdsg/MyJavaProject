package com.hz.yk.practice.general.io;

/**
 * 封装带来了信息的隐藏，带来的问题是如果需要增加另一维度的信息，需要将信息一级一级的透传下去，虽然中间很多链路其实并不需要这块信息。
 * 装饰器模式实现的这块功能对原来没有侵入，但是带来的问题是这条链路上所有的类都需要对应的装饰器，这个成本也不小。
 * 如果有上下文信息可以通过上下文进行透传，但是上下文会带来另一个问题，如果什么信息都通过上下文传递会导致上下文内容急剧增大，对内存是不小负担。
 *
 * @author wuzheng.yk
 * @date 2020/3/10
 */
public class Transforms {

    public static <T, ReceiverThrowableType extends Throwable> Output<T, ReceiverThrowableType> filter(
            final Specification<T> specification, final Output<T, ReceiverThrowableType> output) {

        return new SpecificationOutputWrapper<>(output, specification);
    }

    static class SpecificationOutputWrapper<T, ReceiverThrowableType extends Throwable>
            implements Output<T, ReceiverThrowableType> {

        private final Output<T, ReceiverThrowableType> output;
        private final Specification<T> specification;

        public SpecificationOutputWrapper(Output<T, ReceiverThrowableType> output, Specification<T> specification) {
            this.output = output;
            this.specification = specification;
        }

        @Override
        public <SenderThrowableType extends Throwable> void receiveFrom(Sender<T, SenderThrowableType> sender)
                throws ReceiverThrowableType, SenderThrowableType {

            output.receiveFrom(new SpecificationSenderWrapper<>(sender, specification));
        }
    }

    static class SpecificationSenderWrapper<T, SenderThrowableType extends Throwable>
            implements Sender<T, SenderThrowableType> {

        private Sender<T, SenderThrowableType> sender;
        private Specification<T> specification;

        public SpecificationSenderWrapper(Sender<T, SenderThrowableType> sender, Specification<T> specification) {
            this.sender = sender;
            this.specification = specification;
        }

        @Override
        public <ReceiverThrowableType extends Throwable> void sendTo(Receiver<T, ReceiverThrowableType> receiver)
                throws ReceiverThrowableType, SenderThrowableType {

            sender.sendTo(new SpecificationReceiverWrapper<>(receiver, specification));
        }
    }

    static class SpecificationReceiverWrapper<T, ReceiverThrowableType extends Throwable>
            implements Receiver<T, ReceiverThrowableType> {

        private Receiver<T, ReceiverThrowableType> receiver;
        private Specification<T> specification;

        public SpecificationReceiverWrapper(Receiver<T, ReceiverThrowableType> receiver,
                                            Specification<T> specification) {
            this.receiver = receiver;
            this.specification = specification;
        }

        @Override
        public void receive(T item) throws ReceiverThrowableType {

            if (specification.test(item)) {
                receiver.receive(item);
            }
        }
    }

}

