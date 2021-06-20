package day11;

import java.util.Arrays;

public class Demo02 {
     public static void main(String[] args) {
		int[] arr={2,5,7,34,0,3};
		for(int i=0;i<arr.length;i++){
			arr[3] = arr[arr.length-1];
			arr = Arrays.copyOf(arr, arr.length-1);
			break;
			
		}
		System.out.println(Arrays.toString(arr));
		 
	}
}
