package day06;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * 字符流
 * java将流按照读写单位划分为字节流和字符流
 * inputStream和OutputStream是所有字节流的父类
 * 字符流只是方便我们读写字符，底层本质还是读写字节，只是字节与字符的转换
 * 工作交给了转换流来完成
 * PrintWriter:字符输出流：提供了构造方法如下：
 * PrintWriter(String path)
 * PrintWriter(Filefile)
 * PrintWriter(Writer writer,Boolean,autoflush)
 * PrintWriter(String path,String charset)
 * charset:编码格式
 * writer：转换流
 * autoflush:自动行刷新
 * 
 * PrintWriter的构造方法中假如第一个参数为流，那么就支持一个重载的构造方法，
 * 允许再传入一个boolean值类型的参数，假如该值为ture，则具有自动行刷新
 * 功能 就是每当使用println（）方法时写出一行字符串后就会自动flush
 * @author 24742
 *
 */
public class WriterDemo {
   public static void main(String[] args) throws FileNotFoundException {
	  //字符输出流
	   PrintWriter pw=new PrintWriter("pw.txt");
	   pw.print("但是很多倍叠加");
	   System.out.println("写入完毕");
	 //pw.flush();//强制刷新
	 pw.close();//自带强制刷新
     }
}
