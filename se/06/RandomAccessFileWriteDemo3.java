package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/*
 * 按照系统默认字符集转换（不推荐，因为存在平台差异）
 * byte[] getBytes(String scan) scan:字符集
 * 按照给定的字符集转换，字符集的名字不区分大小写；
 * GBK:国际编码，中文占2个字节
 * UTF-8:也称万国码，中文占3个字节
 * ISO8859-1：欧洲字符集，不支持中文。
 */
public class RandomAccessFileWriteDemo3 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("demo2.txt", "rw");
		String str="你好，树先生";
		byte[] b=str.getBytes("UTF-8");//将字符串转换为字节
		System.out.println(b.length);
		raf.write(b);
		System.out.println("输入完毕！！");
		raf.close();
	}
}
