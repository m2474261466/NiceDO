package day06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * �����������󣬷ֱ���m*s��s*n��С���������������˵Ľ����
  �����ʽ
������һ�У��ո����������������m,s,n����������200����
����������m�У�ÿ��s�����ո��������������ʾ����A��i��j����
����������s�У�ÿ��n�����ո��������������ʾ����B��i��j����
  �����ʽ
����m�У�ÿ��n���ո��������������������ľ���C��i��j����ֵ��
  ��������
  2 3 2
  1 0 -1
  1 1 -3
  0 3
  1 2
  3 1
  �������
  -3 2
  -8 2

  ��ʾ
  ����CӦ����m��n�У�����C(i,j)���ھ���A��i�������������B��j�����������ڻ���
  ����������C(1,1)=(1,0,-1)*(0,1,3) = 1 * 0 +0*1+(-1)*3=-3

 * @author Lenovo
 *
 */
public class ArrayDemo02 {
	public static void main(String[] args) {
		/*String str="a b c d e f";
		//split(regex):���ַ�����"regex"�ָ�,���ҷ���һ��String[](����)����
		String[] arrStr=str.split(" ");
		System.out.println(arrStr[4]);
		//�ַ���(String)����ת��Ϊint����
		int b=Integer.parseInt(arrStr[4]);
		System.out.println(b);*/
		//1.��һ�У��ո����������������m,s,n����������200����
		Scanner scanner=new Scanner(System.in);
		System.out.println("������ո����������������:");
		String str=scanner.nextLine();
		//���ַ����ÿո����,����String[]����
		String[] arrStr=str.split(" ");
		//���������ַ���ת��Ϊint����
		int m=Integer.parseInt(arrStr[0]);
		int s=Integer.parseInt(arrStr[1]);
		int n=Integer.parseInt(arrStr[2]);
		//2.m�У�ÿ��s�����ո����������
		int[][] arr01=new int[m][s];
		int[][] arr02=new int[s][n];
		for(int i=0;i<m;i++){//��
			System.out.println("������"+s+"���������ÿո����:");
			String stt=scanner.nextLine();
			String[] arrStt=stt.split(" ");
			//System.out.println(Arrays.toString(arrStt));//����ַ�������arrStt01
			//���û�������ַ����ֽⲢ����arr01�Ķ�ά������
			for(int j=0;j<arrStt.length;j++){//��
				arr01[i][j]=Integer.parseInt(arrStt[j]);
			}
			//��ӡÿһ�е�����
			System.out.println(Arrays.toString(arr01[i]));
		}
		//3.s�У�ÿ��n�����ո����������
		for(int i=0;i<s;i++){//��
			System.out.println("������"+n+"���������ÿո����");
			String stt02=scanner.nextLine();
			String[] arrStt02=stt02.split(" ");
			//System.out.println(Arrays.toString(arrStt02));//����ַ�������arrStt02
			//���û�������ַ����ֽⲢ����arr02�Ķ�ά������
			for(int j=0;j<arrStt02.length;j++){//��
				arr02[i][j]=Integer.parseInt(arrStt02[j]);
			}
			System.out.println(Arrays.toString(arr02[i]));			
		}
		//4.�������,������
		for(int i=0;i<m;i++){//��
			for(int j=0;j<n;j++	){//��
				int sum=0;//ÿһ��*ÿһ�еĺ�
				for(int k=0;k<s;k++){
					sum+=arr01[i][k]*arr02[k][j];
				}
				System.out.print(sum+" ");//ÿһ���е�ÿһ���ÿո����
			}
			System.out.println();//����
		}
		
		
		
	}
}
