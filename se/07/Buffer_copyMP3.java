package day06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ���ļ�����������MP3����MP4
 * 
 * @author 24742
 *
 */
public class Buffer_copyMP3 {
   public static void main(String[] args) throws IOException{
	FileInputStream fis=new FileInputStream("D:/CloudMusic/Against the Current - Legends Never Die");
	FileOutputStream fos=new FileOutputStream("D:/CloudMusic/aaAgainst the Current - Legends Never Die");
	//�ļ����������
	BufferedOutputStream bos=new BufferedOutputStream(fos);
	//�ļ����뻺����
	BufferedInputStream bis=new BufferedInputStream(fis);//�������뻺����
	int len=-1;
	long time1=System.currentTimeMillis();
	while((len=bis.read())!=-1){
		bos.write(len);
		
	}
	long time2=System.currentTimeMillis();
	System.out.println("������ϣ�");
	System.out.println("����ʱ��Ϊ"+(time2-time1));
	bos.close();
	bis.close();
 }
}
