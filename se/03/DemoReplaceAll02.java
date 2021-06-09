package day02;

import java.util.Scanner;

/**
 * 利用正则替换用户输入的信息中的敏感词
 * @author 24742
 *
 */
public class DemoReplaceAll02 {
	 public static void main(String[] args) {
		 //例如：敏感词如下
		 String messageReg="我靠|臭不要脸|操|我去年买了哥大金表|我贼尼玛的";
		 Scanner scanner =new Scanner(System.in);
		 System.out.println("请输入消息内容");
		 String line=scanner.next();
		String    str=line.replaceAll(messageReg, "********");
             System.out.println(str);              
		
		
	}
	

}
