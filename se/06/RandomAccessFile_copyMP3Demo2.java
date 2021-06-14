package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * 由于硬盘的物理性，导致随机读写效率很低，因此我们推荐“块读写”；
 * 快读写的效率很高，一次一组字节读写数据，所以若想着读写效率我们需要提高每次
 * 读写的次数
 * 1byte    8位二进制
 * 1kb      1024byte
 * 1mb      1024kb
 * 1gb      1024mb 
 */
public class RandomAccessFile_copyMP3Demo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf_r=new RandomAccessFile("D:/CloudMusic/Against the Current - Legends Never Die.mp3", "r");
		RandomAccessFile raf_w=new RandomAccessFile("D:/CloudMusic/复制第3次后的Against the Current - Legends Never Die.mp3", "rw");
		byte[] bs=new byte[1024*10];
		int len=-1;
		long p1=System.currentTimeMillis();
		System.out.println("正在复制。。");
		while((len=raf_r.read(bs))!=-1){
			raf_w.write(bs,0,len);
		}
		System.out.println("复制完成。。");
		long p2=System.currentTimeMillis();
		System.out.println("复制时间为："+(p2-p1));
		raf_r.close();
		raf_w.close();
	}
}
