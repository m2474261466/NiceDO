package day10;
/**
 * ��Ч����Сͬ����Χ�����ٱ�֤������ȫ��ǰ���¾��������Ч�ʡ�
 * 
 * ͬ���飺
 * Synchronized(ͬ��������){
 * ��Ҫͬ�����д���Ƭ��
 * }
 * 
 * ͬ������Ը����׼ȷ��������Ҫͬ�����еĴ���Ƭ�Σ�����������Ч��Сͬ����Χ����߲���Ч��
 * ��������Ҫע�⣬���뱣֤����߳̿���ͬ��������������ͬһ������ſ���
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

//��װ�̵���
class Shop{
	public  void buy(){
		try {
			String  name=Thread.currentThread().getName();
			System.out.println(name+"ѡ�·�");
			Thread.sleep(5000);
			synchronized(this){
				System.out.println(name+"���·�");
				Thread.sleep(5000);
			}
			System.out.println("��������");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
