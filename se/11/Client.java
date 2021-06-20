package day11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
 * 查询自己电脑上的IP地址：cmd->ipconfig
 * @author 24742
 *
 */
public class Client {//坤哥ip：192.168.3.37
	private Socket socket;
	public Client(){
		try {
			this.socket=new Socket("192.168.3.37",8080);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void start(){
		 try {
				System.out.println("客户端连接成功！");
				
				/*
				 * 通过Socket获取字节输出流，Socket提供了方法getOutputStream()
				 * 返回OutputStream
				 * 通过返回的字节输出流写出的数据会发送给远端的计算机，对于客户端
				 * 这边而言远端计算机就是服务端
				 */
				//该线程负责接收服务端数据
				ServerHandler server=new ServerHandler(socket);
				Thread t=new Thread(server);
				t.start();
				
				OutputStream out=socket.getOutputStream();
				//转换流
				OutputStreamWriter osw=new OutputStreamWriter(out,"UTF-8");	
				//字符缓冲流
				BufferedWriter bw=new BufferedWriter(osw);
				//字符流
				PrintWriter pw=new PrintWriter(bw,true);
				Scanner scanner =new Scanner(System.in);
				System.out.println("可以发消息拉呀");
				while (true) {
					String message=scanner.next();
					pw.println(message);
					
				}
			
			       } catch (Exception e) {
				    e.printStackTrace();
			     } 
	}
    public static void main(String[] args) {
	   Client c=new Client();
	   c.start();
	}
}
class ServerHandler implements Runnable{
	private Socket socket;
	public ServerHandler(Socket socket){
		this.socket=socket;
	}
	public void run(){
		//获取输入流
		try {
			InputStream in= socket.getInputStream();
			BufferedReader br=new  BufferedReader((new InputStreamReader(in,"utf-8")));
			String message=null;
			while((message=br.readLine())!=null){
				System.out.println("服务端说："+message);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}