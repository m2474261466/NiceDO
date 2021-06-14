package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

import day01.string;

/*
 * 修改用户数据密码，前提是登陆成功才可以修改
 */
public class RandomAccessFileUserupdate {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("demo5.txt","rw");
		Scanner scanner=new Scanner(System.in);
		System.out.println("输入用户名：");
		String user_name=scanner.next();
		System.out.println("输入密码");
		String user_pwd=scanner.next();
		byte[] bs=new byte[32];
		boolean nameflag=false;
		boolean pwdflag=false;
		for(int i=0;i<raf.length()/100;i++){
			raf.seek(i*100);
			System.out.println("指针位置："+raf.getFilePointer());
			raf.read(bs);
			String name=new String(bs,"UTF-8").trim();
			if(name.equals(user_name)){
				System.out.println("账号输入正确！");
				nameflag=true;
				raf.read(bs);
				String pwd=new String(bs,"UTF-8").trim();
				if(pwd.equals(user_pwd)){
					System.out.println("密码输入正确！");
					pwdflag=true;
					System.out.println("修改密码：");
					String str=scanner.next();
					raf.seek(i*100+32);//设置指针位置 或者(raf.getFilePointer()-32)
					byte[] pdd=str.getBytes("UTF-8");
					pdd=Arrays.copyOf(pdd,32);//扩容
					raf.write(pdd);
					System.out.println("密码修改成功！");
					
				}
				break;
			}
		}
		if(nameflag==false){
			System.out.println("账号错误！！");
			return;
		}
		
		if(pwdflag==false){
			System.out.println("密码错误！！");
		}
	}
}
