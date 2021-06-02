package day07;

import java.util.Scanner;

/**
 * 测试用户建行卡是否有支付燃气费用功能
 * @author Lenovo
 *
 */
public class TestUnionPay {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入密码");
		String input=scanner.next();
		CCBImpl c=new CCBImpl(2000, "123456");
		if(c.checkPwd(input)){//判断密码是否一致
			while(true){
				System.out.println("请输入你要选择的功能");
				System.out.println("1. 取钱");
				System.out.println("2. 支付燃气费");
				System.out.println("3. 查询余额");	
				System.out.println("4. 退出");
				System.out.println("请输入所选功能");
				int n=scanner.nextInt();//让用户选择功能
				switch (n) {
				case 1:
					System.out.println("请输入取钱金额");
					double num=scanner.nextDouble();
					if(c.drawMoney(num)){
						System.out.println("取钱成功,余额为"+c.getBalance());
					}else{
						System.out.println("余额不足");
					}
					break;
				case 2:
					System.out.println("请输入支付燃气费的金额");
					double num2=scanner.nextDouble();
					c.pay(num2);
					break;
				case 3:
					System.out.println("余额为:"+c.getBalance());
					break;
				case 4:
					System.out.println("退出成功!");
					return ;
				default:
					System.out.println("输入所选功能有误");
					break;
				}
			}	
		}else{
			System.out.println("密码错误!");
		}
	}
}
