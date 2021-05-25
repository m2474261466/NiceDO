package day07;

import java.util.Scanner;

/**
 * 　求出区间[a,b]中所有整数的质因数分解。
 * 分解质因数就是将某个数的所有因数全部分解乘由质数组成的因数
	输入格式
	　　输入两个整数a，b。
	输出格式
	　　每行输出一个数的分解，形如k=a1*a2*a3...(a1<=a2<=a3...，k也是从小到大的)(具体可看样例)
	样例输入
	3 10
	样例输出
	3=3*1
	4=2*2
	5=5*1
	6=2*3
	7=7
	8=2*2*2
	9=3*3
	10=2*5
	提示
	　　先筛出所有素数，然后再分解。
	数据规模和约定
	　　2<=a<=b<=10000

 * @author Lenovo
 *
 */
public class Method_dg03 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入一个大于等于2并且小于等于10000的正整数:");
		int a=scanner.nextInt();
		System.out.println("请输入一个大于等于2并且小于等于10000的正整数:");
		int b=scanner.nextInt();		
		for(int i=a;i<=b;i++){
			System.out.print(i+"=");//不换行
				//判断i是质数还是合数
				boolean p=prime(i);
				if(p==false){//是质数
					System.out.println(i);
				}else{//是合数(继续进行判断直到质数为止)
					dg(i);
				}
		}
						
	}
	
	//将合数进行质因数分解
	public static void dg(int sumber){
		for(int i=2;i<sumber;i++){
			if(sumber%i==0){
				System.out.print(i+"*");//不换行
				boolean b=prime(sumber/i);
				if(b==false){//是质数(在这里也是递归的停止条件)
					System.out.print(sumber/i);
					System.out.println();//换行
				}else{//是合数(不是质数则继续判断)
					dg(sumber/i);
				}
				break;
			}		
		}
	}
	
	
	//判断该数是质数还是合数
	public static boolean prime(int sumber){
		boolean flag=false;
		for(int i=2;i<sumber;i++){
			if(sumber%i==0){//是合数
				flag=true;
				return flag;
			}
		}
		return flag;
	}

	
		
}
