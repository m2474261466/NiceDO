package day07;
/**
 * �����ĵݹ�:
 * @author Lenovo
 *
 */
public class Method_dg01 {
	public static int test(int a){
		//�ݹ�
		if(a==1){//�ݹ��ֹͣ����
			return 1;
		}else{
			a--;
			System.out.println(a);
			return test(a);
		}
	}
	
	public static void main(String[] args) {
		int n=test(5);
		System.out.println(n);
	}
	
	
	
	
}
