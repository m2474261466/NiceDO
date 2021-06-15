package day06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *字节缓冲流：
 *字节缓冲流的缓冲区操作：
 *缓冲流实际上本质就是进行块续写操作，无论我们使用缓冲流进行任何读写方式、
 *，最终都会被缓冲流转换为块读写形式通过文件流进行实际的操作，缓冲流内部维护了一个8k（8192byte）
 *的字节流数组，用于块读写操作
 *
 *
 *BufferedInputStream:输入缓冲流
 *BufferedOutputStream:输出缓冲流
 *
 *缓冲流提供一个强制写出数据的方法：flush()
 * @author 24742
 *
 */
public class Buffer_flushDemo {
	public static void main(String[] args) throws IOException{
		//输出流
		FileOutputStream fos=new FileOutputStream("bos.txt");
		//字节缓冲流
		//把字节输出流fos放入到缓冲区
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		String str="坤哥想找个妹纸解解馋";
		byte[] bs=str.getBytes("UTF-8");
		bos.write(bs);
		bos.flush();//强制写出
		System.out.println("写入完毕！");
		bos.close();//在关闭方法中自带强制写出方法flush()
	}

}
