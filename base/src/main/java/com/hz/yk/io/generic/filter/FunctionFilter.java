package com.hz.yk.io.generic.filter;

import com.hz.yk.io.generic.Output;
import com.hz.yk.io.generic.Receiver;
import com.hz.yk.io.generic.Sender;

/**
 * @author wuzheng.yk
 *         Date: 13-4-20
 *         Time: 上午10:11
 */
public class FunctionFilter {
    private FunctionFilter(){}


    static class FunctionOutputWrapper<From, To, ReceiverThrowableType extends Throwable>
            implements Output<From, ReceiverThrowableType> {

        final Output<To, ReceiverThrowableType> output;
        final Function<From, To> function;

        public FunctionOutputWrapper(Output<To, ReceiverThrowableType> output, Function<From, To> function) {
            this.output = output;
            this.function = function;
        }

        public <SenderThrowableType extends Throwable> void receiveFrom(Sender<From, SenderThrowableType> sender)
                throws ReceiverThrowableType, SenderThrowableType {
            output.receiveFrom(new FunctionSenderWrapper<From, To, SenderThrowableType>(sender, function));
        }
    }

    static class FunctionSenderWrapper<From, To, SenderThrowableType extends Throwable> implements Sender<To, SenderThrowableType> {
        final Sender<From, SenderThrowableType> sender;
        final Function<From, To> function;

        public FunctionSenderWrapper(Sender<From, SenderThrowableType> sender, Function<From, To> function) {
            this.sender = sender;
            this.function = function;
        }

        public <ReceiverThrowableType extends Throwable> void sendTo(Receiver<To, ReceiverThrowableType> receiver)
                throws ReceiverThrowableType, SenderThrowableType {
            sender.sendTo(new FunctionReceiverWrapper<From, To, ReceiverThrowableType>(receiver, function));
        }
    }

    static class FunctionReceiverWrapper<From, To, ReceiverThrowableType extends Throwable>
            implements Receiver<From, ReceiverThrowableType> {

        final Receiver<To, ReceiverThrowableType> receiver;
        final Function<From, To> function;

        public FunctionReceiverWrapper(Receiver<To, ReceiverThrowableType> receiver, Function<From, To> function) {
            this.receiver = receiver;
            this.function = function;
        }

        public void receive(From item) throws ReceiverThrowableType {
            receiver.receive(function.map(item));
        }

    }

    public static <From, To, ReceiverThrowableType extends Throwable> Output<From, ReceiverThrowableType> filter(Function<From, To> function, final Output<To, ReceiverThrowableType> output) {
        return new FunctionOutputWrapper<From, To, ReceiverThrowableType>(output, function);
    }
}
