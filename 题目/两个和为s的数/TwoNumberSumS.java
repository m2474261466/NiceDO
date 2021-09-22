package TestCode;
import java.util.*;
/**
 * ������Ϊs����
 * @author С���computer
 *
 */
public class TwoNumberSumS {
     public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
    	int[] arr=new int[5];
    	for(int i=0;i<arr.length;i++){
    		System.out.println("������һ���Ϸ�������");
    		arr[i]=sc.nextInt();
    	}
    	ArrayList<Integer> array=FindNumbersWithSum(arr,8);
		System.out.println(array);
	}
     public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
         ArrayList<Integer> resList = new ArrayList<>();
         int low = 0,high = array.length-1;
         while(low < high){
             int nowSum = array[low] + array[high];
             if(nowSum < sum){
                 low++;
             }else if(nowSum > sum){
                 high--;
             }else{
                 //low��ǰ�����ң���һ�����ǳ˻���С�ġ�
                 resList.add(array[low]);
                 resList.add(array[high]);
                 break;
             }
         }
         return resList;
     }
}
