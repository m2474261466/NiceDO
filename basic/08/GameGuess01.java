package day08;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * /**
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
 * 1.����һ������ַ�
 * 2.�Ƚ��û�������ַ�������������ַ��Ƿ����
 * 3.������
 * 
 * @author Lenovo
 */
public class GameGuess01 {
	 public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while(true){
			System.out.println("-----��Ϸ�ȼ�-----");
			System.out.println("1.��");
			System.out.println("2.�е�");
			System.out.println("3.����");
			System.out.println("4.�˳���Ϸ");
			System.out.println("����������Ҫѡ�����Ϸ�ȼ�");		
			int gameClass=scanner.nextInt();
			switch(gameClass){
				case 1:
					//5���ַ�	��
					int a=5;
					char[] randomChar=randomLetter(a);//��������ַ�����
					//System.out.println(Arrays.toString(randomChar));
					compare(randomChar);//�ַ���ȷ�ĸ������ַ�λ����ȷ�ĸ���
					break;
				case 2:
					//7���ַ�	�е�
					int b=7;
					char[] randomChar02=randomLetter(b);//��������ַ�����
					compare(randomChar02);//�ַ���ȷ�ĸ������ַ�λ����ȷ�ĸ���
					break;
				case 3:
					//9���ַ�	����
					int c=9;
					char[] randomChar03=randomLetter(c);//��������ַ�����
					compare(randomChar03);//�ַ���ȷ�ĸ������ַ�λ����ȷ�ĸ���
					break;
				case 4:
					//�˳���Ϸ
					System.out.println("�˳���Ϸ�ɹ�,��ӭ�´�����!");
					return;
				default:
					System.out.println("��������ȷ�����!");
			}
		}
		
		
	}
	 
	 //�Ƚ��ַ���ȷ�������ַ�λ����ȷ�ĸ���
	 public static void compare(char[] arr){
		 Scanner scanner=new Scanner(System.in);
		 int score=arr.length*100;
		 while(true){
			 int[] n=new int[2];//����ַ���ȷ�ĸ������ַ�λ����ȷ�ĸ���
			 System.out.println("������"+arr.length+"���ַ�(EXIT--�˳�):");
			 String str=scanner.nextLine().trim().toUpperCase();
			 if("EXIT".equals(str)){
				 System.out.println("�˳��ɹ�!");
				 break;
			 }
			 char[] newArr=str.toCharArray();
			 if(newArr.length!=arr.length){
				 System.out.println("������ĳ��Ȳ��Ϸ�,����������!");
				 continue;
			 }
			 for(int i=0;i<arr.length;i++){
				 for(int j=0;j<newArr.length;j++){
					 if(arr[i]==newArr[j]){
						 n[0]++;//�ַ���ȷ�ĸ���
						 if(i==j){
							 n[1]++;//�ַ�λ����ȷ�ĸ���
						 }
						 break;
					 }
				 }
			 }
			 System.out.println("��¶���"+n[0]+"���ַ�,����"+n[1]+"���ַ�λ����ȷ!");
			 if(n[1]==arr.length){
				 System.out.println("��ȫ���¶���,��ĵ÷���"+score+"��");
				 break;
			 }else{
				 score-=10;
				 continue;
			 }
			 
		 }
	 }
	 
	//�������ظ��������ĸ
	 public static char[] randomLetter(int length){
		 Random random=new Random();
		 char[] letter={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		 boolean[] flag=new boolean[letter.length];//��¼ÿ���ַ���״̬,boolean����Ĭ��Ϊfalse
		 char[] choice=new char[length];
		 for(int i=0;i<choice.length;i++){
			 int index=0;//��¼letter�����flag������±�
			 do{
				 index=random.nextInt(letter.length);
			 }while(flag[index]==true);
			 flag[index]=true;
			 choice[i]=letter[index];
		 }
		 System.out.println(Arrays.toString(choice));//����
		 return choice;
	 }
	 
	 
	 
	 
}
