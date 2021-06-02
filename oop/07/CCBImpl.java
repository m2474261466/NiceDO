package day07;
/**
 * 用户使用建行卡功能
 * @author Lenovo
 *
 */
public class CCBImpl implements CCB {
	private double money;//用户余额
	private String pwd;//用户设置的密码
	
	public CCBImpl(double money, String pwd){//给余额,密码初始化
		this.money=money;
		this.pwd=pwd;
	}
	
	/**判断密码是否正确*/
	public boolean checkPwd(String input) {
		if(pwd.equals(input)){//判断用户设置的密码和用户输入的密码是否一样
			System.out.println("密码正确");
			return true;
		}
		return false;
	}

	/**查看余额*/
	public double getBalance() {
		return money;
	}

	/**取钱*/
	public boolean drawMoney(double number) {
		if(number<=money){//用户输入的取钱金额小于等于卡片中的余额则取钱成功
			money-=number;
			return true;
		}
		return false;
	}

	/**支付燃气*/
	public void pay(double number) {
		if(number<=money){
			System.out.println("缴费成功!");
			money-=number;
			return ;
		}
		System.out.println("余额不足");
	}
	
	/*
	 * @Override是用来检测该方法是否是重写的,
	 * 如果该方法不是重写却在方法前面加了@Override
	 * 则程序会报错,此时去掉@Override则会消除错误
	 * 是重写则不会报错
	 */
	/*@Override
	public void payy(double number) {
		// TODO 代办事项,注意编写格式

	}*/

}
