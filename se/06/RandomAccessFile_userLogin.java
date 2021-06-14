package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 用户登录功能，如果登录成功显示该用户的所有信息
 * 
 * @author 24742
 *
 */
public class RandomAccessFile_userLogin {
	public static void main(String[] args) throws IOException  {
		RandomAccessFile raf=new RandomAccessFile("user.dat","r");
		System.out.println("用户登录！");
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入用户名");
		String userName=scanner.next();
		System.out.println("请输入密码");
		String userPassword=scanner.next();
		byte[] bs=new byte[32];
		boolean nameFlag=false;//判断用户账号是否正确
		boolean pwdFlag=false;//判断用户密码是否正确
		for(int i=0;i<raf.length()/100;i++){
			//设置指针位置
			raf.seek(i*100);
          System.out.println("指针的位置为："+raf.getFilePointer());
          //读取账号
          raf.read(bs);
          String name=new String(bs,"UTF-8").trim();
          //判断用户输入的账号和文本中的账号是否一致
          if(name.equals(userName)){
        	nameFlag=true;
        	//读取密码
        	raf.read(bs);
        	String password=new String(bs,"UTF-8").trim();
        	if(password.equals(userPassword)){
        		pwdFlag=true;
        		System.out.println("登录成功");
        		//读取昵称
        		raf.read(bs);
        		String nick=new String(bs,"UTF-8").trim();
        		raf.read(bs);
        		int age=raf.readInt();
        		System.out.println("用户的信息是：账号"+name+",密码"+password+",昵称"+",年龄"+age);
        		
        	}
        	break;
          }
		}
		if(nameFlag==false){
			System.out.println("密码错误");
			return;
		}
		if(pwdFlag==false){
			System.out.println("密码错误");
			return;
		}
		raf.close();
	}

}
