package day02;

public class DemReg02 {
     public static void main(String[] args) {
		//检验邮政编码（六位）
    	 String regex="[0-9][0-9][0-9][0-9][0-9][0-9]";
    	 String regex2="\\d\\d\\d\\d\\d\\d";
    	 String regex3="[0-9]{6}";//或 String regex3="\\d{6}";
    	 String regex4="[a-z]*";
    	 String regex5="\\w+\\.pom";
        String regex6="\\w{5}";
        String regex7="\\w{5,}";
        String regex8="\\w{5,10}";
        String regex9="[a-zA-Z0-9]{4,8}";

    	 System.out.println("123456".matches(regex));//true
    	 System.out.println("123456".matches(regex2));//true
    	 System.out.println("shd.pom".matches(regex5));//true
    	 System.out.println(".pom".matches(regex5));//false
    	 System.out.println("4sjjdfe".matches(regex6));//true
    	  System.out.println("ssd".matches(regex6));//false
          System.out.println("dadsadsads".matches(regex7));//true
          System.out.println("dsdsdada".matches(regex8));//true
          System.out.println("dadw-dw".matches(regex9));//false
	}
}
