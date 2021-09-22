package TestCode;
/*
 *  我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，从同一个方向看总共有多少种不同的方法？

       比如n=3时，2*3的矩形块有3种不同的覆盖方法(从同一个方向看)
 */
public class RectangularCoverage {
	 public int rectCover(int n) {
         if(n <= 2) return n;
        int a1 = 1;
        int a2 = 2;
        int ret = 0;
        for (int i = 3; i <= n; i++) {
            ret = a1 + a2;
            a1 = a2;
            a2 = ret;
        }
        return ret;
    }
}
