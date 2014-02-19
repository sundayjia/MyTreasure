package org.edie.java.io.nio;

/*
 * 写文件
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutputStreamDemo {
	public static void main(String[] args) throws Exception { // 异常抛出， 不处理
		OutputStream out = null;
		// 准备好一个输出的对象
		try {
			// 第1步：使用File类找到一个文件
			File f = new File("d:" + File.separator + "test.txt"); // 声明File 对象
			// 第2步：通过子类实例化父类对象
			out = new FileOutputStream(f);
			// 通过对象多态性进行实例化
			// 第3步：进行写操作
			String str = "Hello World!!!";
			// 准备一个字符串
			byte b[] = str.getBytes();
			// 字符串转byte数组
			out.write(b);
			// 将内容输出
		} finally {
			// 第4步：关闭输出流
			out.close();
			// 此时没有关闭
		}
	}
}
