package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取所有用户的数据
 * 将读取出来的所有用户数据输出，以格式name,password,nick,age输出
 * @author 24742
 *
 */
public class RandomAccessFile_userReads {
	public static void main(String[] args) throws IOException {
    RandomAccessFile raf=new RandomAccessFile("user.dat","r"); 
    byte[ ] bs=new byte[32];
    for(int i=0;i<raf.length()/100;i++){
    	//读取名字
    	raf.read(bs);
    	String name=new String(bs,"UTF-8").trim();
    	
    	//读取密码
    	raf.read(bs);
    	String password=new String(bs,"UTF-8").trim();
    	
    	//读取昵称
    	raf.read(bs);
    	String nick=new String(bs,"UTF-8").trim();
    	
    	//获取年龄
    	int age=raf.readInt();//读取到int类型（4个字节）
    	
       System.out.println("名字为"+name+",密码为"+password+"，昵称为"+nick+"年龄为"+age);
       System.out.println("指针位置为："+raf.getFilePointer());

      }
     raf.close();
	}
  }
