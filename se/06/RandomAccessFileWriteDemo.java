package day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * RandomAccessFile
 * �������ָ��������д�ļ�����
 * ����RandomAccessFile���õĹ��췽����
 * RandomAccessFile��String path��String mode��
 * RandomAccessFile��File file��string mode��
 * ��һ��������Ҫ���ж�д���ļ�
 * �ڶ�������ΪȨ��
 * r��ֻ��ģʽ  ���磺 RandomAccessFile raf=new RandomAccessFile(file, "r");
 * rw����дģʽ  ���磺RandomAccessFile raff=new RandomAccessFile("demo2.txt", "rw");
 */
public class RandomAccessFileWriteDemo {
	public static void main(String[] args) throws IOException {
		//��ʽһ��RandomAccessFile��String path��String mode��
//		File file=new File("./demo");
//		RandomAccessFile raf=new RandomAccessFile(file, "r");
//		System.out.println("ִ�����");
		
		//��ʽ����RandomAccessFile��File file��string mode��
		RandomAccessFile raff=new RandomAccessFile("demo2.txt", "rw");
		System.out.println("ִ����ϣ�");
		
		/*
		 * RandomAccessFile�ṩ��void write��int d����
		 * ���ļ���д��һ���ֽ����ݣ�д���Ǹ���intֵ����Ӧ�Ķ����Ƶġ��Ͱ�λ��
		 * 000000000 00000000 00000000 00000001
		 * 
		 * ���磺97תΪ������11000011�����ڳ��ñ��������ڿ���ʱ��
		 * ���ֽ���ʾ����ѯASCII���룬����ʾa������ֵ���ѯϵͳĬ�ϵ���
		 */
		
		raff.write(65);
		System.out.println("д����ϣ�");
		
		/*
		 * RandomAccessFile���ļ����ʵĲ���ȫ��������ʱ��Ҫ����close����������
		 * �ͷ�����ϵͳ��Դ
		 */
		
		raff.close();
	}
}
