package day04;

import java.io.File;

/*
 * �������Ŀ¼
 * File�ṩ��mkdirs����
 */
public class CreateMkdirsDemo {
	public static void main(String[] args) {
		File file=new File("a/b/c/d/e/f");
		if(!file.exists()){
			file.mkdirs();//�������Ŀ¼
			System.out.println("�����ɹ�");
		}else{
			System.out.println("��Ŀ¼�Ѿ�����");
		}
	}
}
