package day02;
/**
 * split()
 * String 类提供给我们的分割方法返回一个字符串数组
 * @author 24742
 *
 */
public class DemoSplit {
	public static void main(String[] args) {
		 String str="您好，我现在在您家楼下，您可以下来吗？我在楼下等你";
		 String[] arrStr=str.split(",");
		// System.out.println(arrStr[4]);
		 for(int i=0;i<arrStr.length;i++){
			 System.out.println(arrStr[i]);
		 }
		 
		 
		 
		 
	}

}
