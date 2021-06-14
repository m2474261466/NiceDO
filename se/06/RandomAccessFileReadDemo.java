package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * 使用RandomAccessFile读取文件中的数据
 * RandomAccessFile提供了read()方法，返回int
 */
public class RandomAccessFileReadDemo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("demo.txt","r");
		int len=-1;//保存读取到的每一个字节
		while((len=raf.read())!=-1){//数据读到-1时则读到文件的末尾
			System.out.print(len);
			System.out.print((char)len);
		}
		raf.close();
	}
}
