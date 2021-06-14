package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * 
 */
public class RandomAccessFileWriteDemo2 {
	public static void main(String[] args) throws IOException {
		String str="hello";
		//将字符串转换为字节
		byte[] b=str.getBytes();
		RandomAccessFile raff=new RandomAccessFile("demo.txt", "rw");
		//设置指针位置，RAF提供了获取指针位置的方法seek()
		raff.seek(10);//设置指针位置5，追加字符串world
		//获取指针的位置（游标位置）RAF提供了获取指针位置的方法getFilePointer()返回long
		long p=raff.getFilePointer();
		System.out.println("写入前的位置："+p);
		raff.write(b);
		System.out.println("写入完毕！！！！");
		p=raff.getFilePointer();
		System.out.println("写入后的指针位置："+p);
		raff.close();
	}
}
