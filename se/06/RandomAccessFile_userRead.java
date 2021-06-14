package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import day01.string;

/**
 *读取所有用户的数据、
 *将读取出来的用户数据以格式name，pwd，nick，age输出；
 * @author Thinkpad
 *
 */
public class RandomAccessFile_userRead {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("user.dat","r");
		byte[] bs=new byte[32];
		for(int i=0;i<raf.length()/100;i++){
			raf.read(bs);
			//获取名字
			String name=new String(bs,"utf-8").trim();
			
			//读取密码
			raf.read(bs);
			String pwd=new String(bs,"utf-8").trim();
			
			//获取昵称
			raf.read(bs);
			String nick=new String(bs,"utf-8").trim();
			
			//读取年龄
			int ag=raf.readInt();//读取到int类型4字节
			System.out.println(name +"   "+pwd+"  "+nick+"   "+ag);
			System.out.println(raf.getFilePointer());//获取指针位置
		}
		raf.close();
	}
}
