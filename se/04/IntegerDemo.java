package day03;
/**
 * ���ڻ�������û���������Ļ���������Ϊ�����ǲ��뵽�������Ŀ����У�
 * 1.javaΪ��8���������ṩ�˶�Ӧ�İ�װ��
 * 2.6����������صİ�װ��̳���java.lang.Number
 * Number��Byte,Double,Float,Intege,Long,Short��ĸ��࣬
 * Number��һ�������࣬�����˲�ͬ���͵�����֮��ת���ķ���������6���������͵İ�װ�඼�Ǳ�ʾ�������͵�ת����
 * 
 * Integer��int������
 * 1.Integer��int�İ�װ�࣬int����java��һ�ֻ����������ݡ�
 * 2.Integerʵ�������ʹ�ã���int����Ҫ
 * 3.Integerʵ���Ƕ�Ӧ�����ã���newһ��Integerʱ��ʵ����������һ�����󣬶�int��ʱֱ�Ӵ�����
 * 4.Integer��Ĭ��ֵ��null,���Խ���null��int���͵����ݣ�intĬ��ֵ��0�����ܽ���null
 * 
 * 
 * @author 24742
 *
 */
public class IntegerDemo {
	   public static void main(String[] args) {
// Number��Byte,Double,Float,Intege,Long,Short��ĸ���
		Number n=555555;
		//��ȡn������
		System.out.println(n.getClass().getName());
//		����������ת������װ����
		int  a=3;
		int b=3;
		Integer i1=new Integer(a);
		Integer i0=new Integer(b);
		System.out.println(i1.getClass().getName());
		System.out.println(i1==i0);//flase
//		�Ƽ�ʹ�ð�װ��ľ�̬����
		Integer i2=Integer.valueOf(a);
		Integer i3=Integer.valueOf(a);
//		�Ѱ�װ����ת��Ϊ��������,��Integer�����ṩ��һ������intValue�������԰�Integer����ת��Ϊint����
		int c=i2.intValue();
		System.out.println(c);
		
		
	}

}
