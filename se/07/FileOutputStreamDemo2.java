package day06;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import day01.string;

/* 2:追加操作,若文件有数据则全部保留,从该文件末尾追加内容
* FileOutputStream(String path,boolean append)
* FileOutputStream(File file,boolean append)
* append默认为false，当设置为true，则在文件末尾进行追加。
*/
public class FileOutputStreamDemo2 {
	public static void main(String[] args) throws IOException {
		FileOutputStream bos=new FileOutputStream("fos.txt",true);
		String str="大家大家";
		byte[] bs=str.getBytes("UTF-8");
		bos.write(bs);
		System.out.println();
		bs.clone();
	}
}
