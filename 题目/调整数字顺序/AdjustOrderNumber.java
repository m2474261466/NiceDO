package TestCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  ��������˳��ʹ����λ��ż��ǰ�� 
 * @author 24742
 *
 */
public class AdjustOrderNumber {
	//����һ��������������
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
	
	 //������  ����һ�������飬��������Ŀ�ͷ��ĩβ�ֱ�ʼ�������
	 public static int[] sercondreOrderArray(int[] array){
	     int[] nums = new int[array.length];
	        int head = 0;
	        int tail = array.length-1;
	        int index_head = head;
	        int index_tail = tail;
	        while(head < array.length && tail >= 0){
	            if(array[head] % 2 == 1){
	                //��������ǰ��
	                nums[index_head] = array[head];
	                index_head++;
	            }
	            head++;
	            if(array[tail] % 2 == 0){
	                //�Ӻ�ǰ�����Ϊż������Ӻ�ʼ��
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
