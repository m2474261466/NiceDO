package day07;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * ��������
 * ��������һ�ָ߼��������Է������ǽ�java�е��κζ�����ж�д������
 * java.io.objectoutputstream
 * ��������������Խ�����ת��Ϊһ���ֽ�д��
 * 
 * java.io.objectinputstream
 * ���������������Զ�ȡһ���ֽ�ת��Ϊԭ���󣬻�ԭΪԭ�����������
 * ��ȡ����ֽ�Ӧ���Ƕ����������һ������ת�����ֽ�
 */
public class Objectoutputstream {
	public static void main(String[] args) throws IOException {
		Student pdd=new Student();
		pdd.setName("�����");
		pdd.setAge(18);
		pdd.setGender('��');
		System.out.println(pdd.toString());
		
		//�ļ������
		FileOutputStream fos=new FileOutputStream("stu.txt");
		//���������
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		/**
		 * ObjectOutputStream �ṩ��writeObject(object obj)��
		 * oos������ת��Ϊ�ֽں� �������ֽڽ���fosд���ı�����д��Ӳ�̣�
		 * ������̳�֮Ϊ�����ݳ־û�����
		 * oos�������Ķ���pddתΪһ���ֽڣ�������̳�֮Ϊ���������л�����
		 */
		oos.writeObject(pdd);
		System.out.println("д����ϣ���");
		oos.close();
	}
}
