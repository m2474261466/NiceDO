package TestCode;
/**
 * ��ת��������СԪ��
 * @author 24742
 *
 */
public class OutputTheMinWordOfArrays {
       public static void main(String[] args) {
    	   //����һ
	int[] arr={3,4,5,1,2,3};
	       /*	 arrs.sort(arr);
         System.out.println(arr[0]);*/
	
	 //������   ������
   /*   int min=arr[0];
      for(int i:arr){
 	   if(arr[i]<min){
 		   min=arr[i];
 	   }
    }*/
	getMin(arr);
	
	
	}
       
       
       
      
       public static int getMin(int[] arr){
    	 //������   ���ַ�
    	    /*
    	   ���������
    	   ��1����ǰ��0��Ԫ�ذᵽĩβ��Ҳ�����������鱾����һ��������Сֵ
    	   ��2��һ��������ֲ��ң���high-low=1ʱ��high������Сֵ
    	   ��3�������βԪ�غ��м�Ԫ�ض����ʱ��ֻ��˳�����
    	   */
    		   int len=arr.length;
    		   if(len==0)
    		       return 0;
    		   int low=0,high=len-1;
    		   if(arr[low]<arr[high]) //�������鱾��
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
    		
    
       
			public static int minInOrder(int [] arr) { //˳�����
			    int min=arr[0];
			    for(int num:arr){
			        if(num<min)
			            min=num;
			    }
			     return min;
			}    
       
       
       
       
       
       
       
}
