package day02;

import java.util.Scanner;

public class DemoReg03 {
     public static void main(String[] args) {
		/*
		 * 匹配手机号
		 */
    	 /*
    	  * +0086 15829216986
    	  * (+86或者+0086) ?15829216986
    	  */
    	 /*
    	  * 分组()可以将一系列正则表达式看作一个整体
    	  * 分组时可以使用“|”表示或
    	  * 
    	  * “^”和”$“
    	  * "^"代表字符串开始
    	  * ”$“代表字符串结束
    	  */
    	 String phoneReg="^(\\+86|\\+0086)?\\s\\d{11}$";
    	 System.out.println("15829216986".matches(phoneReg));
    	 
    	 
    	 /*
    	  * 匹配邮箱
    	  */
    	 String mailReg="^\\w{4,18}@[a-z0-9]{1,}\\.[a-z]{2,4}$";
    	 Scanner scanner=new Scanner(System.in);
    	 String mail=scanner.next();
    	 if(mail.matches(mailReg)==true){
    		 System.out.println("邮箱通过");
    	 }else{
    		 System.out.println("亲输入正确的邮箱地址，谢谢");
    	 }
    	 
    	 
    	 
    	 
    	 
	}
}
