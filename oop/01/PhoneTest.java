package day01;
/**
 * 手机的具体对象
 * @author Lenovo
 *
 */
public class PhoneTest {
		
	public void test(Phone phone){
		System.out.println("我的手机:"+phone.brand+",它的颜色是:"+phone.color);
	}
	
	public static void main(String[] args) {
		//方法一:
		Phone phone=new Phone();
		phone.brand="小米";
		phone.color="黑色";
		phone.sendMessage();
		
		Phone phone02=new Phone();
		phone02.brand="华为";
		phone02.color="红色";
		phone02.playGame();
		
		//方法二:
		Phone p=new Phone();
		p.color="绿色";
		p.brand="华为";
		
		PhoneTest t=new PhoneTest();
		t.test(p);
		
	}
}
