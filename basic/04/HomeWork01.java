package day04;

import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

/**
 * 问题描述
　 给定一个以秒为单位的时间t，要求用“<H>:<M>:<S>”的格式来表示这个时间。
   <H>表示时间，<M>表示分钟，而<S>表示秒，它们都是整数且没有前导的“0”。
   例如，若t=0，则应输出是“0:0:0”；若t=3661，则输出“1:1:1”。
   输入格式
　 输入只有一行，是一个整数t（0<=t<=86399）。
   输出格式
　 输出只有一行，是以“<H>:<M>:<S>”的格式所表示的时间，不包括引号。
   样例输入
   0
   样例输出
   0:0:0
   样例输入
   5436
   样例输出
   1:30:36
   分析一:
   1.用户给的秒数先算出小时(H),用整型(int)
   2.用户给出的秒数-第一步(换算成秒),然后再转化为分
   3.对用户输入的秒直接对60取余(求秒数)
   
   分析二:
   1.用户给的秒数先算出小时(H),用整型(int)
   2.用户给出的秒数-第一步(换算成秒),然后再转化为分
   3.用户给出的秒数-第一步(换算成秒)-第二步(换算成秒)
 * @author Lenovo
 *
 */
public class HomeWork01 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入一个整数t(0<=t<=86399)");
		int t=0;//定义用户输入的秒数
		int H=0;//小时
		int	M=0;//分钟
		int	S=0;//秒
		//boolean flag=true;//控制while循环
		while(true){
			t=scanner.nextInt();//用户输入秒数
			if(t<0 || t>86399){//不再提示范围,友好提示!
			System.out.println("请合法输入提示范围的整数!");
			}else{//输入的秒数在范围内,跳出循环
				//flag=false;
				break;
			}
		}
		
		/*//方法一:
		H=t/60/60;//求小时数
		M=(t-H*60*60)/60;//求分钟数
		S=t%60;//求秒数
		System.out.println(H+":"+M+":"+S);*/
		
		//方法二:
		//1.求小时
		H=t/60/60;
		//2.求分钟
		M=(t-H*60*60)/60;
		//3.求秒数
		S=(t-H*60*60)-M*60;
		System.out.println(H+":"+M+":"+S);
	}
}
