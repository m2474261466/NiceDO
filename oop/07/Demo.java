package day07;
/**
 * ��JDK1.7�汾֮���Ƴ��ڽӿ�����Ҳ��������ͨ����
 * ����һ��Ҫ���������ǰ���"public static"��"default"
 * @author Lenovo
 *
 */
public interface Demo {
	default void test(){
		
	}
	
	public static int test01(){
		return 0;
	}
}
