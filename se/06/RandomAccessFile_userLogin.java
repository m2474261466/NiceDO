package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * �û���¼���ܣ������¼�ɹ���ʾ���û���������Ϣ
 * 
 * @author 24742
 *
 */
public class RandomAccessFile_userLogin {
	public static void main(String[] args) throws IOException  {
		RandomAccessFile raf=new RandomAccessFile("user.dat","r");
		System.out.println("�û���¼��");
		Scanner scanner=new Scanner(System.in);
		System.out.println("�������û���");
		String userName=scanner.next();
		System.out.println("����������");
		String userPassword=scanner.next();
		byte[] bs=new byte[32];
		boolean nameFlag=false;//�ж��û��˺��Ƿ���ȷ
		boolean pwdFlag=false;//�ж��û������Ƿ���ȷ
		for(int i=0;i<raf.length()/100;i++){
			//����ָ��λ��
			raf.seek(i*100);
          System.out.println("ָ���λ��Ϊ��"+raf.getFilePointer());
          //��ȡ�˺�
          raf.read(bs);
          String name=new String(bs,"UTF-8").trim();
          //�ж��û�������˺ź��ı��е��˺��Ƿ�һ��
          if(name.equals(userName)){
        	nameFlag=true;
        	//��ȡ����
        	raf.read(bs);
        	String password=new String(bs,"UTF-8").trim();
        	if(password.equals(userPassword)){
        		pwdFlag=true;
        		System.out.println("��¼�ɹ�");
        		//��ȡ�ǳ�
        		raf.read(bs);
        		String nick=new String(bs,"UTF-8").trim();
        		raf.read(bs);
        		int age=raf.readInt();
        		System.out.println("�û�����Ϣ�ǣ��˺�"+name+",����"+password+",�ǳ�"+",����"+age);
        		
        	}
        	break;
          }
		}
		if(nameFlag==false){
			System.out.println("�������");
			return;
		}
		if(pwdFlag==false){
			System.out.println("�������");
			return;
		}
		raf.close();
	}

}
