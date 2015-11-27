package com.hz.yk.yk.ssh.sshj;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.IOUtils;
import net.schmizz.sshj.connection.channel.direct.Session;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 这个还可以，功能比较强大
 * https://github.com/hierynomus/sshj
 * Created by wuzheng.yk on 15/11/3.
 */
public class Exec {
    public static void main(String... args)
            throws IOException {
        final SSHClient ssh = new SSHClient();
        ssh.loadKnownHosts();

        ssh.connect("test.ssh");
        ssh.authPassword("admin","Yangtuojia001");
        try {
            final Session session = ssh.startSession();
            try {
                final Session.Command cmd = session.exec("ping -c 1 www.baidu.com");
                System.out.println(IOUtils.readFully(cmd.getInputStream()).toString());
                cmd.join(5, TimeUnit.SECONDS);
                System.out.println("\n** exit status: " + cmd.getExitStatus());
            } finally {
                session.close();
            }
        } finally {
            ssh.disconnect();
        }
    }
}
