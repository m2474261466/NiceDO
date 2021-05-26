package day08;

import java.util.Arrays;
import java.util.Scanner;

/**
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
 * 1.设计游戏等级
 * 2.根据等级不同随机生成不同的字符个数
 * 3.用户输入的字符和根据等级不同随机生成不同的字符比较,并算出猜对字符的个数和猜对字符位置对的个数
 * 4.根据等级不同输出猜对后的每个等级的总分
 * @author Lenovo
 *
 */
public class GameGuess {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while(true){
			System.out.println("请输入游戏等级难度,分别为1,2,3,否则为退出");
			int grades=scanner.nextInt();
			switch (grades){
				case 1:
					//难度1  5个字符
					int a=5;
					diffculty(a);										
					break;
				case 2:
					//难度2  7个字符
					int b=7;
					diffculty(b);
					break;
				case 3:
					//难度3  9个字符
					int c=9;
					diffculty(c);				
					break;
				default:
					//游戏退出
					System.out.println("游戏退出,欢迎下次再来!");
					return;
			}
		}	
	}
	
	//
	public static void diffculty(int a){
		Scanner scanner=new Scanner(System.in);
		char[] ch=getRandomChar(a);//随机生成不重复的字符
		//用户输入的字符串并且去掉两边空白并且转换为大写
		System.out.println("请输入一个长度为"+a+"字符串");
		int score=ch.length*100;//满分
		while(true){
			System.out.println("猜吧(输入exit退出程序)");
			String s=scanner.next().trim().toUpperCase();       //.toUpperCase()将所有的字符转化为大写
			if("EXIT".equals(s)){
				/*
				 * equals()方法的前面不能为空
				 * 例:null.equals("EXIT")程序会报错,因为equals()方法没有null.equals()方法
				 * 因此每次使用equals()方法时在equals前面写的是数据库里面提取的数据,不会出现空的
				 * 例:"EXIT".equals(s);//s是用户输入的字符串
				 */
				System.out.println("游戏结束,拜拜!");
				return;
			}
			/*
			 * 由于Java没有提供接受用户传过来的字符数组方法,
			 * 所有接受用户输入数据的字符串,最后转换为字符数组
			 */
			char[] input=s.toCharArray();
			if(ch.length!=input.length){
				System.out.println("你输入的长度不对,请合法输入"+a+"个字符");
				continue;    //立即结束本轮循环,不执行后面的代码
			}
			//随机生成的字符和用户输入的数据作比较,并且求出字符对的个数和字符位置对的个数
			int[] result=check(ch, input);
			if(result[1]==ch.length){//全部猜中了
				System.out.println("你猜对了,总分数为"+score+"请继续选择难度!");
				break;			//完全猜对字符数组,while跳出循环
			}else{//猜错扣掉十分
				score-=10;
				System.out.println("你猜对了"+result[0]+"个字符,其中"+result[1]+"个字符位置正确!");
			}
		}
	}
	
	//用户生成的字符和用户输入的数据作比较
	public static int[] check(char[] ch, char[] input){
		int[] arr=new int[2];//存放字符对的个数和字符位置对的个数
		for(int i=0;i<ch.length;i++){//需要猜的字符
			for(int j=0;j<input.length;j++){//用户输入的字符
				if(ch[i]==input[j]){//判断随机的每个字符和用户每个字符是否相同
					arr[0]++;//字符对的个数
					if(i==j){
						arr[1]++;//字符位置对的个数
					}
					break;
				}
			}
		}
		//System.out.println("你猜对了"+arr[0]+"个字符,其中"+arr[1]+"个字符位置正确!");
		return arr;
	}
	
	//随机生成不重复的A-Z字符
	public static char[] getRandomChar(int x){
		char[] arry={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		boolean[] flag=new boolean[arry.length];//默认为false
		char[] newArry=new char[x];		//存放字符的新的字符数组
		for(int i=0;i<newArry.length;i++){
			int index=0;//存放arry字符数组和boolean字符数组的下标
			do{
				/*
				 * 随机生成一个0-25的数,用来表示flag数组和arry数组的下标
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
