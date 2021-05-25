package day07;
/**
 * 方法的递归:
 * @author Lenovo
 *
 */
public class Method_dg01 {
	public static int test(int a){
		//递归
		if(a==1){//递归的停止条件
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
