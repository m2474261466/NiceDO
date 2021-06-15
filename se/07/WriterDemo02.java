package day06;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 用流连接的方式使用PrintWriter
 * 
 * 
 * PrintWriter的构造方法中假如第一个参数为流，那么就支持一个重载的构造方法，
 * 允许再传入一个boolean值类型的参数，假如该值为ture，则具有自动行刷新
 * 功能 就是每当使用println（）方法时写出一行字符串后就会自动flush
 * @author 24742
 *
 */
public class WriterDemo02 {
        public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
			
        	//方法一
        	//字节流输出流（文件输出流）
        	//FileOutputStream fos=new FileOutputStream("pw2.txt",true);//假如第一个参数为流，那么就支持一个重载的构造方法，允许再传入一个boolean值类型的参数，假如该值为ture，则具有自动行刷新功能 
        	//转换输出流
        	//OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
        	//字符缓冲输出流
        	//BufferedWriter bw=new BufferedWriter(osw);
        	//字符输出流
        	//PrintWriter pw=new PrintWriter(bw);
        	/*pw.print("刘坤");//因为没有换行，所以没办法强制刷新
        	pw.println("啊哈哈哈哈哈");
        	System.out.println("写入完毕");
        	pw.close();//自带强制刷新*/
        	//方法二
        	PrintWriter bs=new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("pw3.txt",true),"UTF-8")));
        	bs.println("加油");
        	bs.println("lalala");
        	bs.close();
        	
        	
        	
		}
}
