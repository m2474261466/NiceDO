package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * ��RandomAccessFile����MP3�ĸ���
 */
public class RandomAccessFile_copyMP3Demo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf_r=new  RandomAccessFile("D:/CloudMusic/Against the Current - Legends Never Die.mp3","r");
		RandomAccessFile raf_w=new RandomAccessFile("D:/CloudMusic/���ƺ��Against the Current - Legends Never Die.mp3","rw");
		long time1=System.currentTimeMillis();//��ȡ��ǰʱ��ĺ�����
		System.out.println("���ڸ�����....");
		int len=-1;
		while((len=raf_r.read())!=-1){
			raf_w.write(len);
		}
		
		long time2=System.currentTimeMillis();//��ȡ��ǰʱ��ĺ�����
		System.out.println("��������Ҫ�ĺ�����"+(time2-time1)/1000+"��");
		
		raf_r.close();
		raf_w.close();
		
	}
}
