package day02;
/**
 * ������(����)
 * @author Lenovo
 *
 */
public class Docter extends Person {
	String uiform;//�Ʒ�
	
	public Docter(){
		super("��ҽ��", 20);
		uiform="��ɫ�Ʒ�";
		System.out.println("Person������Decoter�Ĺ��췽��");
	}
	
	public void test(){
		System.out.println(age);//�̳��˸����age����/����
	}	
	
	public void cure(){
		//super.sleep();//���ó������sleep����
		//sleep();//�������������sleep����
		System.out.println("����ҽ��ÿ�촩��"+uiform+","+name);
	}
	
	//˯����Ϊ
	public void sleep(){
		System.out.println("����Docter��ķ���");
	}
	
	public static void main(String[] args) {
		/*
		 * ��������(�ص�):
		 * 1:�����͵�����ָ�����������
		 * 2:�ܵ�"."����ʲô,����������
		*/

		Person docter=new Docter();//���͵Ķ�̬(��������)
		//Docter d=(Docter)docter;//����ǿ������ת��,��Person����ת��ΪDocter����
		docter.sleep();
		Docter docter02=new Docter();
		//docter02.cure();//����
	}
}
