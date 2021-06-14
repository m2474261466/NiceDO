package day05;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * String提供了构造方法String(byte[] b,int offset,int len,string can);
 * 将给定的字节数组从下标offset连续读取len个
 * 
 * @author 24742
 *
 */
public class RandomAccessFileReadDemo03 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("demo2.txt","r");
		byte[] bs=new byte[100];
		int len=raf.read(bs);
		String str=new String(bs,0,len,"UTF-8");
		System.out.println(str);
		raf.close();
		
	}

}
