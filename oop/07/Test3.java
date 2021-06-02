package day07;
/**
 * 接口不能被实例化
 * @author Lenovo
 *
 */
public class Test3 {
	public static void main(String[] args) {
		//DemoInterfaceLoad d=new DemoInterfaceLoad();//接口不能被实例化
		
		DemoInterfaceLoad d=new TOO();//接口指向实现的对象(向上造型)
		d.load();
		
		//用匿名内部类来实现接口中的所有方法
		DemoInterfaceLoad dd=new DemoInterfaceLoad() {
			public void load() {
				System.out.println("这是匿名内部类来重写接口中的load()方法");
			}
		};
		dd.load();
	}
}

class TOO implements DemoInterfaceLoad {
	public void load(){
		System.out.println("重写了DemoInterfaceLoad中的load()方法");
	}
}