package day11;

import java.util.Arrays;

public class Demo2 {
	public static void main(String[] args) {
		int[] arr={2,5,6,8,9,10};
		for(int i=0;i<arr.length;i++){
			if(arr[i]==8){
				for(int j=i;j<arr.length-1;j++){
					arr[j]=arr[j+1];
				}	
				break;
			}
		}
		arr=Arrays.copyOf(arr,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
