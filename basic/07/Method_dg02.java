package day07;

import java.util.Scanner;

/**
 * �û�������������k,n(0<k<n)
 * ��k=0����k=n,��������1
 * ��0<k<nʱ����(k,n-1)+����(k-1,n-1)
 * @author Lenovo
 *
 */
public class Method_dg02 {		
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("������һ������0������:");
		int k=scanner.nextInt();
		System.out.println("������һ������"+k+"������");
		int n=scanner.nextInt();
		int result=dg(k,n);
		System.out.println(result);
	}
	
	public static int dg(int k,int n){//�ݹ麯��
		if(k==0 || k==n){//�߽�����(�ݹ�ֹͣ����)
			return 1;
		}else{
			return dg(k, n-1)+dg(k-1, n-1);
		}
	}
	
	
	
	
}
