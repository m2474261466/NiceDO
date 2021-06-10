package day03;
/**
 * 基本类型的包装类都支持两个常量：
 * MAX_VALUE   MIN_VALUE
 * 分别表示对应的基本类型的取值范围
 * 
 * @author Thinkpad
 *
 */
public class integerDemo2 {
	public static void main(String[] args) {
		//获取int的最大值
		int max=Integer.MAX_VALUE;
		int min=Integer.MIN_VALUE;
		System.out.println(max);
		System.out.println(min);
		
		//获取long的取值范围
		//获取byte的取值范围
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		
	}
}
