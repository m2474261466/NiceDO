package day02;
/**
 * replaceAll(String regex,String str);
 * String提供用于字符串替换方法，
 * replaceAll：将字符串中匹配正则表达式regex的字符串全部替换成str
 * replace:替换部分内容
 * @author 24742
 *
 */

public class DemoReplaceAll {
	
	public static void main(String[] args) {
		//replace:替换部分数字
		String str="1555呵呵的226的的555的的话";
		
	   //将字符串str中的"226"替换成"呵呵的 "
		 //str=str.replace("226","呵呵的");
		 //System.out.println(str);
		
		//str=str.replaceAll("1555|226|555","呵呵的");//这种也可以
		str=str.replaceAll("\\d+","呵呵的");
		System.out.println(str);
		
		
		
		
	}

}
