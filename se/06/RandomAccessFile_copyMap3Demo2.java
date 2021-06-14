package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 块续写：
 * 由于硬盘的物理性，导致随机读写的效率很低，因此我们推荐“块读写”，
 * 块读写的效率很高，一次一组自己读写数据，所以要想提高读写速度效率我们需要，提高每次读写的次数减少
 * 1byte     8位二进制
 * 1kb        102tybe
 * 1mb      1024kb
 * 1gb        1024mb
 * 1T          1024gb 
 * @author 24742
 *
 */
public class RandomAccessFile_copyMap3Demo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf_r=new RandomAccessFile("D:/CloudMusic/Against the Current - Legends Never Die.mp3","r");
		RandomAccessFile raf_w=new RandomAccessFile("D:/CloudMusic/00Against the Current - Legends Never Die1.mp3","rw");
		byte[] bs=new byte[1024*10];
		int len=-1;
		System.out.println("正在复制...");
		long time1=System.currentTimeMillis();
		while((len=raf_r.read(bs))!=-1){
			raf_w.write(bs,0,len);//每次写入bs个字节从0到len为止
			
		}
		long time2=System.currentTimeMillis();
		System.out.println("复制完毕！");
		System.out.println("复制时间为"+(time2-time1));
		raf_r.close();
		raf_w.close();
	}

}
