package day02;

import java.util.Scanner;

/**
 * ���������滻�û��������Ϣ�е����д�
 * 
 * 
 * @author Thinkpad
 *
 */
public class DemoReplaceAll2 {
	public static void main(String[] args) {
		String messageReg="�Ҳ�|�����|ɵ��|���|��������|���ɵder";
		Scanner scanner=new Scanner(System.in);
		System.out.println("����������˵�Ļ���");
		String line=scanner.next();
		String mess=line.replaceAll(messageReg, "***");
		System.out.println(mess);
		
		
		
	}
}
