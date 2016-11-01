package com.hz.yk.io.generic.filter;

import com.hz.yk.io.generic.Output;
import com.hz.yk.io.generic.Receiver;
import com.hz.yk.io.generic.Sender;

/**
 * @author wuzheng.yk
 *         Date: 13-4-20
 *         Time: 上午9:35
 */
public class Filters {
    static class SpecificationOutputWrapper<T, ReceiverThrowableType extends Throwable>
            implements Output<T, ReceiverThrowableType> {

        final Output<T, ReceiverThrowableType> output;
        final Specification<T> specification;

        public SpecificationOutputWrapper(Output<T, ReceiverThrowableType> output, Specification<T> specification) {
            this.output = output;
            this.specification = specification;
        }

        public <SenderThrowableType extends Throwable> void receiveFrom(Sender<T, SenderThrowableType> sender)
                throws ReceiverThrowableType, SenderThrowableType {
            output.receiveFrom(new SpecificationSenderWrapper<T, SenderThrowableType>(sender, specification));
        }
    }

    static class SpecificationSenderWrapper<T, SenderThrowableType extends Throwable>
            implements Sender<T, SenderThrowableType> {

        final Sender<T, SenderThrowableType> sender;
        final Specification<T> specification;

        public SpecificationSenderWrapper(Sender<T, SenderThrowableType> sender, Specification<T> specification) {
            this.sender = sender;
            this.specification = specification;
        }

        public <ReceiverThrowableType extends Throwable> void sendTo(Receiver<T, ReceiverThrowableType> receiver)
                throws ReceiverThrowableType, SenderThrowableType {
            sender.sendTo(new SpecificationReceiverWrapper<T, ReceiverThrowableType>(receiver, specification));
        }
    }

    static class SpecificationReceiverWrapper<T, ReceiverThrowableType extends Throwable>
            implements Receiver<T, ReceiverThrowableType> {

        final Receiver<T, ReceiverThrowableType> receiver;
        final Specification<T> specification;

        public SpecificationReceiverWrapper(Receiver<T, ReceiverThrowableType> receiver, Specification<T> specification) {
            this.receiver = receiver;
            this.specification = specification;
        }

        public void receive(T item) throws ReceiverThrowableType {
            if(specification.test(item)) {
                receiver.receive(item);
            }
        }

    }

    public static <T, ReceiverThrowableType extends Throwable> Output<T, ReceiverThrowableType> filter(Specification<T> specification, final Output<T, ReceiverThrowableType> output) {
        return new SpecificationOutputWrapper<T, ReceiverThrowableType>(output, specification);
    }
}
