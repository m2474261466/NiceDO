package TestCode;
/***
 * 二维数组的查找
 * @author 24742
 *
 */
public class TwoArraySearch {
	public static boolean Find(int target, int [][] array) {
        if(array==null||array.length==0) return false;
       int m=array.length,n=array[0].length;
       int i=m-1,j=0;
       while(j<n&&i>=0){
            if(array[i][j]==target) return true;
            else if(array[i][j]>target) i--;
            else j++;
        }
        return false;
   }
	
}
