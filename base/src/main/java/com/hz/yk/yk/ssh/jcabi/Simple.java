package com.hz.yk.yk.ssh.jcabi;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;

import com.jcabi.log.Logger;
import com.jcabi.ssh.SSH;
import com.jcabi.ssh.SSHByPassword;
import com.jcabi.ssh.Shell;
import org.apache.commons.io.input.NullInputStream;

/**
 * 对JSch 的包装 ，目前来看使用最简单，但是太简单了
 * https://github.com/jcabi/jcabi-ssh
 * Created by wuzheng.yk on 15/11/3.
 */
public class Simple {
    public static void main(String[] args) throws IOException {
        SSHByPassword sshByPassword = new SSHByPassword(
                "test.ssh", 22,
                "admin", "Yangtuojia001"
        );
        Shell.Plain plain = new Shell.Plain(
                sshByPassword
        );
        String hello = plain.exec("pwd");
        System.out.println(hello);


        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        Shell ssh = new Shell.Verbose(sshByPassword);
        System.out.println(ssh.exec("pwd",new NullInputStream(0L),output, Logger.stream(Level.WARNING, true)));
    }
}
