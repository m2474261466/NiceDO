package day04;

import java.io.File;

/*
 * ɾ��Ŀ¼
 * ɾ��Ŀ¼��һ��ǰ�ᣬҲ���Ǹ�Ŀ¼������һ���հ�Ŀ¼�ſ���ɾ��
 */
public class DeleteMkdirDemo {
	public static void main(String[] args) {
		File file=new File("demo/dd.txt");//ɾ���ļ�
		File file2=new File("demo");//ɾ��Ŀ¼
		if(file.exists()){
			file.delete();
			file2.delete();
			System.out.println("ɾ�����");
		}else{
			System.out.println("Ŀ¼������");
		}
	}
}
