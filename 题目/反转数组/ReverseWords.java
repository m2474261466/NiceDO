package TestCode;

import java.util.Arrays;

/***
 * 反转数组
 * @author 24742
 *
 */
public class ReverseWords {
       public static void main(String[] args) {
    	   int[] arr={1,2,3,4,5,6,7,8,9,10,11};
    	   int k=4;
    	   int[] a=minNumberInRotateArray(arr,k);
    	   System.out.println(Arrays.toString(a));
    	    }
       public static int[] minNumberInRotateArray(int [] array,int k) {
           int length = array.length;
			while (k > 0)//循环几次就看k是多少
			{
			int t = 0;
			t = array[length - 1];//这是获取数组最高位置上的数字
			for (int j = length - 2; j >= 0; j--)//从倒数第二个数字开始，倒叙循环。循环主要目的就是把其他数字位置都抬高一位
			{
				array[j + 1] = array[j];
			}
			  array[0] = t;//抬高玩其他的，就可以直接把最高位上的数字赋值到0号位上了
			  k--;//完成一个循环
			}
			return array;
		}
}
