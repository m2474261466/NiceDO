package day01;
/**
 * �������ͻ��Ⱥźͻ����������ͻ��Ⱥ�����:
 * �������ͻ��Ⱥ�:
 * 1)ָ��ͬһ����
 * 2)ͨ��һ�����õ��޸Ļ�Ӱ�쵽��һ������
 * �����������ͻ��Ⱥ�:
 * 1)��ֵ
 * 2)��һ���������޸Ĳ���Ӱ�쵽��һ������
 * @author Lenovo
 *
 */
public class StudentTest2 {
	public static void main(String[] args) {
		/*
		 * zs��zssָ���ͬһ������,����ֻ��һ������
		 */
		Student zs=new Student();
		Student zss=zs;
		zs.age=20;zss.age=28;//zs.age=? 28
		int a=5;
		int b=a;//��b��ֵ��ֵ��a
		a=8;b=6;//a=? 8
		
	}
}
