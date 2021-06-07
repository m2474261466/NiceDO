package day01;

public class stringcommon {
	
	public static void main(String[] args) {
		// C 函数少 库少 Java方法比较多 库比较多
				String str = "hello world!!";
				System.out.println(str.charAt(3));
				System.out.println(str.indexOf("h", 3));
				System.out.println(str.indexOf("o"));
				// 方法定义 规则：见名知意 索引 数据库 表 主键 本质 索引 （数据结构 二叉树） = 目录 查找方便
				System.out.println(str.lastIndexOf("o"));
				// ASCII 65 97 a 98b 99c 100d 101 e
				// 方法重载
				String sub = str.substring(2, 5);// 直接从开始位置截取到末尾
				System.out.println("sub:" + sub);
				CharSequence charSequence = str.subSequence(2, 5);
				System.out.println("charSequence:" + charSequence);
				// String 实现了 charSequence 接口
				// 多态 动态绑定 封装 继承 多态
				CharSequence ch = new String("abc");
				System.out.println(ch);
				System.out.println(sub);
				System.out.println(str.indexOf(101));//ASCLL为101的字符（e）位置为多少
				// equals 比较值相等就可以 地址不用相等 new == 值相等，地址也要相等
				String first = new String("abc");
				String second = new String("ABC");
				System.out.println("equals:" + (first.equals(second)));
				System.out.println("ignoreCase:" + first.equalsIgnoreCase(second));
				System.out.println("绝对等:" + (first == second));
				// 字符串有个概念常量池 重用常量池中的值
				String third = "abc";
				String fourth = "abc";
				String fifth = "abc" + "def" + "ghi";// 尽量少进行拼接操作
				System.out.println("fifth" + fifth);
				System.out.println(third == fourth);
				System.out.println(third.equals(fourth));
				String sixth = "hello";
				String seventh = "java";
				// I concat you!!
				// 字符串操作本质就是对数组进行操作
				System.out.println(sixth.concat(seventh));//concat拼接
				System.out.println(seventh.replace('a', 'e'));
				System.out.println(sixth.toUpperCase());// 变为大写
				System.out.println(sixth.toLowerCase());// 变为小写
				int num = 5;
				num = 12;
				boolean flag = true;
				char[] chars = { 'a', 'b', 'c', 'd' };
				// 将一个任意类型转换为字符串类型
				// 非静态可以调用静态 不推荐 静态不能调用非静态
				// jdk 1.5 int=Integer byte = Byte
				System.out.println(String.valueOf(12));
				System.out.println(String.valueOf(chars, 2, 1));
				// 比较器
				// Comparable 接口中的一个方法 CompareTo 用来比较字符串 先后顺序 字典序() A B
				// A-B 小于0 （A<B ） 等于0 (A=B)大于零(A>B)
				System.out.println("g".compareTo("f"));
				// java se中 每种基本类型都对应有一个包装类型
				// JDK1.5 中 int a =12 Integer a =12
				// 拆箱 装箱 本质 基本类型和包装类型可以互换
				int a = 12; // max min C语言
				Integer b = new Integer(12);// 类即有方法也有属性
				Integer c = 12;
				byte b1 = 9;
				Byte b2 = 9;
				char c2 ='c';
				Character c1 = new Character('d');
				Character c3='d';//拆箱 装箱 
				System.out.println("c1="+c1);
				System.out.println("c3="+c3);
				
				System.out.println(Byte.MIN_VALUE);
				System.out.println(Byte.MAX_VALUE);
				System.out.println(Integer.MAX_VALUE);
				System.out.println(Integer.MIN_VALUE);
		
		
	}
}
