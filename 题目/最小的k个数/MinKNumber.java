package TestCode;

import java.util.ArrayList;

/**
 * 最小的k个数
 * @author 24742
 *
 */
public class  MinKNumber {
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
	       ArrayList<Integer> array = new ArrayList<Integer>();
	        if( k > input.length || k<0){
	            return array;
	        }
	         for(int i = 0;i<input.length-1;i++){
	             for(int j = 0;j< input.length-i-1;j++){
	                 if(input[j]>input[j+1]){
	                     int tmp = input[j];
	                     input[j] = input[j+1];
	                     input[j+1] = tmp;
	                 }
	              
	             }
	         }
	         
	        for(int i = 0;i<k;i++){
	            array.add(input[i]);
	        }
	        return array;
	    }
}
