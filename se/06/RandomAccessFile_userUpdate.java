package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 修改用户数据,前提是登录成功之后才可修改
 * 
 * @author 24742
 *
 */
public class RandomAccessFile_userUpdate {
   public static void main(String[] args) throws IOException {
	RandomAccessFile raf=new RandomAccessFile("user.dat","rw");
	System.out.println("用户登录");
    Scanner scanner=new Scanner(System.in);
    System.out.println("请输入账号");
    String username=scanner.next();
    System.out.println("请输入密码");
    String userpassword=scanner.next();
    byte[] bs=new byte[32];
    boolean nameFlag=true;
    boolean pwdFlag=false;
    for(int i=0;i<raf.length()/100;i++){
    	raf.seek(i*100);
    	System.out.println("指针的位置为"+raf.getFilePointer());
    	raf.read(bs);
    	String name=new String(bs,"UTF-8").trim();
    	if(name.equals(username)){
    		nameFlag=true;
    	raf.read(bs);
    	String password=new String(bs,"UTF-8").trim();
    	if(password.equals(userpassword)){
    		//修改密码
    		pwdFlag=true;
    		System.out.println("修改密码");
    		String newPwd=scanner.next();
    		//设置指针位置
    		raf.seek(i*100+32);
    		byte[] bytes=newPwd.getBytes("UTF-8");
    		bytes=Arrays.copyOf(bytes, 32);
    		raf.write(bytes);//修改后密码的字节写入文本里
    		System.out.println("修改成功");
    		
    	   }
    	break;
         }
      }
      if(nameFlag==false){
    	  System.out.println("账号错误");
      }
      if(pwdFlag==false){
    	  System.out.println("密码错误");
         
         
    	  
    	  
      }
     }
   }
