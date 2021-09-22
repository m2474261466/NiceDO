package TestCode;
import java.util.*;
/**
 * 两个和为s的数
 * @author 小马的computer
 *
 */
public class TwoNumberSumS {
     public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
    	int[] arr=new int[5];
    	for(int i=0;i<arr.length;i++){
    		System.out.println("请输入一个合法的数字");
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
                 //low从前往后找，第一个就是乘积最小的。
                 resList.add(array[low]);
                 resList.add(array[high]);
                 break;
             }
         }
         return resList;
     }
}
