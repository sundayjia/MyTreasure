package org.edie.java.io.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestReadWriteFile {
	public static void readFile(String path) throws IOException{
		//利用缓冲字符流读
		BufferedReader br = new BufferedReader(new FileReader(path));
		String input;
		while((input = br.readLine())!=null){
			System.out.println(input);
		}
		br.close();
	}
	
	public static  void writeFile(String path) throws IOException{
		//利用缓冲字符流写
		BufferedWriter bw = new BufferedWriter(new FileWriter(path,true));//true 表示是追加写
		bw.write("hello,fw.\n");
		bw.flush();
		bw.close();
	}
	
	public static void main(String args[]) throws IOException{
		
		String path = "D:/test.php";
		writeFile(path);
		readFile(path);
	}

}
