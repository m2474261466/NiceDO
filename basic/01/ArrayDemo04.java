package day05;

import java.util.Arrays;

/**
 * �˿���:
 * �˿���һ��54��,����54���˿��Ƹ��ݲ�ͬ�Ļ�ɫ
 * ͨ������ķ�ʽ����һ�������в���ʾ�ڿ���̨
 * Ҫ��:��ɫΪһ������,�˿����е�����Ϊһ������
 * @author Lenovo
 *
 */
public class ArrayDemo04 {
	public static void main(String[] args) {
		//��ɫ
		String[] colorArr={"����","����","÷��","����"};
		//�˿����е�����
		String[] number={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		//���˿��Ƶ�����
		//����һ:
		/*String[] newArr={};
		int index=0;//newArr���±�
		for(int i=0;i<colorArr.length;i++){//��ɫ
			for(int j=0;j<number.length;j++){//����
				//�ȶԷ��˿��Ƶ���������
				newArr=Arrays.copyOf(newArr, newArr.length+1);
				newArr[index++]=colorArr[i]+number[j];
			}
		}
		System.out.println(newArr.length);
		//����������С��
		newArr=Arrays.copyOf(newArr, newArr.length+2);
		newArr[newArr.length-2]="С��";
		newArr[newArr.length-1]="����";
		System.out.println(Arrays.toString(newArr));*/
		
		//������:
		String[] newArr02=new String[54];
		for(int i=0;i<newArr02.length-2;i++){
			/*
			 * i/number.length:��13Ϊһ��ѭ��,ÿ��ֵ13�ξͻ�һ����ɫ
			 * i%number.length:��13Ϊһ��ѭ��,ÿ�ζ���һ������,13������Ϊһ��
			 */
			newArr02[i]=colorArr[i/number.length]+number[i%number.length];
		
		}
		newArr02[newArr02.length-2]="С��";
		newArr02[newArr02.length-1]="����";
		System.out.println(Arrays.toString(newArr02));
		
	}
}
