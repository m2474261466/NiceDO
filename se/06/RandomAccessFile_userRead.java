package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import day01.string;

/**
 *��ȡ�����û������ݡ�
 *����ȡ�������û������Ը�ʽname��pwd��nick��age�����
 * @author Thinkpad
 *
 */
public class RandomAccessFile_userRead {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("user.dat","r");
		byte[] bs=new byte[32];
		for(int i=0;i<raf.length()/100;i++){
			raf.read(bs);
			//��ȡ����
			String name=new String(bs,"utf-8").trim();
			
			//��ȡ����
			raf.read(bs);
			String pwd=new String(bs,"utf-8").trim();
			
			//��ȡ�ǳ�
			raf.read(bs);
			String nick=new String(bs,"utf-8").trim();
			
			//��ȡ����
			int ag=raf.readInt();//��ȡ��int����4�ֽ�
			System.out.println(name +"   "+pwd+"  "+nick+"   "+ag);
			System.out.println(raf.getFilePointer());//��ȡָ��λ��
		}
		raf.close();
	}
}
