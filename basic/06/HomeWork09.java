package day04;
/**
 * 有数列为：9，99，999，...，9999999999。
 * 要求使用程序计算此数列的和
 * 第一种分析:
 * 0*10		+9;
 * 9*10		+9;
 * 99*10	+9;
 * 999*10	+9;
 * ...
 * long s=0;
 * s=s*10+9;
 * @author Lenovo
 *10^-1=9;
 *10^2-=99;
 *...
 *
 */
public class HomeWork09 {
	public static void main(String[] args) {
		//方法一:
		long sum=0;//总和
		/*long s=0;
		for(int i=0;i<10;i++){
			s=s*10+9;
			sum=sum+s;
		}
		System.out.println("有数列为：9，99，999，...，9999999999="+sum);*/
		//方法二:
		/*for(int i=1;i<=10;i++){
			//Math.pow(a,b)方法是求a的b次方,a和b以及所求结果都是double类型
			sum+=(long)Math.pow(10,i)-1;
		}
		System.out.println("有数列为：9，99，999，...，9999999999="+sum);*/
	}
}
