package day04;

import java.util.Scanner;

/**
 * 1+1/2+1/3��+1/n��n>=2����
 * Ҫ��ʹ�ý����ķ�ʽ��������еĺͣ�
 * �û��ڿ���̨¼����Ҫ��������� n ��ֵ�������������еĺͣ����ڿ���̨��������
 * @author Lenovo
 *
 */
public class HomeWork10 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("������һ�����ڵ���2������");
		int n=scanner.nextInt();
		double sum=0.0;//�ܺ�
		for(int i=1;i<=n;i++){
			//ע��:��������
			//����д��:sum+=1/i;//i��1����int���͵���,����Ľ������ȡ��
			sum+=1.0/i;
		}
		System.out.println(sum);
	}
}
