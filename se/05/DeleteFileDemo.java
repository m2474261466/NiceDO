package day04;

import java.io.File;

/**
 * ɾ��һ���ļ���
 * File�ṩ��delete������ɾ���ļ�file
 * @author Thinkpad
 *
 */
public class DeleteFileDemo {
	public static void main(String[] args) {
		File file =new File("./demo.txt");
		if(!file.exists()){
			System.out.println("�޷�ɾ�����ļ�����");
		}else{
			file.delete();
			System.out.println("ɾ����ϣ�");
		}
	}
}