package day04;

import java.io.File;

/*
 * 通过Fil获取文件信息
 */
public class FileMessageDemo {
	public static void main(String[] args) {
		File file=new File("demo.txt");
		//获取名字，file提供了getname（）获取文件或者目录名字
		String name=file.getName();
		System.out.println(name);
		
		
		//获取文件数据字节长度，File提供了lengthh（）获取文件数据或者目录长度
		long length=file.length();
		System.out.println(length);
		
		
		//是否可读可写
		boolean c=file.canRead();
		System.out.println(c);
		boolean c2=file.canWrite();
		System.out.println(c2);
	}
}
