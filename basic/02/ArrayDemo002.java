package day06;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo002 {
	public static void main(String[] args) {
		//1.��һ�У��ո����������������m,s,n����������200����
		Scanner scanner=new Scanner(System.in);
		System.out.println("������ո��������������");
		int m=scanner.nextInt();
		int s=scanner.nextInt();
		int n=scanner.nextInt();
		//System.out.println(m+" "+s+" "+n);//��׮,���һ��
		//2.m�У�ÿ��s�����ո����������
		int[][] arr01=new int[m][s];
		int[][] arr02=new int[s][n];
		for(int i=0;i<m;i++){//��
			System.out.println("������"+s+"���������ÿո����:");
			for(int j=0;j<s;j++){//��
				arr01[i][j]=scanner.nextInt();
			}
			System.out.println(Arrays.toString(arr01[i]));
		}
		//3.s�У�ÿ��n�����ո����������
		for(int i=0;i<s;i++){//��
			System.out.println("������"+n+"���������ÿո����:");
			for(int j=0;j<n;j++){//��
				arr02[i][j]=scanner.nextInt();
			}
			System.out.println(Arrays.toString(arr02[i]));
		}
		//4.�������,������
		for(int i=0;i<m;i++){//��
			for(int j=0;j<n;j++){//��
				int sum=0;//ÿһ��*ÿһ�еĽ��
				for(int k=0;k<s;k++){
					sum+=arr01[i][k]*arr02[k][j];
				}
				System.out.print(sum+" ");//ÿһ���е�ÿһ���ÿո����
			}
			System.out.println();//����
		}
		
		
		
		
		
		
		
	}
}
