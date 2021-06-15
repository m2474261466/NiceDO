package day06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * 用转换流读取字符
 * @author 24742
 *
 */
public class InputStreamreaderDemo {
   public static void main(String[] args) throws IOException {
	FileInputStream fis=new FileInputStream("osw.txt");
	InputStreamReader bis=new InputStreamReader(fis,"UTF-8");
	/*int len=-1;//字符串长度为-1
	while((len=bis.read())!=-1){//当len=bis.read()=-1时即读到了末尾
		System.out.println((char)len);//如果直接输出len的话时ASCALL编码组成的，但是加上char之后就是输出的字符串
	}*/
	char[] c=new char[20];
	int n=bis.read(c);//实际读到的字符数量
	String str=new String(c,0,n);
	System.out.println(str);
	bis.close();
 }
}
