package day04;

import java.util.Scanner;

/**
 * ��������:
 * ����:ֻ�ܱ�1������������������������(�ֳ�֮Ϊ����);
 * ����:2,3,5,7......
 * ����:�����ܱ�1���������������һ����Ա�������������,�ƺ���;
 * ����:4,6,8,9......
 * 1�Ȳ�������Ҳ���Ǻ���,�����Ȼ�����Է�Ϊ:����,����,1;
 * @author Lenovo
 *
 */
public class HomeWork11 {
	public static void main(String[] args) {
		/*
		 * ���n-m֮��ĵ�����,����������ͺ����ĸ���
		 */
		Scanner scanner=new Scanner(System.in);
		System.out.println("��������������(���ÿո����)");
		int n=scanner.nextInt();
		int m=scanner.nextInt();
		int z=0;//�����ĸ���
		int h=0;//�����ĸ���
		for(int i=n;i<=m;i++){//n-m�ķ�Χ
			boolean flag=true;
			for(int j=2;j<i;j++){
				if(i%j==0){//�ж��Ƿ�Ϊ����,�������������Ϊ����,��flag��ֵΪfalse,����������flag��ֵ����
					flag=false;
					break;//��Ϊ����ֱ������ѭ��
				}
			}
			if(flag==true){
				z++;
				System.out.println(i+"������");
			}else{
				h++;
				System.out.println(i+"�Ǻ���");
			}
		}
		System.out.println("������:"+z+"��,������:"+h+"��");
		
		
				
		//�ж�n���������Ǻ���
		for(int i=2;i<n;i++){
			if(n%i==0){
				System.out.println(n+"�Ǻ���");
				return;//return�����÷���,����������main����(�ڶ���)
			}
		}
		System.out.println(n+"������");
		//����"����"�ж�n���������Ǻ���
		boolean flag=true;
		for(int i=2;i<n;i++){
			if(n%i==0){
				flag=false;
			}
		}
		if(flag==true){
			System.out.println(n+"������");
		}else{
			System.out.println(n+"�Ǻ���");
		}
		
	}
}
