package day05;

import day05.Outer.StaticInner;

public class TestInnerClass {
	public static void main(String[] args) {
		//�����ڲ������(�����ⲿ�����)
		//����MemberInner�е�method()��ʽһ
		Outer.MemberInner m=new Outer().new MemberInner();
		m.method();
		
		//����MemberInner�е�method()��ʽ��
		//Outer o=new Outer();
		//o.t();
		
		//������̬�ڲ���(�������ⲿ��)
		StaticInner s=new StaticInner();
		s.method();
		
		Outer o=new Outer();
		o.m();
		
		Outer p=new Outer(){
			public void m(){
				System.out.println("���������ڲ���");
			}
		};
		p.m();
		
	}
	
}

class Outer{
	private int a=30;
	private static int b=10;
	/*public void t(){
		//�ڲ���ֻ�������ⲿ��
		MemberInner m=new MemberInner();
		m.method();
	}*/
	
	//��Ա�ڲ���
	class MemberInner{
		private int a=20;
		public void method(){
			int a=40;
			System.out.println("��Ա�ڲ���");
			System.out.println("�ֲ�����:"+a);
			System.out.println("��Ա�ڲ����еĳ�Ա����:"+this.a);
			System.out.println("�ⲿ���Ա����:"+Outer.this.a);
		}
	}
	
	//��̬�ڲ���
	static class StaticInner{
		private int x=10;
		public void method(){
			System.out.println("��̬�ڲ���");
			System.out.println(x);
			System.out.println(b);
			//System.out.println(a);//ֻ�ܷ����ⲿ��ľ�̬��Ա
		}
	}
	
	//�ֲ��ڲ���
	public void m(){//��ʼ
		/*
		 * �ֲ��������ܼ����δ�
		 */
		int x=50;//jdk1.8�汾֮ǰ�ֲ��ڲ�����ʾֲ�������ʱ��,����Ҫ���ֲ�����ʹ��final����
		class LocalInner{
			private int o=25;
			//private static int p=40;//�ھֲ��ڲ����в��ܶ��徲̬����
			public void method(){
				System.out.println("�ֲ��ڲ���");
				System.out.println(o);
				System.out.println(a);
				System.out.println(b);
				System.out.println(x);
			}						
		}
		LocalInner l=new LocalInner();
		l.method();		
		
	}//��β
	
	
	
	
	
}