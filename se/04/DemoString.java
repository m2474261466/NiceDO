package day03;

public class DemoString {
	public static void main(String[] args) {
		String s="abc";
		String s2=s;
		String s3="bc";
		String s4="a"+s3;
		String s5="abc";
		System.out.println(s==s2);//true
		System.out.println(s==s4);//false
		System.out.println(s==s5);//true
		
		
		//面试笔试题
		String str=new String("ehf");
		//问以上创建了几个对象： 2个  new String（）是一个对象
		//"ehp"是一个字符串，由于常量池中没有"ehp"对象，所以要创建一个“ehp”对象
		//因此创建了两个对象，若常量池中有“ehp”，则重用常量池中的“ehp”对象，
		//那么string str=new string("ehp");则创建了一个对象
	}
	
}
