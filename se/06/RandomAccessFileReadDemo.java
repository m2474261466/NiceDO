package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * ʹ��RandomAccessFile��ȡ�ļ��е�����
 * RandomAccessFile�ṩ��read()����������int
 */
public class RandomAccessFileReadDemo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("demo.txt","r");
		int len=-1;//�����ȡ����ÿһ���ֽ�
		while((len=raf.read())!=-1){//���ݶ���-1ʱ������ļ���ĩβ
			System.out.print(len);
			System.out.print((char)len);
		}
		raf.close();
	}
}
