package day02;

import java.util.Scanner;

public class DemoReg04 {
	public static void main(String[] args) {
		/*
		 *用户注册
		 *账号：要求5-10个字符
		 *密码：要求6-8个字符
		 *邮箱：满足邮箱格式
		 *手机:11位数字（首位以1开始）
		 */
		System.out.println("欢迎来到用户注册界面");
		System.out.println("请输入您的账号：");
		String passwReg="^\\w{5,10}$";
		Scanner scanner=new Scanner(System.in);
		//输入账号
		String passwReg1=scanner.next();
		if(!passwReg1.matches(passwReg)){
			System.out.println("请输入正确的账号");
			return;			
		}
		//输入密码
		System.out.println("请输入您的密码");		
		String passReg="^\\w{6,8}$";
		String passReg1=scanner.next();
		if(!passReg1.matches(passReg)){
			System.out.println("请输入正确的密码");
			return;
		}
		//确认密码
          System.out.println("请再次输入密码");
		String userConfirm=scanner.next();
		if(!passReg1.equals(userConfirm)){
			System.out.println("密码不一致");
			return;
		}
		//输入邮箱
		System.out.println("请输入您的邮箱");		
		String  mailReg="\\w{4,18}@[a-z]{1,}\\.[a-z]{2,4}$";
		String mailReg1=scanner.next();
		if(!mailReg1.matches(mailReg)){
			System.out.println("请输入正确的邮箱的地址");
			return;
		}
		//输入手机号
		System.out.println("请输入您的手机号码");
		String  phoneReg="^ 1\\d{10}$";
		String phoneReg1=scanner.next();
		if(phoneReg.matches(phoneReg)==true){
			System.out.println("请输入正确的手机号码");
			return;
		}else{
			System.out.println("注册成功");
		}
		
		
		
		
		
		
		
		
		
		
	}

}
