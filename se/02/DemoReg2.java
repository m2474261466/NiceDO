package day02;

public class DemoReg2 {
	public static void main(String[] args) {
		//ÑéÖ¤ÓÊÕş±àÂë
		String reg="[0-9][0-9][0-9][0-9][0-9][0-9]";
		String reg1="\\d\\d\\d\\d\\d\\d";
		String reg3="\\d{6}";
		System.out.println("456789".matches(reg3));//t
		
		String reg4="[a-z]*";
		String reg5="\\w+\\.pom";
		String reg6="\\d?[a-z]*";
		System.out.println("sdasda".matches(reg4));//t
		System.out.println("".matches(reg4));//t
		System.out.println("shd.pom".matches(reg5));//t
		System.out.println(".pom".matches(reg5));//f
		System.out.println("dasfa".matches(reg6));//t
		
		
		String reg7="\\w{5}";
		String reg8="\\w{5,}";
		String reg9="\\w{5,10}";
		String reg10="[a-zA-Z0-9]{4,8}";
		System.out.println("sasd".matches(reg7));//f
		System.out.println("sdnadjafj".matches(reg8));//t
		System.out.println("dkkddoo".matches(reg9));//t
		System.out.println("sdaji-ns".matches(reg10));//f
		
		
		
		
	}
	
}
