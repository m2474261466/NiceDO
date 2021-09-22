package TestCode;
/**
 * 二进制中1的个数
 * @author 24742
 *
 */
public class NumberOf_1s_InBinary {
	public int NumberOf1(int n) {
        int flag=1;
       int count=0;
       while(flag!=0){
            if((flag&n)!=0){
                count++;
            }
           flag=flag<<1;
       }
       return count;
   }
}
