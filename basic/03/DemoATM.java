package day04;

import java.util.Scanner;

/**
 * ����ATM����ϵͳ
 * ��Ŀ����:
 * 1.��������:(������벻��ȷ,�������κ����п�������)
 * 2.���������ȷ,����ȡǮ����ҳ��
 * 3.�˳�ϵͳ
 * 
 * @author Lenovo
 *
 */
public class DemoATM {
	static double remainingSum=19982.89;//���п����
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);		
		int count=3;//������������Ĵ���
		while(true){
			//�������п�����
			String password="123456";
			System.out.println("����������");
			String pwd=scanner.nextLine();
			//"equals"��"=="������:
			//equals:�Ƚϵ��������ַ�������������Ƿ����
			//==:�Ƚϵ�������������ֵ�Ƿ���ȫ���
			/*
			 * ע��:
			 * һ�㲻��д��pwd.equals(password),������Ϊ��(null),
			 * ������,��Ϊnull.equals(password)ϵͳ�����,û���������
			 * ��д��password.equals(pwd),��ʹ����Ϊ��password.equals(null),Ҳ�������
			 */
			if(password.equals(pwd)){
				drawMoney();//����ȡǮ����ҳ��
				break;
			}else{
				if(count==1){
					System.out.println("���п�������,����ϵ���������Ա!");
					break;
				}
				System.out.println("�������:�㻹��"+(--count)+"�λ���");
			}
		}
		
	}

	//ȡ��ҳ��
	private static void drawMoney() {
		while(true){
			System.out.println("��������:"+remainingSum);
			System.out.println("1.ȡ��100");
			System.out.println("2.ȡ��200");
			System.out.println("3.ȡ��500");
			System.out.println("4.����ȡ��");
			System.out.println("5.�˳�ȡ��");
			Scanner scanner=new Scanner(System.in);
			System.out.println("��ѡ��ȡ����Ŀ");
			int n=scanner.nextInt();
			switch(n){
				case 1:
					if(remainingSum>=100){
						System.out.println("ȡ��100�ɹ�!");
						remainingSum-=100;
					}else{
						System.out.println("����!");
					}
					break;
				case 2:
					if(remainingSum>=200){
						System.out.println("ȡ��200�ɹ�!");
						remainingSum-=200;
					}else{
						System.out.println("����200Ԫ!");
						drawMoney();
					}
					break;
				case 3:
					if(remainingSum>=500){
						System.out.println("ȡ��500�ɹ�!");
						remainingSum-=500;
					}else{
						System.out.println("����500Ԫ!");
						drawMoney();
					}
					break;
				case 4:
					other();
					break;
				case 5:
					System.out.println("�˳��ɹ�!");
					return;
				default:
					System.out.println("��ӭʹ��,ϵͳ�˳�!");
			}
		}
		
		
		
	}

	//����ȡ��
	private static void other() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("��������Ҫȡ��Ľ��!");
		int otherMoney=scanner.nextInt();
		if(otherMoney%100!=0){//���û�ȡ��
			System.out.println("ֻ��ȡ100������");
			other();
		}else{
			if(otherMoney>remainingSum){
				System.out.println("����!");
			}else{
				System.out.println("ȡ��"+otherMoney+"�ɹ�");
				remainingSum-=otherMoney;
				drawMoney();
			}
		}
	}
}
