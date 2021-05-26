package day08;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ��������Ϸ:
 * ��Ϸ�ȼ���Ϊ���ȣ�5��7��9����������Ҫ�²����ĸ������
 * ��Ϸ��ʼʱ�������ѡ����Ϸ�ȼ���5��7��9����
 * ���ѡ��7������������7���ַ���Ȼ���������һ���ַ�������7���ַ���
 * ����7���ַ������������7���ַ��Ƚϣ����Ƿ���ȷ;
 * Ҫ��������ɲ�ͬ�ĵȼ��Ĳ��ظ����ַ���Ϊ���û��µ��ַ�;
 * �ж��û�ÿ����������ݺ�������ɵ��ַ�,�ַ����˼���,�ַ���λ�ö��˼���
 * �ܷ�Ϊ��������ַ��ĳ���*100,�´�һ�ο۵�10��,ֱ�����¶Բ�����ܷ�;
 * (�ַ���A-Z��Χ)
 * 
 * ��Ŀ����:
 * 1.�����Ϸ�ȼ�
 * 2.���ݵȼ���ͬ������ɲ�ͬ���ַ�����
 * 3.�û�������ַ��͸��ݵȼ���ͬ������ɲ�ͬ���ַ��Ƚ�,������¶��ַ��ĸ����Ͳ¶��ַ�λ�öԵĸ���
 * 4.���ݵȼ���ͬ����¶Ժ��ÿ���ȼ����ܷ�
 * @author Lenovo
 *
 */
public class GameGuess {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while(true){
			System.out.println("��������Ϸ�ȼ��Ѷ�,�ֱ�Ϊ1,2,3,����Ϊ�˳�");
			int grades=scanner.nextInt();
			switch (grades){
				case 1:
					//�Ѷ�1  5���ַ�
					int a=5;
					diffculty(a);										
					break;
				case 2:
					//�Ѷ�2  7���ַ�
					int b=7;
					diffculty(b);
					break;
				case 3:
					//�Ѷ�3  9���ַ�
					int c=9;
					diffculty(c);				
					break;
				default:
					//��Ϸ�˳�
					System.out.println("��Ϸ�˳�,��ӭ�´�����!");
					return;
			}
		}	
	}
	
	//
	public static void diffculty(int a){
		Scanner scanner=new Scanner(System.in);
		char[] ch=getRandomChar(a);//������ɲ��ظ����ַ�
		//�û�������ַ�������ȥ�����߿հײ���ת��Ϊ��д
		System.out.println("������һ������Ϊ"+a+"�ַ���");
		int score=ch.length*100;//����
		while(true){
			System.out.println("�°�(����exit�˳�����)");
			String s=scanner.next().trim().toUpperCase();       //.toUpperCase()�����е��ַ�ת��Ϊ��д
			if("EXIT".equals(s)){
				/*
				 * equals()������ǰ�治��Ϊ��
				 * ��:null.equals("EXIT")����ᱨ��,��Ϊequals()����û��null.equals()����
				 * ���ÿ��ʹ��equals()����ʱ��equalsǰ��д�������ݿ�������ȡ������,������ֿյ�
				 * ��:"EXIT".equals(s);//s���û�������ַ���
				 */
				System.out.println("��Ϸ����,�ݰ�!");
				return;
			}
			/*
			 * ����Javaû���ṩ�����û����������ַ����鷽��,
			 * ���н����û��������ݵ��ַ���,���ת��Ϊ�ַ�����
			 */
			char[] input=s.toCharArray();
			if(ch.length!=input.length){
				System.out.println("������ĳ��Ȳ���,��Ϸ�����"+a+"���ַ�");
				continue;    //������������ѭ��,��ִ�к���Ĵ���
			}
			//������ɵ��ַ����û�������������Ƚ�,��������ַ��Եĸ������ַ�λ�öԵĸ���
			int[] result=check(ch, input);
			if(result[1]==ch.length){//ȫ��������
				System.out.println("��¶���,�ܷ���Ϊ"+score+"�����ѡ���Ѷ�!");
				break;			//��ȫ�¶��ַ�����,while����ѭ��
			}else{//�´�۵�ʮ��
				score-=10;
				System.out.println("��¶���"+result[0]+"���ַ�,����"+result[1]+"���ַ�λ����ȷ!");
			}
		}
	}
	
	//�û����ɵ��ַ����û�������������Ƚ�
	public static int[] check(char[] ch, char[] input){
		int[] arr=new int[2];//����ַ��Եĸ������ַ�λ�öԵĸ���
		for(int i=0;i<ch.length;i++){//��Ҫ�µ��ַ�
			for(int j=0;j<input.length;j++){//�û�������ַ�
				if(ch[i]==input[j]){//�ж������ÿ���ַ����û�ÿ���ַ��Ƿ���ͬ
					arr[0]++;//�ַ��Եĸ���
					if(i==j){
						arr[1]++;//�ַ�λ�öԵĸ���
					}
					break;
				}
			}
		}
		//System.out.println("��¶���"+arr[0]+"���ַ�,����"+arr[1]+"���ַ�λ����ȷ!");
		return arr;
	}
	
	//������ɲ��ظ���A-Z�ַ�
	public static char[] getRandomChar(int x){
		char[] arry={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		boolean[] flag=new boolean[arry.length];//Ĭ��Ϊfalse
		char[] newArry=new char[x];		//����ַ����µ��ַ�����
		for(int i=0;i<newArry.length;i++){
			int index=0;//���arry�ַ������boolean�ַ�������±�
			do{
				/*
				 * �������һ��0-25����,������ʾflag�����arry������±�
				 */
				index=(int)(Math.random()*arry.length);
			}while(flag[index]==true);
			flag[index]=true;
			newArry[i]=arry[index];
		}
		System.out.println(Arrays.toString(newArry));
		return newArry;
	}
	
	
}
