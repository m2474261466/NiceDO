package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

/**
 * �޸��û�����,ǰ���ǵ�¼�ɹ�֮��ſ��޸�
 * 
 * @author 24742
 *
 */
public class RandomAccessFile_userUpdate {
   public static void main(String[] args) throws IOException {
	RandomAccessFile raf=new RandomAccessFile("user.dat","rw");
	System.out.println("�û���¼");
    Scanner scanner=new Scanner(System.in);
    System.out.println("�������˺�");
    String username=scanner.next();
    System.out.println("����������");
    String userpassword=scanner.next();
    byte[] bs=new byte[32];
    boolean nameFlag=true;
    boolean pwdFlag=false;
    for(int i=0;i<raf.length()/100;i++){
    	raf.seek(i*100);
    	System.out.println("ָ���λ��Ϊ"+raf.getFilePointer());
    	raf.read(bs);
    	String name=new String(bs,"UTF-8").trim();
    	if(name.equals(username)){
    		nameFlag=true;
    	raf.read(bs);
    	String password=new String(bs,"UTF-8").trim();
    	if(password.equals(userpassword)){
    		//�޸�����
    		pwdFlag=true;
    		System.out.println("�޸�����");
    		String newPwd=scanner.next();
    		//����ָ��λ��
    		raf.seek(i*100+32);
    		byte[] bytes=newPwd.getBytes("UTF-8");
    		bytes=Arrays.copyOf(bytes, 32);
    		raf.write(bytes);//�޸ĺ�������ֽ�д���ı���
    		System.out.println("�޸ĳɹ�");
    		
    	   }
    	break;
         }
      }
      if(nameFlag==false){
    	  System.out.println("�˺Ŵ���");
      }
      if(pwdFlag==false){
    	  System.out.println("�������");
         
         
    	  
    	  
      }
     }
   }
