package day04;

import java.util.Scanner;

/**
 * 
 * @author Lenovo
 *
 */
public class HomeWork06 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("���������(����:2012)");
		int year=scanner.nextInt();
		System.out.println("�������·�(����:1)");
		int month=scanner.nextInt();
		int days=0;//����
		switch(month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				days=31;
				break;
			case 2:
				if((year%4==0&&year%100!=0)|| year%400==0){
					days=29;
				}else{
					days=28;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				days=30;
				break;
			default:
				System.out.println("��������!");
				return;
		}
		System.out.println(year+"��"+month+"����"+days+"��");
		
		
	}
}
