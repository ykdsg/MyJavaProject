package com.hz.yk.io.nio.reactor;

import org.junit.Test;

import java.net.Socket;

public class SocketClient {

	@Test
	public void visit() {
		for(int i = 0 ; i <= 100; i++){
			new Thread(){
				public void run(){
					try {
						Socket socket = new Socket("127.0.0.1", 6789);
						for (;;) {
							socket.getOutputStream().write(new byte[] { 1, 2, 3, 4, 5 });
							Thread.currentThread().sleep(100);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				};
			}.start();;
		}
		while(true){
			try {
				Thread.currentThread().sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
