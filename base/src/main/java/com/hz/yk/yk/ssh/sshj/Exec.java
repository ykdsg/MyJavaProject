package com.hz.yk.yk.ssh.sshj;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.Session;
import org.apache.commons.io.Charsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * 这个还可以，功能比较强大
 * https://github.com/hierynomus/sshj
 * Created by wuzheng.yk on 15/11/3.
 */
public class Exec {
    //static String host = "112.124.123.117";
    //static String user = "admin";
    //static String password = "Yangtuojia001";
    //static String shell = "cd /home/admin/bin&&./test.sh";


    static String host = "120.26.80.217";
    static String user = "root";
    static String password = "Weixinmall001";
    static String shell = "cd /alidata/ci_mall&&./ytmall.test.sh";



    public static void main(String... args)
            throws IOException {
        final SSHClient ssh = new SSHClient();
        ssh.loadKnownHosts();
        //如果没用公钥登录的话需要下面这行代码
        //ssh.addHostKeyVerifier(new PromiscuousVerifier());
        try {
            ssh.connect(host);
            ssh.authPublickey("root");
            //ssh.authPassword(user,password);
            try (Session session = ssh.startSession()) {
                final Session.Command cmd = session.exec(shell);
                InputStreamReader reader = new InputStreamReader(cmd.getInputStream(), Charsets.toCharset("UTF-8"));

                BufferedReader bfReader = new BufferedReader(reader);
                String line = bfReader.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = bfReader.readLine();
                }
                cmd.join(5, TimeUnit.SECONDS);
                System.out.println("\n** exit status: " + cmd.getExitStatus());
            }
        } finally {
            ssh.disconnect();
        }
    }
}
