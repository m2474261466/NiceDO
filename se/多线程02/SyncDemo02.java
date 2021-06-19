package day10;
/**
 * 有效的缩小同步范围可以再保证并发安全的前提下尽可能提高效率。
 * 
 * 同步块：
 * Synchronized(同步监视器){
 * 需要同步运行代码片段
 * }
 * 
 * 同步块可以更灵活准确的锁定需要同步运行的代码片段，这样可以有效缩小同步范围并提高并发效率
 * ，但是需要注意，必须保证多个线程看到同步监视器对象是同一个对象才可以
 * @author 24742
 *
 */
public class SyncDemo02 {
       public static void main(String[] args) {
		Shop shop=new Shop();
		Thread t1=new Thread(){
			public void run(){
				shop.buy();
			}
		};
		Thread t2=new Thread(){
			public void run(){
				shop.buy();
			}
		};
		t1.start();
		t2.start();
	}
}

//服装商店类
class Shop{
	public  void buy(){
		try {
			String  name=Thread.currentThread().getName();
			System.out.println(name+"选衣服");
			Thread.sleep(5000);
			synchronized(this){
				System.out.println(name+"试衣服");
				Thread.sleep(5000);
			}
			System.out.println("结账走人");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
