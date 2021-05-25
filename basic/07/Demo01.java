package day07;
/**
 * 三位数872
 * 求:个位,十位,百位的值分别是多少?
 * @author Lenovo
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		int a=872;
		//1.百位
		int b=a/100;
		//2.个位
		int g=a%10;
		//3.十位
		int s=a%100/10;
		System.out.println("个位:"+g+" 十位:"+s+" 百位:"+b);
	}
}
