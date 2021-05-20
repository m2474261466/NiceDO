package day04;

import java.util.Scanner;

/**
 * 银行ATM操作系统
 * 项目分析:
 * 1.输入密码:(如果密码不正确,输入三次后银行卡被冻结)
 * 2.如果密码正确,进入取钱操作页面
 * 3.退出系统
 * 
 * @author Lenovo
 *
 */
public class DemoATM {
	static double remainingSum=19982.89;//银行卡余额
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);		
		int count=3;//设置密码输入的次数
		while(true){
			//设置银行卡密码
			String password="123456";
			System.out.println("请输入密码");
			String pwd=scanner.nextLine();
			//"equals"和"=="的区别:
			//equals:比较的是两个字符串里面的内容是否相等
			//==:比较的是两个变量的值是否完全相等
			/*
			 * 注意:
			 * 一般不会写成pwd.equals(password),若输入为空(null),
			 * 则会出错,因为null.equals(password)系统会出错,没有这个方法
			 * 若写成password.equals(pwd),即使输入为空password.equals(null),也不会出错
			 */
			if(password.equals(pwd)){
				drawMoney();//进入取钱操作页面
				break;
			}else{
				if(count==1){
					System.out.println("银行卡被冻结,请联系银行相关人员!");
					break;
				}
				System.out.println("密码错误:你还有"+(--count)+"次机会");
			}
		}
		
	}

	//取款页面
	private static void drawMoney() {
		while(true){
			System.out.println("你的余额是:"+remainingSum);
			System.out.println("1.取款100");
			System.out.println("2.取款200");
			System.out.println("3.取款500");
			System.out.println("4.其他取款");
			System.out.println("5.退出取款");
			Scanner scanner=new Scanner(System.in);
			System.out.println("请选择取款项目");
			int n=scanner.nextInt();
			switch(n){
				case 1:
					if(remainingSum>=100){
						System.out.println("取款100成功!");
						remainingSum-=100;
					}else{
						System.out.println("余额不足!");
					}
					break;
				case 2:
					if(remainingSum>=200){
						System.out.println("取款200成功!");
						remainingSum-=200;
					}else{
						System.out.println("余额不足200元!");
						drawMoney();
					}
					break;
				case 3:
					if(remainingSum>=500){
						System.out.println("取款500成功!");
						remainingSum-=500;
					}else{
						System.out.println("余额不足500元!");
						drawMoney();
					}
					break;
				case 4:
					other();
					break;
				case 5:
					System.out.println("退出成功!");
					return;
				default:
					System.out.println("欢迎使用,系统退出!");
			}
		}
		
		
		
	}

	//其他取款
	private static void other() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入你要取款的金额!");
		int otherMoney=scanner.nextInt();
		if(otherMoney%100!=0){//让用户取整
			System.out.println("只能取100的整数");
			other();
		}else{
			if(otherMoney>remainingSum){
				System.out.println("余额不足!");
			}else{
				System.out.println("取款"+otherMoney+"成功");
				remainingSum-=otherMoney;
				drawMoney();
			}
		}
	}
}
