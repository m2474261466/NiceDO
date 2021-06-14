package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * 用RandomAccessFile进行MP3的复制
 */
public class RandomAccessFile_copyMP3Demo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf_r=new  RandomAccessFile("D:/CloudMusic/Against the Current - Legends Never Die.mp3","r");
		RandomAccessFile raf_w=new RandomAccessFile("D:/CloudMusic/复制后的Against the Current - Legends Never Die.mp3","rw");
		long time1=System.currentTimeMillis();//获取当前时间的毫秒数
		System.out.println("正在复制中....");
		int len=-1;
		while((len=raf_r.read())!=-1){
			raf_w.write(len);
		}
		
		long time2=System.currentTimeMillis();//获取当前时间的毫秒数
		System.out.println("复制所需要的毫秒数"+(time2-time1)/1000+"秒");
		
		raf_r.close();
		raf_w.close();
		
	}
}
