package day02;

import java.util.Scanner;

public class DemoReg4 {
	public static void main(String[] args) {
		/*����ҵ��
		 * �û�ע��
		 * �˺ţ�5-10���ַ�
		 * ���룬6-8���ַ�
		 * ȷ�����룻
		 * ���䣬���������ʽ
		 * �ֻ���11λ��1��ͷ��
		 */
		
		
		//�˺�
		Scanner scanner=new Scanner(System.in);
		String account="^\\w{5,10}$";
		System.out.println("�˺ţ�");
		String username=scanner.next();
		if(!username.matches(account)){
			System.out.println("��淶�����˺ţ�����");
			return;
		}
		
		
		//����
		String password="^\\w{6,8}$";
		System.out.println("���룺");
		String inputword=scanner.next();
		if(!inputword.matches(password)){
			System.out.println("��淶�������룡����");
			return;
		}
		
		
		
		//ȷ������
		System.out.println("���ٴ��������룺");
		String pwd=scanner.next();
		if(!pwd.equals(inputword)){
			System.out.println("�����벻һ�£�");
			return;
		}
		
		
		//�����ʽ��"chao12345678912@qq869.com";
		String email="^[a-z0-9]{11,18}@[a-z0-9]{4,}\\.[a-z]{3,5}$";
		System.out.println("���䣺");
		String emailword=scanner.next();
		if(!emailword.matches(email)){
			System.out.println("��淶�������䣡��");
			return;
		}
		
		//�ֻ���
		String phone="^1\\d{10}$";
		System.out.println("�ֻ��ţ�");
		String phonenumber=scanner.next();
		if(!phonenumber.matches(phone)){
			System.out.println("��淶�����ֻ��ţ���");
			return;
		}
		
		System.out.println("ע��ɹ�����");
	}
}
