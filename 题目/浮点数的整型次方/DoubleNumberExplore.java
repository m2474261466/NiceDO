package TestCode;
/**
 * 求double型数字的n次方
 * @author 24742
 *
 */
public class DoubleNumberExplore {
	  public static double Power(double base, int exponent) {
	        double result=1.0;
	        if(exponent==0){
	            return 1.00000;
	        }
	        if(exponent==1){
	            return base;
	        }
	      
	        
	       
	        if(exponent<0){
	        	 for(int i=1;i<=exponent;i++){
	        		 result=result*base;
		         }
	            result=1/result;
	            return result;
	          }
              if(exponent>0){
            	  for(int i=1;i<=exponent;i++){
 	        		 result=result*base;
 		         }
	            return result;
	           }
			return result;
	       }
	  
	  public static void main(String[] args) {
		System.out.println(Power(3.000,-3));
	}
}
