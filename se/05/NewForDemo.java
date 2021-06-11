package day04;
/*
 * JDK1.5之后推出新特性，新循环并不取代传统的for循环，它用来遍历集合或者数组
 */
public class NewForDemo {
	public static void main(String[] args) {
		String[] str={"one","two","three","four"};
		
		
		//for(遍历后元素的类型  存储每个元素的变量：所要遍历的数组或者集合)
		for(String s:str){
			System.out.println(s);
		}
	}
}
