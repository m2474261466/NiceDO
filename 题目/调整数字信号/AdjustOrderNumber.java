package TestCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  调整数组顺序使奇数位于偶数前面 
 * @author 24742
 *
 */
public class AdjustOrderNumber {
	//方法一：创建两个数组
	 public static int[] reOrderArray (int[] array) {
         if(array.length == 0){
          return array;
      }
      Queue<Integer> jishu = new LinkedList<>();
      Queue<Integer> oushu = new LinkedList<>();
      for(int i = 0;i < array.length ;i++){
          if(array[i] % 2 != 0){
              jishu.add(array[i]);
          }else{
              oushu.add(array[i]);
          }
      }
      for(int i = 0;i < array.length ;i++){
          if(!jishu.isEmpty()){
              array[i] = jishu.poll();
          }else{
              array[i] = oushu.poll();
          }
      }
      return array;
  }
	
	 //方法二  建立一个新数组，从新数组的开头和末尾分别开始存放数字
	 public static int[] sercondreOrderArray(int[] array){
	     int[] nums = new int[array.length];
	        int head = 0;
	        int tail = array.length-1;
	        int index_head = head;
	        int index_tail = tail;
	        while(head < array.length && tail >= 0){
	            if(array[head] % 2 == 1){
	                //奇数，放前面
	                nums[index_head] = array[head];
	                index_head++;
	            }
	            head++;
	            if(array[tail] % 2 == 0){
	                //从后到前，如果为偶数，则从后开始填
	                nums[index_tail] = array[tail];
	                index_tail--;
	            }
	            tail--;
	        }
	        return nums;
	    }
	 
	 
	 
	 
	 
	 public static void main(String[] args) {
		 int[] startArray={2,4,6,5,7};
		int[] resultArray=reOrderArray(startArray);
		System.out.println(Arrays.toString(resultArray));
	}
}
