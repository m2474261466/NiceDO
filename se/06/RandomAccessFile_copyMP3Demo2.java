package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * ����Ӳ�̵������ԣ����������дЧ�ʺܵͣ���������Ƽ������д����
 * ���д��Ч�ʺܸߣ�һ��һ���ֽڶ�д���ݣ����������Ŷ�дЧ��������Ҫ���ÿ��
 * ��д�Ĵ���
 * 1byte    8λ������
 * 1kb      1024byte
 * 1mb      1024kb
 * 1gb      1024mb 
 */
public class RandomAccessFile_copyMP3Demo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf_r=new RandomAccessFile("D:/CloudMusic/Against the Current - Legends Never Die.mp3", "r");
		RandomAccessFile raf_w=new RandomAccessFile("D:/CloudMusic/���Ƶ�3�κ��Against the Current - Legends Never Die.mp3", "rw");
		byte[] bs=new byte[1024*10];
		int len=-1;
		long p1=System.currentTimeMillis();
		System.out.println("���ڸ��ơ���");
		while((len=raf_r.read(bs))!=-1){
			raf_w.write(bs,0,len);
		}
		System.out.println("������ɡ���");
		long p2=System.currentTimeMillis();
		System.out.println("����ʱ��Ϊ��"+(p2-p1));
		raf_r.close();
		raf_w.close();
	}
}
