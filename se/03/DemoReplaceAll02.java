package day02;

import java.util.Scanner;

/**
 * ���������滻�û��������Ϣ�е����д�
 * @author 24742
 *
 */
public class DemoReplaceAll02 {
	 public static void main(String[] args) {
		 //���磺���д�����
		 String messageReg="�ҿ�|����Ҫ��|��|��ȥ�����˸����|���������";
		 Scanner scanner =new Scanner(System.in);
		 System.out.println("��������Ϣ����");
		 String line=scanner.next();
		String    str=line.replaceAll(messageReg, "********");
             System.out.println(str);              
		
		
	}
	

}
