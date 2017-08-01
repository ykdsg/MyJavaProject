package com.hz.yk.io.nio.reactor.connection;

import com.hz.yk.io.nio.reactor.Reactor;

import java.nio.channels.SocketChannel;


/**
 * 
 * <pre><b>the default connection factory.</b></pre>
 * @author 
 * <pre>seaboat</pre>
 * <pre><b>email: </b>849586227@qq.com</pre>
 * <pre><b>blog: </b>http://blog.csdn.net/wangyangzhizhou</pre>
 * @version 1.0
 */
public class DefaultConnectionFactory implements ConnectionFactory {

	public Connection createConnection(SocketChannel channel, long id,
			Reactor reactor) {
		return new Connection(channel, id, reactor);
	}

}
