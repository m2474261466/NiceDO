package day03;
/**
 * ��װ�඼�ṩ��һ����̬����:parseXX(String str����������valueof(String str)
 * ���Խ��ַ�������Ϊ��Ӧ�Ļ������ͻ��߰�װ���ͣ�����ǰ���Ǹ��ַ��������������ܱ�����������ȷ��ʾ��
 *  ����������쳣java.lang.NumberformatException
 * @author 24742
 *
 */
public class IntegerDemo03 {
           public static void main(String[] args) {
			String str="2261116";
			System.out.println(str.getClass().getName());
			//��str�ַ���ת��Ϊint����
			Integer n1=Integer.parseInt(str);
			Integer n=Integer.valueOf(str);
			System.out.println(n.getClass().getName());
			System.out.println(n1.getClass().getName());
			Double d1=Double.parseDouble(str);
			Double d2=Double.valueOf(str);
			System.out.println(d1);
			System.out.println(d2);
		}
}
