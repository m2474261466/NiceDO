package day01;
/**
 * ��������ָ��nullʱ������ָ���쳣
 * @author Lenovo
 *
 */
public class StudentTest3 {
	public static void main(String[] args) {
		Student zs=new Student();
		zs=null;
		zs.age=28;
		/*
		 * ������ָ���쳣:��������Ϊnull,���еĶ���ᱻGC����������
		 * �����,��˶���û�����������,���Է�����ָ���쳣
		 */
		System.out.println(zs.age);
	}
}
