package day02;

import java.util.Scanner;

public class DemoReg03 {
     public static void main(String[] args) {
		/*
		 * ƥ���ֻ���
		 */
    	 /*
    	  * +0086 15829216986
    	  * (+86����+0086) ?15829216986
    	  */
    	 /*
    	  * ����()���Խ�һϵ��������ʽ����һ������
    	  * ����ʱ����ʹ�á�|����ʾ��
    	  * 
    	  * ��^���͡�$��
    	  * "^"�����ַ�����ʼ
    	  * ��$�������ַ�������
    	  */
    	 String phoneReg="^(\\+86|\\+0086)?\\s\\d{11}$";
    	 System.out.println("15829216986".matches(phoneReg));
    	 
    	 
    	 /*
    	  * ƥ������
    	  */
    	 String mailReg="^\\w{4,18}@[a-z0-9]{1,}\\.[a-z]{2,4}$";
    	 Scanner scanner=new Scanner(System.in);
    	 String mail=scanner.next();
    	 if(mail.matches(mailReg)==true){
    		 System.out.println("����ͨ��");
    	 }else{
    		 System.out.println("��������ȷ�������ַ��лл");
    	 }
    	 
    	 
    	 
    	 
    	 
	}
}
