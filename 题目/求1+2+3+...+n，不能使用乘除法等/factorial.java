package TestCode;
/*
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字
 * 及条件判断语句（A?B:C）。
 */
public class factorial {
	public int Sum_Solution(int n) {
        //声明sum与n分开，避免混乱
        int sum = n;
        //用boolean类型的中间变量，使用&&的短路规则，进行递归结束
        boolean flag = (n > 0) && ((sum += Sum_Solution(n-1)) > 1);
        return sum;
    }
}
