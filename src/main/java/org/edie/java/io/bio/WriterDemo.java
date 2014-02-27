package org.edie.java.io.bio;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class WriterDemo {

	public static void main(String[] args) throws Exception { // 异常抛出， 不处理
		// 准备好一个输出的对象
		Writer out = null;
		try{
			// 第1步：使用File类找到一个文件
			File f = new File("d:" + File.separator + "test.txt");// 声明File 对象
			// 第2步：通过子类实例化父类对象
			out = new FileWriter(f);
			// 通过对象多态性进行实例化
			// 第3步：进行写操作
			String str = "Hello World!!!";
			// 准备一个字符串
			out.write(str);// 将内容输出
		}finally{
			// 第4步：关闭输出流
			 out.close();
		}
	}
}
