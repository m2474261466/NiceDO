package day04;

import java.io.File;
import java.io.IOException;
/*
 * ����Ŀ¼
 */
public class CreateMkdirDemo {
	public static void main(String[] args) throws IOException {
		File file=new File("./demo");
		if(!file.exists()){
			file.mkdir();//����Ŀ¼
			System.out.println("�����ɹ�");
		}else{
			 System.out.println("�Ѵ���");
		}
		
		File file2=new File("demo/dd.txt");
		if(!file2.exists()){
			file2.createNewFile();//�����ļ�
			System.out.println("�����ɹ�");
		}else{
			System.out.println("�Ѿ�����");
		}
	}
}
