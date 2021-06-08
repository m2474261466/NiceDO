package day02;

import java.util.Scanner;

public class DemoReg4 {
	public static void main(String[] args) {
		/*（作业）
		 * 用户注册
		 * 账号，5-10个字符
		 * 密码，6-8个字符
		 * 确定密码；
		 * 邮箱，满足邮箱格式
		 * 手机，11位（1开头）
		 */
		
		
		//账号
		Scanner scanner=new Scanner(System.in);
		String account="^\\w{5,10}$";
		System.out.println("账号：");
		String username=scanner.next();
		if(!username.matches(account)){
			System.out.println("请规范输入账号！！！");
			return;
		}
		
		
		//密码
		String password="^\\w{6,8}$";
		System.out.println("密码：");
		String inputword=scanner.next();
		if(!inputword.matches(password)){
			System.out.println("请规范输入密码！！！");
			return;
		}
		
		
		
		//确定密码
		System.out.println("请再次输入密码：");
		String pwd=scanner.next();
		if(!pwd.equals(inputword)){
			System.out.println("与密码不一致！");
			return;
		}
		
		
		//邮箱格式："chao12345678912@qq869.com";
		String email="^[a-z0-9]{11,18}@[a-z0-9]{4,}\\.[a-z]{3,5}$";
		System.out.println("邮箱：");
		String emailword=scanner.next();
		if(!emailword.matches(email)){
			System.out.println("请规范输入邮箱！！");
			return;
		}
		
		//手机号
		String phone="^1\\d{10}$";
		System.out.println("手机号：");
		String phonenumber=scanner.next();
		if(!phonenumber.matches(phone)){
			System.out.println("请规范输入手机号！！");
			return;
		}
		
		System.out.println("注册成功！！");
	}
}
