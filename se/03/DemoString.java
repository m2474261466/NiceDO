package day02;

public class DemoString {
	public static void main(String[] args) {
		     String s="abc";//创建了一个对象
		     String s2=s;
		     String s3="bc";		     
		     String s4="a"+s3;
		     String s5="abc";
		     System.out.println(s==s2);//true
		     System.out.println(s==s4);//false
		     System.out.println(s==s5);//true
		     //面试笔试题
		     String str=new String("ehf");
		     //问以上创建了几个对象：2个对象  newString（）是一个对象
		     //“enh”是一个字符串，由于常量中没有“ehf”对象，所以要创建一个“efh”对象
		     //因此创建了两个对象，诺常量池中有“ehf”，则重用常量池中的“efh”对象，那么String str=new String("ehf ");则创建一个对象
		
		
		
		
		
		
	}

}
