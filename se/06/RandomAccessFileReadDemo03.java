package day05;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * String�ṩ�˹��췽��String(byte[] b,int offset,int len,string can);
 * ���������ֽ�������±�offset������ȡlen��
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
