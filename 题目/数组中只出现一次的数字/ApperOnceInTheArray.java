package TestCode;
import java.util.*;
/**
 * ��������ֻ���ֹ�һ�ε���������
 * @author С���computer
 *
 */
public class ApperOnceInTheArray {
        public static void main(String[] args) {
        	Scanner sc=new Scanner(System.in);
        	int[] arr=new int[5];
        	for(int i=0;i<arr.length;i++){
        		System.out.println("������һ���Ϸ�������");
        		arr[i]=sc.nextInt();
        	}
        	int[] array=FindNumsAppearOnce(arr);
			System.out.println(Arrays.toString(array));
		}
 


        public static int[] FindNumsAppearOnce (int[] array) {
            Map<Integer,Integer> map=new HashMap<>();
             for(int i=0;i<array.length;i++){
                 map.put(array[i],i);
             }
             for(int j=0;j<array.length;j++){
                 if(!map.containsValue(j)){
                     map.remove(array[j]);
                 }
            }
             int[] arr=new int[map.keySet().size()];
             int omd=0;
             for(int j:map.keySet()){
                 arr[omd++]=j;
                 
             }
             return arr;
         }
}
