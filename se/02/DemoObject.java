package day02;
/**
 * Object (��������)
 * ���е��඼��һ�������Object��Ĭ�ϵĸ�����java.lang.object
 * Object���͵����ñ�����ָ���κζ����������ͣ���
 * Object ����������
 * toString()����һ��String���ͣ��÷��������ǵ�ǰ����ת��Ϊһ���ַ���
 * Object�Ѿ�ʵ�ָ÷��������ص��ַ����ǵ�ǰ����ľ�������ã���
 * ��ʽΪ����������@ɢ����
 * ���ַ�����ʵ�ʿ��������岻������ͨ����Ҫʹ���������ʱ��д
 * toString��������ʱ�ǳ����õĵ��Թ��ߣ�һ�㷵�ص������еĳ�Ա������
 * ǿ�ҽ����Զ��Ķ���Ҫ��дtoString()����
 * 
 * @author 24742
 *
 */

public class DemoObject {
	 public static void main(String[] args) {
		Person p=new Person();
		p.setAge(30);
		p.setName("liuhua");
		System.out.println(p);
		//System.out.println(�������);//ֱ�ӵ���toString()����
	}

}
