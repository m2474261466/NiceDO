package day01;
/**
 * �ֻ���(ģ��)
 * @author Lenovo
 *
 */
public class Phone {
	//  ����/����---��Ա����(ȫ�ֱ���)
	int ram;		//�ڴ�
	String color;	//��ɫ
	String brand;	//Ʒ��
	
	public void sendMessage(){//��Ϊ---����
		System.out.println("�ҵ�:"+brand+",���ֻ�����ɫ:"+color+",����Ϣ");
	}
	
	public void playGame(){
		System.out.println("�ҵ�:"+brand+",���ֻ�����ɫ:"+color+",����Ϸ");
	}
}
