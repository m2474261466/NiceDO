package day07;
/**
 * 1.实现接口用关键字implements并且重写接口中的所有方法
 * 2.接口弥补了继承的单一性,可以实现多个接口并以逗号隔开
 * @author Lenovo
 *
 */
public class AAA implements DemoInterfaceLoad,DemoInterfaceLoad2 {
	public void load(){
		System.out.println("读取的是AAA的U盘资料");
	}
	
	public int load2(){
		return 2;
	}
	
	public static void main(String[] args) {
		DemoInterfaceLoad a=new AAA();//接口指向它的实现类(向上造型)
		a.load();
		System.out.println();
		DemoInterfaceLoad b=new BBB();//接口指向它的实现类(向上造型)
		b.load();
	}
	
}

class BBB implements DemoInterfaceLoad {
	public void load(){
		System.out.println("读取的是BBB的U盘资料");
	}
}