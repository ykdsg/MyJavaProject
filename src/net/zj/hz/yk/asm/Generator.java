package net.zj.hz.yk.asm;

import java.io.File;
import java.io.FileOutputStream;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class Generator {
	public static void main(String[] args) throws Exception {
		ClassReader cr = new ClassReader("net.zj.hz.yk.asm.Account");
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		ClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw);
		cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
		byte[] data = cw.toByteArray();
		File file = new File(
				"F:/workspace_ganymede/MyProject/bin/net/zj/hz/yk/asm/Account.class");
		FileOutputStream fout = new FileOutputStream(file);
		fout.write(data);
		fout.close();
	}

}
