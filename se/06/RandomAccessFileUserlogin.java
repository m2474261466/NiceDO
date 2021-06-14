package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import day01.string;

/**
 * 用户登录功能，如果登录成功显示该用户的所有信息
 * @author Thinkpad
 *
 */
public class RandomAccessFileUserlogin {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("demo5.txt","r");
		Scanner scanner=new Scanner(System.in);
		System.out.println("账号输入：");
		String user_name=scanner.next();
		System.out.println("输入密码：");
		String user_pwd=scanner.next();
		byte[] bs=new byte[32];
		boolean nameflag=false;
		boolean pwdflag=false;
		for(int i=0;i<raf.length()/100;i++){
			raf.seek(i*100);//设置指针位置
			System.out.println("指针位置："+raf.getFilePointer());
			raf.read(bs);//获取姓名
			String name=new String(bs,"UTF-8").trim();
			if(name.equals(user_name)){
				System.out.println("账号正确！");
				nameflag=true;
				raf.read(bs);//获取密码
				String pwd=new String(bs,"UTF-8").trim();
				if(pwd.equals(user_pwd)){
					System.out.println("密码输入正确！");
					pwdflag=true;
					System.out.println("登录成功！！");
					raf.read(bs);//获取昵称
					String nick=new String(bs,"utf-8");
					int age=raf.readInt();
					System.out.println("输出用户信息为"+name+","+pwd+","+nick+","+age);
				}
				break;
			}
		}
		if(nameflag==false){
			System.out.println("账号错误");
			return;
		}
		if(pwdflag==false){
			System.out.println("密码错误");
		}
	}
}
