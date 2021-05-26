package day08;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * /**
 * 猜数字游戏:
 * 游戏等级设为三等：5、7和9，代表所需要猜测的字母个数。
 * 游戏开始时，由玩家选择游戏等级（5，7，9）。
 * 如果选择7，则会随机产生7个字符，然后玩家输入一个字符串包含7个字符，
 * 看这7个字符和随机产生的7个字符比较，看是否正确;
 * 要求随机生成不同的等级的不重复的字符作为让用户猜的字符;
 * 判断用户每次输入的数据和随机生成的字符,字符对了几个,字符的位置对了几个
 * 总分为随机生成字符的长度*100,猜错一次扣掉10分,直到最后猜对并输出总分;
 * (字符在A-Z范围)
 * 
 * 项目分析:
 * 1.产生一组随机字符
 * 2.比较用户输入的字符和随机产生的字符是否相等
 * 3.输出结果
 * 
 * @author Lenovo
 */
public class GameGuess01 {
	 public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while(true){
			System.out.println("-----游戏等级-----");
			System.out.println("1.简单");
			System.out.println("2.中等");
			System.out.println("3.困难");
			System.out.println("4.退出游戏");
			System.out.println("请输入你所要选择的游戏等级");		
			int gameClass=scanner.nextInt();
			switch(gameClass){
				case 1:
					//5个字符	简单
					int a=5;
					char[] randomChar=randomLetter(a);//产生随机字符数组
					//System.out.println(Arrays.toString(randomChar));
					compare(randomChar);//字符正确的个数和字符位置正确的个数
					break;
				case 2:
					//7个字符	中等
					int b=7;
					char[] randomChar02=randomLetter(b);//产生随机字符数组
					compare(randomChar02);//字符正确的个数和字符位置正确的个数
					break;
				case 3:
					//9个字符	困难
					int c=9;
					char[] randomChar03=randomLetter(c);//产生随机字符数组
					compare(randomChar03);//字符正确的个数和字符位置正确的个数
					break;
				case 4:
					//退出游戏
					System.out.println("退出游戏成功,欢迎下次再来!");
					return;
				default:
					System.out.println("请输入正确的序号!");
			}
		}
		
		
	}
	 
	 //比较字符正确个数和字符位置正确的个数
	 public static void compare(char[] arr){
		 Scanner scanner=new Scanner(System.in);
		 int score=arr.length*100;
		 while(true){
			 int[] n=new int[2];//存放字符正确的个数和字符位置正确的个数
			 System.out.println("请输入"+arr.length+"个字符(EXIT--退出):");
			 String str=scanner.nextLine().trim().toUpperCase();
			 if("EXIT".equals(str)){
				 System.out.println("退出成功!");
				 break;
			 }
			 char[] newArr=str.toCharArray();
			 if(newArr.length!=arr.length){
				 System.out.println("你输入的长度不合法,请重新输入!");
				 continue;
			 }
			 for(int i=0;i<arr.length;i++){
				 for(int j=0;j<newArr.length;j++){
					 if(arr[i]==newArr[j]){
						 n[0]++;//字符正确的个数
						 if(i==j){
							 n[1]++;//字符位置正确的个数
						 }
						 break;
					 }
				 }
			 }
			 System.out.println("你猜对了"+n[0]+"个字符,其中"+n[1]+"个字符位置正确!");
			 if(n[1]==arr.length){
				 System.out.println("你全部猜对了,你的得分是"+score+"分");
				 break;
			 }else{
				 score-=10;
				 continue;
			 }
			 
		 }
	 }
	 
	//产生不重复的随机字母
	 public static char[] randomLetter(int length){
		 Random random=new Random();
		 char[] letter={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		 boolean[] flag=new boolean[letter.length];//记录每个字符的状态,boolean类型默认为false
		 char[] choice=new char[length];
		 for(int i=0;i<choice.length;i++){
			 int index=0;//记录letter数组和flag数组的下标
			 do{
				 index=random.nextInt(letter.length);
			 }while(flag[index]==true);
			 flag[index]=true;
			 choice[i]=letter[index];
		 }
		 System.out.println(Arrays.toString(choice));//作弊
		 return choice;
	 }
	 
	 
	 
	 
}
