package day06;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import day01.string;

/* 2:׷�Ӳ���,���ļ���������ȫ������,�Ӹ��ļ�ĩβ׷������
* FileOutputStream(String path,boolean append)
* FileOutputStream(File file,boolean append)
* appendĬ��Ϊfalse��������Ϊtrue�������ļ�ĩβ����׷�ӡ�
*/
public class FileOutputStreamDemo2 {
	public static void main(String[] args) throws IOException {
		FileOutputStream bos=new FileOutputStream("fos.txt",true);
		String str="��Ҵ��";
		byte[] bs=str.getBytes("UTF-8");
		bos.write(bs);
		System.out.println();
		bs.clone();
	}
}
