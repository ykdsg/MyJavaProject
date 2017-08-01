package com.hz.yk.io.nio.reactor.handler;

import com.hz.yk.io.nio.reactor.connection.Connection;

import java.io.IOException;


/**
 * 
 * @author seaboat
 * @date 2016-08-25
 * @version 1.0
 * <pre><b>email: </b>849586227@qq.com</pre>
 * <pre><b>blog: </b>http://blog.csdn.net/wangyangzhizhou</pre>
 * <p>This Handler will be call when there is a data having be ready.</p>
 */
public interface Handler {

	public void handle(Connection connection) throws IOException;

}
