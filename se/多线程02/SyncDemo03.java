package day10;
/**
 * 静态方法若使用了Synchronized修饰后，那么该方法一定具有同步效果
 * 静态方法的对象是当前类的对象
 * Class类的每一个实例用于表示JVM加载的一个类，当JVM加载一个类的时候就会
 * 实例化一个Class的实例用于表示它，每个类在JVM内部都有且只有一个Class的实例
 * ，所以静态方法锁的就是当前类对应的Class的实例
 * @author 24742
 *
 */
public class SyncDemo03 {
	public static final int AGE=2;
     public static void main(String[] args) {
		FOO1 Foo1=new FOO1();
		Thread t1=new Thread(){
			public void run(){
				FOO1.dosome();
			}
		};
		Thread t2=new Thread(){
			public void run(){
				FOO1.dosome();
			}
		};
		t1.start();
		t2.start();
	}
}
class FOO1{
	public static void dosome(){
		try {
			String name=Thread.currentThread().getName();
			System.out.println(name+"正在运行dosome方法");
			Thread.sleep(5000);
			System.out.println(name+"运行dosome方法完毕");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}
}
