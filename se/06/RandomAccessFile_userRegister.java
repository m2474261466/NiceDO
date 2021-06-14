package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 完成用户注册功能
 * 用usd.dat文件保存用户文件信息
 * 每个用户的信息包括：用户名，密码，昵称，年龄
 * 其中年龄用int类型，其余都用字符串类型
 * 
 * @author 24742
 *
 */
public class RandomAccessFile_userRegister {
      public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("user.dat","rw");
		raf.seek(raf.length());//设置指针的位置
		   Scanner scanner=new Scanner(System.in);
		   System.out.println("请输入用户姓名");
		   String name=scanner.next();
		   System.out.println("请输入用户密码");
		   String password=scanner.next();
		   System.out.println("请输入用户昵称");
		   String nick=scanner.next();
		   System.out.println("请输入用户年龄");
		   int age=scanner.nextInt();
		
		
		      //对数组的扩容写入用户名字
	    	    byte[] data1=name.getBytes("UTF-8");
		        data1=Arrays.copyOf(data1, 32);
		        raf.write(data1);
		
		      //对数组的扩容写入用户名字
				byte[] data2=password.getBytes("UTF-8");
				data2=Arrays.copyOf(data2, 32);
				raf.write(data2);
				
				//对数组的扩容写入用户名字
				byte[] data3=nick.getBytes("UTF-8");
				data3=Arrays.copyOf(data3, 32);
				raf.write(data3);
				
				//写入用户的年龄
				raf.writeInt(age);
				
				System.out.println("注册成功");
	
				
				
		
		
	}
}
