package TestCode;

import java.util.Arrays;

/***
 * ��ת����
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
			while (k > 0)//ѭ�����ξͿ�k�Ƕ���
			{
			int t = 0;
			t = array[length - 1];//���ǻ�ȡ�������λ���ϵ�����
			for (int j = length - 2; j >= 0; j--)//�ӵ����ڶ������ֿ�ʼ������ѭ����ѭ����ҪĿ�ľ��ǰ���������λ�ö�̧��һλ
			{
				array[j + 1] = array[j];
			}
			  array[0] = t;//̧���������ģ��Ϳ���ֱ�Ӱ����λ�ϵ����ָ�ֵ��0��λ����
			  k--;//���һ��ѭ��
			}
			return array;
		}
}
