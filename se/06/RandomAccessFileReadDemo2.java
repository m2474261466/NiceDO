package day05;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileReadDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("demo2.txt", "r");
		byte[] bs=new byte[100];
		int n=raf.read(bs);//��ȡ100���ֽڲ������bs�ֽ������У����ص���ʵ�ʶ������ֽ�������
		System.out.println(n);
		//�Ѷ�ȡ�������ֽ�ת��Ϊ�ַ���
		String str=new String(bs,"gbk");
		System.out.println(str);
		raf.close();
	}
}
