package day02;

public class DemoReg3 {
	public static void main(String[] args) {
		//ƥ���ֻ��ţ�ʮһλ��
		
		
		
		//(+86��+0086)�� 15648445196
		/*
		 * ��|����ʾ���򡱵Ĺ�ϵ
		 * 
		 * 
		 * "^" ��ʾ�ַ�����ʼ
		 * "$" �����ַ�������
		 */
		String phonereg="^(\\+86|\\+0086)?\\s*\\d{11}$";
		System.out.println("+86  12345678911".matches(phonereg));
		
		
		//����
		String email="kunkun12345678912@qq869.com";
		String emailreg="^\\w{4,18}@[a-z0-9]+\\.[a-z]{2,4}$";
		if(email.matches(emailreg)){
			System.out.println("ͨ��");
		}else{
			System.out.println("no");
		}
	}
}
