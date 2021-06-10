package day03;
/**
 * 包装类都提供了一个静态方法:parseXX(String str），或者是valueof(String str)
 * 可以将字符串解析为对应的基本类型或者包装类型，但是前提是该字符串描述的数据能被基本类型正确表示，
 *  否则会运行异常java.lang.NumberformatException
 * @author 24742
 *
 */
public class IntegerDemo03 {
           public static void main(String[] args) {
			String str="2261116";
			System.out.println(str.getClass().getName());
			//将str字符串转换为int类型
			Integer n1=Integer.parseInt(str);
			Integer n=Integer.valueOf(str);
			System.out.println(n.getClass().getName());
			System.out.println(n1.getClass().getName());
			Double d1=Double.parseDouble(str);
			Double d2=Double.valueOf(str);
			System.out.println(d1);
			System.out.println(d2);
		}
}
