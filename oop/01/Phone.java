package day01;
/**
 * 手机类(模板)
 * @author Lenovo
 *
 */
public class Phone {
	//  特征/属性---成员变量(全局变量)
	int ram;		//内存
	String color;	//颜色
	String brand;	//品牌
	
	public void sendMessage(){//行为---方法
		System.out.println("我的:"+brand+",我手机的颜色:"+color+",发消息");
	}
	
	public void playGame(){
		System.out.println("我的:"+brand+",我手机的颜色:"+color+",玩游戏");
	}
}
