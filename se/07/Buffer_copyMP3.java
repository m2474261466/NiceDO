package day06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 用文件缓冲流复制MP3或者MP4
 * 
 * @author 24742
 *
 */
public class Buffer_copyMP3 {
   public static void main(String[] args) throws IOException{
	FileInputStream fis=new FileInputStream("D:/CloudMusic/Against the Current - Legends Never Die");
	FileOutputStream fos=new FileOutputStream("D:/CloudMusic/aaAgainst the Current - Legends Never Die");
	//文件输出缓冲流
	BufferedOutputStream bos=new BufferedOutputStream(fos);
	//文件输入缓冲流
	BufferedInputStream bis=new BufferedInputStream(fis);//建立输入缓冲流
	int len=-1;
	long time1=System.currentTimeMillis();
	while((len=bis.read())!=-1){
		bos.write(len);
		
	}
	long time2=System.currentTimeMillis();
	System.out.println("复制完毕！");
	System.out.println("复制时间为"+(time2-time1));
	bos.close();
	bis.close();
 }
}
