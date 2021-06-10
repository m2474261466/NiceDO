package day03;
/**
 * 包装类提供了一个静态方法：parseXX（string str），或者valueof（string str）
 * 可以将字符串解析为对应的基本类型数据转换为包装类型，但是前提是该字符串描述的
 * 数据能被基本类型正确表示，否则会运行异常java.lang.NumberFormatException
 * @author Thinkpad
 *
 */
public class integerDemo3 {
	public static void main(String[] args) {
		String str="115556";
		System.out.println(str.getClass().getName());
		//将str字符串转换为int 类型
		Integer n=Integer.parseInt(str);
		Integer n1=Integer.valueOf(str);
		System.out.println(n.getClass().getCanonicalName());//获取类型
		System.out.println(n1.getClass().getCanonicalName());//获取n1的类型
		
		//将str字符串转换为double类型
		Double b=Double.valueOf(str);
		Double b1=Double.parseDouble(str);
		System.out.println(b);
		System.out.println(b1);
		
	}
}
