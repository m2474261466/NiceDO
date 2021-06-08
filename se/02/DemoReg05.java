package day02;

import java.util.Arrays;

public class DemoReg05 {
   public static void main(String[] args) {
	String  str="java    python  c++  c";
	String[] arr=str.split("\\s+");
	   System.out.println(Arrays.toString(arr));
	    String line="100*98-20+56=1016";
	  String [] arr2= line.split("\\*|\\-|\\+|\\=");
	   System.out.println(Arrays.toString(arr2));
	   
	   
	   
	   }
	   
	   
	   
	   
}
	
	
	
	
	

