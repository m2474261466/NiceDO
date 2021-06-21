package day12;
/**
 * JDK1.5版本之后推出了一个新的特性
 * 增强for循环，也称新循环
 * 
 * 新循环并不能代替传统的for循环，它只能用来遍历集合或者数组使用
 * @author 24742
 *
 */
public class NewForDemo {
      public static void main(String[] args) {
		String[] arr={"one","two","three","four"};
		//传统的for循环
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}

		//增强for循环
		/*
		 * 新循环是编译器认可，编译器会在编译源代码时改为使用传统的for循环遍历数组或者集合
		 */
		for(String s:arr){//（数据类型  名称：数组或者集合）类型必须保证集合或者数组中的元素都是同一类型，同一类型返回该类型，不同类型返回Object
			System.out.println(s);
		}
	}
}
