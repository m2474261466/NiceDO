package day02;

import java.util.Scanner;

/**
 * 利用正则替换用户输入的消息中的敏感词
 * 
 * 
 * @author Thinkpad
 *
 */
public class DemoReplaceAll2 {
	public static void main(String[] args) {
		String messageReg="我操|尼玛的|傻逼|玛德|我日你妈|你个傻der";
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入你想说的话：");
		String line=scanner.next();
		String mess=line.replaceAll(messageReg, "***");
		System.out.println(mess);
		
		
		
	}
}
