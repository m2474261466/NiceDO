package day07;
/**
 * �ж�������ָ��Ķ����Ƿ��Ǹ�����
 * ��instanceof�ؼ���
 * @author Lenovo
 *
 */
public class MultiTypeDemo {
	public static void main(String[] args) {
		/*COO c=new COO();
		AOO a=new COO();
		AOO d=new DOO();
		
		if(c instanceof AOO){
			System.out.println("true AOO");
		}
		
		if(a instanceof AOO){
			System.out.println("a������ָ����new COO()������AOO����");
		}
		
		if(d instanceof AOO){
			System.out.println("true AOO");
		}
		
		if(d instanceof COO){
			System.out.println("true COO");
		}*/
		
		//���ʹ�С��ϵ: ����>����  �ӿ�>ʵ����
		AOO a2=new AOO();
		AOO o=new BOO();//��������,������ת��Ϊ������(�Զ���ת��)
		BOO o1=(BOO)o;//������ת��������(����o��ָ�Ķ������BOO)
		Inter1 o2=(Inter1)o;//����o��ָ�Ķ���ʵ����Inter1
		Inter1 o3=o1;//�Զ�����ת��
		
		//COO o3=(COO)o;//ClassCastException����ת���쳣
		/*
		 * �ж������,��ͽӿ��Ƿ��й�ϵ(Ҳ������������һ��),
		 * ���ʱ����Ҫ���ж���instanceof
		 */
		if(o instanceof COO){
			System.out.println("��");
		}
		
		if(o instanceof Inter1){
			System.out.println("o instanceof Inter1����");
		}
		if(a2 instanceof BOO){//a2ֻ��AOO����,���Ͳ������¼���
			System.out.println("BOO");
		}
		if(o3 instanceof BOO){
			System.out.println("o3 instanceof BOO");
		}
		
	}
}

interface Inter1{
	
}

class AOO{
	
}

class BOO extends AOO implements Inter1{
	
}

class COO extends AOO{
	
}

class DOO extends COO{
	
}