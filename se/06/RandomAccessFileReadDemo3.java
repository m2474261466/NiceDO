package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * string�й��췽��string(byte[] b,int offset,int len ,string scn);
 * ���������ֽ�������±�offset������ȡlen��
 * 
 */
public class RandomAccessFileReadDemo3 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("demo2.txt","r");
		byte[] bs=new byte[100];
		int len=raf.read(bs);
		System.out.println(len);
		String str=new String(bs,0,len,"UTF-8");
		System.out.println(str);
		raf.close();
		
	}
}
