package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

/**
 * ����û�ע�Ṧ��
 * ��usd.dat�ļ������û��ļ���Ϣ
 * ÿ���û�����Ϣ�������û��������룬�ǳƣ�����
 * ����������int���ͣ����඼���ַ�������
 * 
 * @author 24742
 *
 */
public class RandomAccessFile_userRegister {
      public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("user.dat","rw");
		raf.seek(raf.length());//����ָ���λ��
		   Scanner scanner=new Scanner(System.in);
		   System.out.println("�������û�����");
		   String name=scanner.next();
		   System.out.println("�������û�����");
		   String password=scanner.next();
		   System.out.println("�������û��ǳ�");
		   String nick=scanner.next();
		   System.out.println("�������û�����");
		   int age=scanner.nextInt();
		
		
		      //�����������д���û�����
	    	    byte[] data1=name.getBytes("UTF-8");
		        data1=Arrays.copyOf(data1, 32);
		        raf.write(data1);
		
		      //�����������д���û�����
				byte[] data2=password.getBytes("UTF-8");
				data2=Arrays.copyOf(data2, 32);
				raf.write(data2);
				
				//�����������д���û�����
				byte[] data3=nick.getBytes("UTF-8");
				data3=Arrays.copyOf(data3, 32);
				raf.write(data3);
				
				//д���û�������
				raf.writeInt(age);
				
				System.out.println("ע��ɹ�");
	
				
				
		
		
	}
}
