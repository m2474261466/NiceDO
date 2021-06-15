package day06;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 转换流：
 * java.io.InputStreamReader
 * java.io.OutStreamWriter
 * java提供了其他高级字符流都有一个特点就是只能连接在其他字符流上，但是通常低级流
 * 都是字节流，这就导致字符流不能直接搭配字节流，但是转换流例外，它们本身就是字符流，
 * 而他们可以连接字符流又可以连接字符流，所以在实际开发中当我们使用高级的字符流时，
 * 通常于字节流连接时需要使用转换流，它起到了“承上启下”的作用
 * 提供的构造方法如下：
 * OutputStreamWriter(OutputStream out)
 * OutputStreamWriter(OutputStream out,String charset)
 * 
 * 
 * OutputStreamWriter(InputStream in)
 * OutputStreamWriter(InputStream in,String charset)
 * @author 24742
 *charset:字符集
 */
public class OutputStreamWriteDemo {
  public static void main(String[] args) throws IOException {
	//输出文件流
	  FileOutputStream fos=new FileOutputStream("osw.txt",true);//后面加了true才可以追加，否则则是覆盖
	  //转换流
	 OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
	 String str="大哥";
	 osw.write(str);//通过转换流直接写入文本，但是其本质还是通过底层的字节流写入的，只是转换流代做了
	 System.out.println("写入完成");
	 osw.close();
   }
}
