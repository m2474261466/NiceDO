package day04;

import java.util.Scanner;

/**
 *   						*
						   ***
						  *****
						 *******
						*********
						 *******
						  *****
						   ***
						    *
 * �ڿ���̨����ʾһ������(����ͼ��ʾ)
 * ����:
 * 1.�����ϰ벿�ֺ��м�
 * 2.��һ��һ����size��
 * 3.����ո�:��һ����size-1���ո�,�ڶ�����size-2���ո�...��i����size-i���ո�
 * 4.���"*":��һ����1*2-1��"*",��2����2*2-1��"*",��i����2*i-1��"*"
 * @author Lenovo
 *
 */
public class HomeWork02 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("���������εĴ�С");
		int size=scanner.nextInt();
		//������ε��ϰ벿�����м��һ��
		for(int i=1;i<=size;i++){//��
			for(int j=0;j<size-i;j++){//����ո�
				System.out.print(" ");
			}
			for(int k=0;k<2*i-1;k++){//���"*"
				System.out.print("*");
			}
			System.out.println();//����
		}
		//������ε��°벿
		for(int i=size-1;i>0;i--){
			for(int j=0;j<size-i;j++){//����ո�
				System.out.print(" ");
			}
			for(int k=0;k<2*i-1;k++){//���"*"
				System.out.print("*");
			}
			System.out.println();//����
		}
		
		
	}
}
