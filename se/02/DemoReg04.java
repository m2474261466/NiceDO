package day02;

import java.util.Scanner;

public class DemoReg04 {
	public static void main(String[] args) {
		/*
		 *�û�ע��
		 *�˺ţ�Ҫ��5-10���ַ�
		 *���룺Ҫ��6-8���ַ�
		 *���䣺���������ʽ
		 *�ֻ�:11λ���֣���λ��1��ʼ��
		 */
		System.out.println("��ӭ�����û�ע�����");
		System.out.println("�����������˺ţ�");
		String passwReg="^\\w{5,10}$";
		Scanner scanner=new Scanner(System.in);
		//�����˺�
		String passwReg1=scanner.next();
		if(!passwReg1.matches(passwReg)){
			System.out.println("��������ȷ���˺�");
			return;			
		}
		//��������
		System.out.println("��������������");		
		String passReg="^\\w{6,8}$";
		String passReg1=scanner.next();
		if(!passReg1.matches(passReg)){
			System.out.println("��������ȷ������");
			return;
		}
		//ȷ������
          System.out.println("���ٴ���������");
		String userConfirm=scanner.next();
		if(!passReg1.equals(userConfirm)){
			System.out.println("���벻һ��");
			return;
		}
		//��������
		System.out.println("��������������");		
		String  mailReg="\\w{4,18}@[a-z]{1,}\\.[a-z]{2,4}$";
		String mailReg1=scanner.next();
		if(!mailReg1.matches(mailReg)){
			System.out.println("��������ȷ������ĵ�ַ");
			return;
		}
		//�����ֻ���
		System.out.println("�����������ֻ�����");
		String  phoneReg="^ 1\\d{10}$";
		String phoneReg1=scanner.next();
		if(phoneReg.matches(phoneReg)==true){
			System.out.println("��������ȷ���ֻ�����");
			return;
		}else{
			System.out.println("ע��ɹ�");
		}
		
		
		
		
		
		
		
		
		
		
	}

}
