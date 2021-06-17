package day09;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 聊天室（客户端）
 * 实例化socket就是连接服务端的过程：
 * 参数1.服务端地址
 * 参数2.服务端开启的端口
 * 通过服务IP地址找到服务器所处计算机，在通过端口找到运行在服务端计算机上的服务应用程序
 * 
 * localhost：本机IP地址
 * 查询自己电脑上的IP地址：cmd_>ipconfig
 * @author 24742
 *
 */
public class Client {
    public static void main(String[] args) {
	   try {
		Socket socket=new Socket("192.168.3.37",8080);
		System.out.println("客户端连接成功！");
		
		/*
		 * 通过Socket获取字节输出流，Socket提供了方法getOutputStream()
		 * 返回OutputStream
		 * 通过返回的字节输出流写出的数据会发送给远端的计算机，对于客户端
		 * 这边而言远端计算机就是服务端
		 */
		OutputStream out=socket.getOutputStream();
		//转换流
		OutputStreamWriter osw=new OutputStreamWriter(out,"UTF-8");	
		//字符缓冲流
		BufferedWriter bw=new BufferedWriter(osw);
		//字符流
		PrintWriter pw=new PrintWriter(bw,true);
		Scanner scanner =new Scanner(System.in);
		while (true) {
			String message=scanner.next();
			pw.println(message);
			
		}
		//pw.println("你好，我是客户端，我来了");
	       } catch (Exception e) {
		    e.printStackTrace();
	     } 
	}
}
