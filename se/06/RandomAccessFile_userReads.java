package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ��ȡ�����û�������
 * ����ȡ�����������û�����������Ը�ʽname,password,nick,age���
 * @author 24742
 *
 */
public class RandomAccessFile_userReads {
	public static void main(String[] args) throws IOException {
    RandomAccessFile raf=new RandomAccessFile("user.dat","r"); 
    byte[ ] bs=new byte[32];
    for(int i=0;i<raf.length()/100;i++){
    	//��ȡ����
    	raf.read(bs);
    	String name=new String(bs,"UTF-8").trim();
    	
    	//��ȡ����
    	raf.read(bs);
    	String password=new String(bs,"UTF-8").trim();
    	
    	//��ȡ�ǳ�
    	raf.read(bs);
    	String nick=new String(bs,"UTF-8").trim();
    	
    	//��ȡ����
    	int age=raf.readInt();//��ȡ��int���ͣ�4���ֽڣ�
    	
       System.out.println("����Ϊ"+name+",����Ϊ"+password+"���ǳ�Ϊ"+nick+"����Ϊ"+age);
       System.out.println("ָ��λ��Ϊ��"+raf.getFilePointer());

      }
     raf.close();
	}
  }
