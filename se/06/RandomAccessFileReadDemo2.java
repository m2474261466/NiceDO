package day05;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileReadDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("demo2.txt", "r");
		byte[] bs=new byte[100];
		int n=raf.read(bs);//读取100个字节并存放在bs字节数组中，返回的是实际读到的字节数据量
		System.out.println(n);
		//把读取出来的字节转换为字符串
		String str=new String(bs,"gbk");
		System.out.println(str);
		raf.close();
	}
}
