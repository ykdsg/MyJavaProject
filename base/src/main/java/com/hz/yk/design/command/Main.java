package com.hz.yk.design.command;

/**
 * 命令模式的优点 <br>
 * 　　●　　更松散的耦合<br>
 * 　　命令模式使得发起命令的对象——客户端，和具体实现命令的对象——接收者对象完全解耦，<br>
 * 也就是说发起命令的对象完全不知道具体实现对象是谁，也不知道如何实现。<br>
 * 　　●　　更动态的控制<br>
 * 　　命令模式把请求封装起来，可以动态地对它进行参数化、队列化和日志化等操作，从而使得系统更灵活。<br>
 * 　　●　　很自然的复合命令<br>
 * 　　命令模式中的命令对象能够很容易地组合成复合命令，也就是宏命令，从而使系统操作更简单，功能更强大。<br>
 * 　　●　　更好的扩展性<br>
 * 　　由于发起命令的对象和具体的实现完全解耦，因此扩展新的命令就很容易，只需要实现新的命令对象，然后在装配的时候，<br>
 * 把具体的实现对象设置到命令对象中，然后就可以使用这个命令对象，已有的实现完全不用变化。<br>
 * Created by wuzheng.yk on 2017/6/22.
 */
public class Main {

    public static void main(String[] args) {
        // 创建接收者对象
        AudioPlayer audioPlayer = new AudioPlayer();
        // 创建命令对象
        Command playCommand = new PlayCommand(audioPlayer);
        Command rewindCommand = new RewindCommand(audioPlayer);
        Command stopCommand = new StopCommand(audioPlayer);
        // 创建请求者对象
        Keypad keypad = new Keypad();
        keypad.setPlayCommand(playCommand);
        keypad.setRewindCommand(rewindCommand);
        keypad.setStopCommand(stopCommand);
        // 测试
        keypad.play();
        keypad.rewind();
        keypad.stop();
        keypad.play();
        keypad.stop();

        // 记录宏命令然后执行
        MacroCommand marco = new MacroAudioCommand();
        marco.add(playCommand);
        marco.add(rewindCommand);
        marco.add(stopCommand);
        marco.execute();
    }
}
