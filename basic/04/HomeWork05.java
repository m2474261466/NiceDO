package day04;

import java.util.Scanner;

/**
 * ��д�����ж�ĳһ������Ƿ�Ϊ����(ʹ��if-else)
 * 
 * ����:��ݿ��Ա�4�������Ҳ��ܱ�100����������ݿ��Ա�400����
 * @author Lenovo
 *
 */
public class HomeWork05 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("���������,����:2012");
		int year=scanner.nextInt();
		if((year%4==0 && year%100!=0)|| year%400==0){
			System.out.println(year+"������");
		}else{
			System.out.println(year+"��������");
		}
	}
}
