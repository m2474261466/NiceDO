package day02;

public class DemoReg3 {
	public static void main(String[] args) {
		//匹配手机号（十一位）
		
		
		
		//(+86或+0086)？ 15648445196
		/*
		 * “|”表示“或”的关系
		 * 
		 * 
		 * "^" 表示字符串开始
		 * "$" 代表字符串结束
		 */
		String phonereg="^(\\+86|\\+0086)?\\s*\\d{11}$";
		System.out.println("+86  12345678911".matches(phonereg));
		
		
		//邮箱
		String email="kunkun12345678912@qq869.com";
		String emailreg="^\\w{4,18}@[a-z0-9]+\\.[a-z]{2,4}$";
		if(email.matches(emailreg)){
			System.out.println("通过");
		}else{
			System.out.println("no");
		}
	}
}
