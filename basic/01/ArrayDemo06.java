package day05;

import java.util.Arrays;

/**
 * �������
 * 
 * 
 * 			1			i=0	6-i-1
 *         1 1			
 *        1 2 1
 *       1 3 3 1
 *      1 4 6 4 1
 *     1 5 10 10 5 1
 * 
 * ����:
 * 1.����һ����n��
 * 2.��һ������,����Ϊһ,����û����һ��
 * 3.��ֵ�������ÿ�����ߵ���Ϊ1
 * 4.��ֵ��������м����arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
 * ���(���൱��������ε��ϰ벿��,���Բο�day04��Homework02���������):
 * 1.����n��
 * 2.ÿһ�е�ǰ����n-1���ո�
 * 
 * @author Lenovo
 * 
 * 
 */
public class ArrayDemo06 {
	public static void main(String[] args) {
		/*
		 * ����ά���鸳ֵ
		 */
		//������ά����
		int[][] arr=new int[6][];
		for(int i=0;i<arr.length;i++){//��
			arr[i]=new int[i+1];
			/*
			 * ��Ϊ��һ����һ���������,û����һ��
			 * ����жϿ��п���,��ϰǰ���֪ʶ
			 */
			if(arr[i].length==1){//�ж����鳤���Ƿ�Ϊ1,��һ��
				arr[i][0]=1;
				//����arr[i]=new int[]{1};
				continue;
			}
			for(int j=0;j<i+1;j++){//�ӵڶ��п�ʼѭ������
				if(j==0 || i==j){//ÿһ�����ߵ���������ֵ1
					arr[i][j]=1;
				}else{//ÿһ���м����
					arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
				}
			}
			
		}
		/*
		 * �Ű�:���չ̶���ʽ����������
		 */
		//�����ά����arr�е�ÿһ��Ԫ��
		for(int i=0;i<arr.length;i++){
			System.out.println(Arrays.toString(arr[i]));
		}
		for(int i=0;i<arr.length;i++){//�����������ѭ��,�����±��Ǵ�0��ʼ��
			for(int j=0;j<arr.length-i-1;j++){//�������ÿһ��ǰ��Ŀո�����ѭ��
				System.out.print(" ");
			}
			for(int k=0;k<=i;k++){//ÿһ�е���������
				//���ÿһ���е�ÿһ�е��������ÿո����
				System.out.print(arr[i][k]+" ");
			}
			System.out.println();//����
		}
		
		
		
		
		
		
	}
}
