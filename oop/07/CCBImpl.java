package day07;
/**
 * �û�ʹ�ý��п�����
 * @author Lenovo
 *
 */
public class CCBImpl implements CCB {
	private double money;//�û����
	private String pwd;//�û����õ�����
	
	public CCBImpl(double money, String pwd){//�����,�����ʼ��
		this.money=money;
		this.pwd=pwd;
	}
	
	/**�ж������Ƿ���ȷ*/
	public boolean checkPwd(String input) {
		if(pwd.equals(input)){//�ж��û����õ�������û�����������Ƿ�һ��
			System.out.println("������ȷ");
			return true;
		}
		return false;
	}

	/**�鿴���*/
	public double getBalance() {
		return money;
	}

	/**ȡǮ*/
	public boolean drawMoney(double number) {
		if(number<=money){//�û������ȡǮ���С�ڵ��ڿ�Ƭ�е������ȡǮ�ɹ�
			money-=number;
			return true;
		}
		return false;
	}

	/**֧��ȼ��*/
	public void pay(double number) {
		if(number<=money){
			System.out.println("�ɷѳɹ�!");
			money-=number;
			return ;
		}
		System.out.println("����");
	}
	
	/*
	 * @Override���������÷����Ƿ�����д��,
	 * ����÷���������дȴ�ڷ���ǰ�����@Override
	 * �����ᱨ��,��ʱȥ��@Override�����������
	 * ����д�򲻻ᱨ��
	 */
	/*@Override
	public void payy(double number) {
		// TODO ��������,ע���д��ʽ

	}*/

}
