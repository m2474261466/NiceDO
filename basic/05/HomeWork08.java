package day04;

import java.util.Scanner;

/**
 * �������int���е����ֵ(������Ŀ����)
 * @author Lenovo
 *
 */
public class HomeWork08 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("��ֱ�����������:");
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		int c=scanner.nextInt();
		/*
		 * ����nextInt()�ײ�������һ���ո�,��nextLine()
		 * ɨ���û����������ݰ������ո�,���nextInt()�ײ�������һ���ո�
		 * ��nextLine()����Ϊ���û�����Ŀո�,����nextLine()
		 * �Ѿ���ȡ��������(�ո�),Ҳ�Ͳ�����������ˡ�
		 * next()������ȡ���հ׷��ͽ�����nextLine()��ȡ���س�����
		 */
		System.out.println("������һ���ַ���:");
		String str=scanner.nextLine();//����(�ȴ��û�����)
		System.out.println("����");
		System.out.println("������һ���ַ���:");
		String str1=scanner.next();
		System.out.println(str1);
		int max=(a>b?a:b)>c?(a>b?a:b):c;
		System.out.println("���ֵ��"+max);
	}
}
