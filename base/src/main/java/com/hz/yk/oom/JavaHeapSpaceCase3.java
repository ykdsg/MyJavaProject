package com.hz.yk.oom;

/**
 * Case: per thread occupate some memory,but handle too slow,then OOM
 * 
 * startup args: -Xms20m -Xmx20m -Xmn10m -XX:+HeapDumpOnOutOfMemoryError 
 */
public class JavaHeapSpaceCase3 {

	public static void main(String[] args) throws Exception{
		for (int i = 0; i < 20; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					Case3Object object=new Case3Object();
					object.setName(Thread.currentThread().getName());
					try {
						Thread.sleep(20000);
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

}

class Case3Object{
	private byte[] bytes=null;
	private String name;
	public Case3Object(){
		bytes=new byte[1024*1024];
	}
	public String getName() {
		return name;
	}
	public byte[] getBytes() {
		return bytes;
	}
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	public void setName(String name){
		this.name=name;
	}
}