package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * 
 */
public class RandomAccessFileWriteDemo2 {
	public static void main(String[] args) throws IOException {
		String str="hello";
		//���ַ���ת��Ϊ�ֽ�
		byte[] b=str.getBytes();
		RandomAccessFile raff=new RandomAccessFile("demo.txt", "rw");
		//����ָ��λ�ã�RAF�ṩ�˻�ȡָ��λ�õķ���seek()
		raff.seek(10);//����ָ��λ��5��׷���ַ���world
		//��ȡָ���λ�ã��α�λ�ã�RAF�ṩ�˻�ȡָ��λ�õķ���getFilePointer()����long
		long p=raff.getFilePointer();
		System.out.println("д��ǰ��λ�ã�"+p);
		raff.write(b);
		System.out.println("д����ϣ�������");
		p=raff.getFilePointer();
		System.out.println("д����ָ��λ�ã�"+p);
		raff.close();
	}
}
