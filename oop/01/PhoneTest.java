package day01;
/**
 * �ֻ��ľ������
 * @author Lenovo
 *
 */
public class PhoneTest {
		
	public void test(Phone phone){
		System.out.println("�ҵ��ֻ�:"+phone.brand+",������ɫ��:"+phone.color);
	}
	
	public static void main(String[] args) {
		//����һ:
		Phone phone=new Phone();
		phone.brand="С��";
		phone.color="��ɫ";
		phone.sendMessage();
		
		Phone phone02=new Phone();
		phone02.brand="��Ϊ";
		phone02.color="��ɫ";
		phone02.playGame();
		
		//������:
		Phone p=new Phone();
		p.color="��ɫ";
		p.brand="��Ϊ";
		
		PhoneTest t=new PhoneTest();
		t.test(p);
		
	}
}
