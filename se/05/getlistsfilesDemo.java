package day04;

import java.io.File;

/*
 * ��ȡһ��Ŀ¼�����������file���ṩ��listFile��������������File���飬
 * �ɷ��ص�ǰĿ¼���������
 * ��ǰĿ¼�¿�����"./"����"."
 * 
 * 
 * boolean isFile()�жϵ�ǰfile�Ƿ��ʾΪ�ļ�
 * boolean isDirectory()�ж���ǰFile�Ƿ���Ŀ¼
 * 
 * 
 * 
 */
public class getlistsfilesDemo {
	public static void main(String[] args) {
		//�ڵ�ǰĿ¼�»�ȡ���е�����
		File file=new File("./");
		File[] files=file.listFiles();
		System.out.println(files.length);
		
		for(int i=0;i<files.length;i++){
			if(files[i].isFile()){
				System.out.println("�ļ�����"+files[i].getName());
			}
			
			if(files[i].isDirectory()){
				System.out.println("Ŀ¼����"+files[i].getName());
			}
		}
		
	}
}
