package TestCode;
/**
 * 旋转数组求最小元素
 * @author 24742
 *
 */
public class OutputTheMinWordOfArrays {
       public static void main(String[] args) {
    	   //方法一
	int[] arr={3,4,5,1,2,3};
	       /*	 arrs.sort(arr);
         System.out.println(arr[0]);*/
	
	 //方法二   暴力法
   /*   int min=arr[0];
      for(int i:arr){
 	   if(arr[i]<min){
 		   min=arr[i];
 	   }
    }*/
	getMin(arr);
	
	
	}
       
       
       
      
       public static int getMin(int[] arr){
    	 //方法三   二分法
    	    /*
    	   三种情况：
    	   （1）把前面0个元素搬到末尾，也就是排序数组本身，第一个就是最小值
    	   （2）一般情况二分查找，当high-low=1时，high就是最小值
    	   （3）如果首尾元素和中间元素都相等时，只能顺序查找
    	   */
    		   int len=arr.length;
    		   if(len==0)
    		       return 0;
    		   int low=0,high=len-1;
    		   if(arr[low]<arr[high]) //排序数组本身
    		       return arr[low];
    		   while(low<high){
    		       int mid=low+(high-low)/2;
    		       if(arr[low]==arr[mid] && arr[high]==arr[mid])
    		           return minInOrder(arr);
    		       if(arr[mid]>=arr[low])
    		           low=mid;
    		       else if(arr[mid]<=arr[high])
    		           high=mid;
    		       if(high-low==1)
    		           return arr[high];
    		   }
    		   return -1;
    		}
    		
    
       
			public static int minInOrder(int [] arr) { //顺序查找
			    int min=arr[0];
			    for(int num:arr){
			        if(num<min)
			            min=num;
			    }
			     return min;
			}    
       
       
       
       
       
       
       
}
