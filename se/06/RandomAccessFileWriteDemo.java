package day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * RandomAccessFile
 * 该类基于指针用来读写文件数据
 * 创建RandomAccessFile常用的构造方法：
 * RandomAccessFile（String path，String mode）
 * RandomAccessFile（File file，string mode）
 * 第一个参数是要进行读写的文件
 * 第二个参数为权限
 * r：只读模式  例如： RandomAccessFile raf=new RandomAccessFile(file, "r");
 * rw：读写模式  例如：RandomAccessFile raff=new RandomAccessFile("demo2.txt", "rw");
 */
public class RandomAccessFileWriteDemo {
	public static void main(String[] args) throws IOException {
		//方式一：RandomAccessFile（String path，String mode）
//		File file=new File("./demo");
//		RandomAccessFile raf=new RandomAccessFile(file, "r");
//		System.out.println("执行完毕");
		
		//方式二：RandomAccessFile（File file，string mode）
		RandomAccessFile raff=new RandomAccessFile("demo2.txt", "rw");
		System.out.println("执行完毕！");
		
		/*
		 * RandomAccessFile提供了void write（int d），
		 * 向文件中写入一个字节数据，写的是给定int值所对应的二进制的”低八位“
		 * 000000000 00000000 00000000 00000001
		 * 
		 * 例如：97转为二进制11000011，由于常用编译器会在开的时候，
		 * 将字节显示，查询ASCII编码，会显示a，其他值则查询系统默认的码
		 */
		
		raff.write(65);
		System.out.println("写入完毕！");
		
		/*
		 * RandomAccessFile在文件访问的操作全部结束的时候，要调用close（）方法来
		 * 释放所有系统资源
		 */
		
		raff.close();
	}
}
