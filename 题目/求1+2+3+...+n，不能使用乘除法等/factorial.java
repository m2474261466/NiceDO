package TestCode;
/*
 * ��1+2+3+...+n��
 * Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ���
 * �������ж���䣨A?B:C����
 */
public class factorial {
	public int Sum_Solution(int n) {
        //����sum��n�ֿ����������
        int sum = n;
        //��boolean���͵��м������ʹ��&&�Ķ�·���򣬽��еݹ����
        boolean flag = (n > 0) && ((sum += Sum_Solution(n-1)) > 1);
        return sum;
    }
}
