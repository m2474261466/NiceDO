package day07;

import java.util.Scanner;

/**
 * �����û����п��Ƿ���֧��ȼ�����ù���
 * @author Lenovo
 *
 */
public class TestUnionPay {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("����������");
		String input=scanner.next();
		CCBImpl c=new CCBImpl(2000, "123456");
		if(c.checkPwd(input)){//�ж������Ƿ�һ��
			while(true){
				System.out.println("��������Ҫѡ��Ĺ���");
				System.out.println("1. ȡǮ");
				System.out.println("2. ֧��ȼ����");
				System.out.println("3. ��ѯ���");	
				System.out.println("4. �˳�");
				System.out.println("��������ѡ����");
				int n=scanner.nextInt();//���û�ѡ����
				switch (n) {
				case 1:
					System.out.println("������ȡǮ���");
					double num=scanner.nextDouble();
					if(c.drawMoney(num)){
						System.out.println("ȡǮ�ɹ�,���Ϊ"+c.getBalance());
					}else{
						System.out.println("����");
					}
					break;
				case 2:
					System.out.println("������֧��ȼ���ѵĽ��");
					double num2=scanner.nextDouble();
					c.pay(num2);
					break;
				case 3:
					System.out.println("���Ϊ:"+c.getBalance());
					break;
				case 4:
					System.out.println("�˳��ɹ�!");
					return ;
				default:
					System.out.println("������ѡ��������");
					break;
				}
			}	
		}else{
			System.out.println("�������!");
		}
	}
}
