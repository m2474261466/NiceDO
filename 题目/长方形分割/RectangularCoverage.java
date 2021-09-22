package TestCode;
/*
 *  ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ���ͬһ�������ܹ��ж����ֲ�ͬ�ķ�����

       ����n=3ʱ��2*3�ľ��ο���3�ֲ�ͬ�ĸ��Ƿ���(��ͬһ������)
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
