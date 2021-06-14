package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ����д��
 * ����Ӳ�̵������ԣ����������д��Ч�ʺܵͣ���������Ƽ������д����
 * ���д��Ч�ʺܸߣ�һ��һ���Լ���д���ݣ�����Ҫ����߶�д�ٶ�Ч��������Ҫ�����ÿ�ζ�д�Ĵ�������
 * 1byte     8λ������
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
		System.out.println("���ڸ���...");
		long time1=System.currentTimeMillis();
		while((len=raf_r.read(bs))!=-1){
			raf_w.write(bs,0,len);//ÿ��д��bs���ֽڴ�0��lenΪֹ
			
		}
		long time2=System.currentTimeMillis();
		System.out.println("������ϣ�");
		System.out.println("����ʱ��Ϊ"+(time2-time1));
		raf_r.close();
		raf_w.close();
	}

}
