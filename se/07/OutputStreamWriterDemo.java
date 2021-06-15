package day06;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 * 转换流：
 * java.io.InterStreamReader
 * java.io.OutputStreamWriter
 * java提供了其他高级字符流都有一个特点就是只能连接在其他字符流上，但是通常
 * 低级流都是字节流，这就导致了字符流不能直接搭配其他字节流使用，但是转换流除外，
 * 他们本身就是字符流，而它们可以连接字节流又可以连接字符流，所以在实际开发中
 * 当我们使用高级的字符流时通常于字节流连接时需要使用转换流，他起到承上启下的作用.
 * 提供的构造方法如下：
 * OutputStreamWriter（inputstream out）
 * OutputStreamWriter(inputstream out,string charset)
 * 
 * OutputStreamWriter（inputstream in）
 * OutputStreamWriter(inputstream in,string charset)
 * charest：字符集
 */
public class OutputStreamWriterDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos=new FileOutputStream("osw.txt",true);//文件输出流
		OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");//转换流
		String str="刘永超啊";
		osw.write(str);
		System.out.println("写入完毕");
		osw.close();
	}
}
