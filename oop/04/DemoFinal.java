package day03;
/**
 * 
 * final��ʾ:
 * final���γ�Ա����,ֻ�����ֳ�ʼ����ʽ
 * 	1.������ͬʱ����ʼ��
 * 	2.�ڹ��췽���г�ʼ��
 *
 *	final:���յ�,���ɸı��-------����Ӧ��Ч�ʷǳ���
 *	1)���α���:�������ɸı�
 *  2)������:���ǲ����Ա��̳е�
 *  3)���η���:�����ǲ����Ա���д��
 *
 * @author Lenovo
 *
 */
public final class DemoFinal {
	final int age;
	
	public DemoFinal(){
		this.age=20;
	}
	
	public void test(){
		//age=20;//�������,age��final������˲��ܸı�
	}
	
/*class Demo extends DemoFinal(){//�������,DemoFinal��final����,���Բ��ܱ��̳�
		
}*/

class A{
	final public void woo(){
		
	}
}

class B extends A{
	/*public void woo(){//�������,ԭ�����ڸ���A�е�woo()������final�����ǲ��ܱ�������д��
		
	}*/
}





}
