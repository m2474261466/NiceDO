package day07;

import java.util.Scanner;

/**
 * ���������[a,b]�������������������ֽ⡣
 * �ֽ����������ǽ�ĳ��������������ȫ���ֽ����������ɵ�����
	�����ʽ
	����������������a��b��
	�����ʽ
	����ÿ�����һ�����ķֽ⣬����k=a1*a2*a3...(a1<=a2<=a3...��kҲ�Ǵ�С�����)(����ɿ�����)
	��������
	3 10
	�������
	3=3*1
	4=2*2
	5=5*1
	6=2*3
	7=7
	8=2*2*2
	9=3*3
	10=2*5
	��ʾ
	������ɸ������������Ȼ���ٷֽ⡣
	���ݹ�ģ��Լ��
	����2<=a<=b<=10000

 * @author Lenovo
 *
 */
public class Method_dg03 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("������һ�����ڵ���2����С�ڵ���10000��������:");
		int a=scanner.nextInt();
		System.out.println("������һ�����ڵ���2����С�ڵ���10000��������:");
		int b=scanner.nextInt();		
		for(int i=a;i<=b;i++){
			System.out.print(i+"=");//������
				//�ж�i���������Ǻ���
				boolean p=prime(i);
				if(p==false){//������
					System.out.println(i);
				}else{//�Ǻ���(���������ж�ֱ������Ϊֹ)
					dg(i);
				}
		}
						
	}
	
	//�����������������ֽ�
	public static void dg(int sumber){
		for(int i=2;i<sumber;i++){
			if(sumber%i==0){
				System.out.print(i+"*");//������
				boolean b=prime(sumber/i);
				if(b==false){//������(������Ҳ�ǵݹ��ֹͣ����)
					System.out.print(sumber/i);
					System.out.println();//����
				}else{//�Ǻ���(��������������ж�)
					dg(sumber/i);
				}
				break;
			}		
		}
	}
	
	
	//�жϸ������������Ǻ���
	public static boolean prime(int sumber){
		boolean flag=false;
		for(int i=2;i<sumber;i++){
			if(sumber%i==0){//�Ǻ���
				flag=true;
				return flag;
			}
		}
		return flag;
	}

	
		
}
