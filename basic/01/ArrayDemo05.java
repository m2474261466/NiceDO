package day05;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * ��ά����:
 * ���һά�����еĸ���Ԫ����Ȼ��һά����,��ô������һ����ά����,��ά���鳣����
 * ��ʾ��,���е���Ϣ���к��е���ʽ���,��һ���±����Ԫ�����ڵ���,�ڶ����±�����Ԫ����
 * �ڵ���
 * @author Lenovo
 *
 */
public class ArrayDemo05 {
	public static void main(String[] args) {
		/*
		 * ��ά���������:
		 * ����[][] ����;
		 * 
		 * ��ά�������ŵ�һ������:
		 * ����[][] ����={����1,����2,����3,����n};
		 */
		int[] arr={2,3,4,5};
		//��ά�������������ʼ��
		int[][] arr01={{2,3,4,5},{6,7,8,9}};
		//��ά���������
		int[][] arr02=new int[2][4];
		//��ά����ĳ���һ��ָ�ĵ�����,��.length
		int n=arr01.length;
		System.out.println("��ά����ĳ���:"+n);
		//arr01��ά�����еĵڶ���Ԫ�صĳ���
		int n1=arr01[1].length;
		System.out.println("arr01��ά�����еĵڶ���Ԫ�صĳ���:"+n1);
		//��ȡ��ά�����е�Ԫ��,��ȡarr01�Ķ�ά�����еĵ�1��Ԫ�صĵ�3��Ԫ��
		System.out.println(arr01[0][2]);
		//����ά�����е�Ԫ�ظ�ֵ
		arr01[1][1]=11;
		System.out.println(arr01[1][1]);
		/*
		 * �û��������������ֱ�����к��в��Կո����,
		 * ÿһ��������ɵ���������������
		 */
		Scanner scanner=new Scanner(System.in);
		Random random=new Random();
		System.out.println("���������������ֱ�����к��в��Կո����:");
		int row=scanner.nextInt();//��
		int column=scanner.nextInt();//��
		int[][] arr03=new int[row][column];//������ά����
		for(int i=0;i<arr02.length;i++){//������
			for(int j=0;j<arr02[i].length;j++){//������
				arr03[i][j]=random.nextInt(101);//�������0-100��������ֵ����ά����arr03
			}
		}
		//��ά����ĵ�һ�����:
		for(int i=0;i<arr03.length;i++){
			System.out.println(Arrays.toString(arr03[i]));
		}
		//��ά����ĵڶ������:
		/*for(int i=0;i<arr02.length;i++){//�����
			for(int j=0;j<arr02[i].length;j++){//�����
				System.out.print(arr03[i][j]+" ");//�ո����
			}
			System.out.println();
		}*/
		
		
		
		
		
		
		
	}
}
