package day06;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/*
 * 用流连接的方式使用PrintWriter
 * 
 *  printWriter的构造方法中若有一个参数为流，那么就支持一个重载的构造方法，
 * 允许再传入一个boolean值类型的参数，若该值为true，则具有自动刷新功能
 * 就是每当使用println（）方法时写出一行字符串后会自动flush
 */
public class WriterDemo2 {
	public static void main(String[] args) throws IOException {
		//字节输出流（文件输出流）
		FileOutputStream fos=new FileOutputStream("pw2.txt",true);
		//转换输出流
		OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
		//字符缓冲输出流
		BufferedWriter bw=new BufferedWriter(osw);
		//字符输出流
		PrintWriter pw=new PrintWriter(bw,true);
		pw.println("刘永超");
		pw.println("马强");
		System.out.println("写入完毕");
		pw.close();
		
		
		
		//规范书写
		PrintWriter pd=new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("pw3.txt",true),"UTF-8")),true);
		pd.println("刘永超");
		pd.close();
	}
}
