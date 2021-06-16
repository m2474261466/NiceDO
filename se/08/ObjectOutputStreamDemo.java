package day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ��������
 * ��������һ�ָ߼��������Է������ǽ�java���κζ�����ж�д������
 * java.io.ObjectOutputStream
 * ��������������Խ�����ת��Ϊһ���ֽ�д��
 * 
 * 
 * java.io.ObjectInputStream
 * ���������������Զ�ȡһ���ֽڽ���ԭ���󣬻�ԭΪ�����������
 * ��ȡ�����ֽ�Ӧ���Ƕ����������һ������ת�����ֽ�
 * 
 * 
 * @author 24742
 *
 */
public class ObjectOutputStreamDemo {
           public static void main(String[] args) throws IOException {
        	   Student stu=new Student();
        	   stu.setAge(18);
        	   stu.setName("����");
        	   stu.setGender('��');
        	   //�ֽ������
        	   FileOutputStream fos=new FileOutputStream("stu.txt");
        	   //���������
        	   ObjectOutputStream oos=new ObjectOutputStream(fos);
        	   /*
        	    * OutputStream�ṩ��writeObject(Object obj)
        	    * oos������ת��Ϊ�ֽں������ֽڽ���fosд���ļ�����д�뵽
        	    * Ӳ�̣�������̳�֮Ϊ�����ݳ־û�����
        	    * oos�������Ķ���stuתΪһ���ֽڣ�������̳�֮λ���������л�����
        	    */
        	   //���л�
        	   oos.writeObject(stu);
        	   System.out.println("д�����");
        	   oos.close();
        	 
        	  
        	   
        	   
        	   
		}   
 
}
