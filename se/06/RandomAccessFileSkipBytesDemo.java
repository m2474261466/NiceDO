package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile�ṩ��һ�������ֽ�����
 * skipBytes(int n)
 * @author 24742
 *
 */
public class RandomAccessFileSkipBytesDemo {
    public static void main(String[] args) throws IOException {
		RandomAccessFile raf= new RandomAccessFile("demo.text","r");
		byte[] bs=new byte[20];
		int n=raf.skipBytes(5);//ָ������5���ֽ�
		int len= raf.read(bs);
		String str=new String(bs,0,len);
		System.out.println(str);
		raf.close();
	}
  
}
