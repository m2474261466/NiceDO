package day10;
/**
 * 线程提供了一个方法void join()该方法允许一个线程在另一个线程上等待，
 * 直到执行完毕后再继续运行，这样做可以协调线程间的“同步运行”
 * 同步运行:代码执行有先后顺序（单线程运行时同步，多线程也可以进行同步运行操作）
 * 异步运行：代码各执行各的（多线程运行代码时异步的）
 * @author 24742
 *
 */
public class JoinDemo {
       public static void main(String[] args) {
		//线程（下载）
    	Thread download=new Thread(){
    		public void run(){
    			System.out.println("开始下载图片");
    			for(int i=1;i<100;i++){
    				System.out.println("下载进度"+i+"%");
    				try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
    			}
    			System.out.println("图片下载完毕！");
    		}
    	};
    	
    	//线程（显示图片）
    	Thread show=new Thread(){
    		public void run(){
    			try {
					download.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    			System.out.println("开始显示图片");
    		}
    	};
    	download.start();
    	show.start();
	}
}
