package day03;
/**
 * ��װ���ṩ��һ����̬������parseXX��string str��������valueof��string str��
 * ���Խ��ַ�������Ϊ��Ӧ�Ļ�����������ת��Ϊ��װ���ͣ�����ǰ���Ǹ��ַ���������
 * �����ܱ�����������ȷ��ʾ������������쳣java.lang.NumberFormatException
 * @author Thinkpad
 *
 */
public class integerDemo3 {
	public static void main(String[] args) {
		String str="115556";
		System.out.println(str.getClass().getName());
		//��str�ַ���ת��Ϊint ����
		Integer n=Integer.parseInt(str);
		Integer n1=Integer.valueOf(str);
		System.out.println(n.getClass().getCanonicalName());//��ȡ����
		System.out.println(n1.getClass().getCanonicalName());//��ȡn1������
		
		//��str�ַ���ת��Ϊdouble����
		Double b=Double.valueOf(str);
		Double b1=Double.parseDouble(str);
		System.out.println(b);
		System.out.println(b1);
		
	}
}
