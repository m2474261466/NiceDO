package day04;

import java.io.File;

/*
 * ͨ��Fil��ȡ�ļ���Ϣ
 */
public class FileMessageDemo {
	public static void main(String[] args) {
		File file=new File("demo.txt");
		//��ȡ���֣�file�ṩ��getname������ȡ�ļ�����Ŀ¼����
		String name=file.getName();
		System.out.println(name);
		
		
		//��ȡ�ļ������ֽڳ��ȣ�File�ṩ��lengthh������ȡ�ļ����ݻ���Ŀ¼����
		long length=file.length();
		System.out.println(length);
		
		
		//�Ƿ�ɶ���д
		boolean c=file.canRead();
		System.out.println(c);
		boolean c2=file.canWrite();
		System.out.println(c2);
	}
}
