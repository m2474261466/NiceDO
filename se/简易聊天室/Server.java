package day11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 聊天室（服务端）
 * 运行在服务端ServerSocket中有两个主要的作用:
 * 1.向系统中申请对外的服务器端口，客户端就是通过这个端口与服务端建立连接
 * 2.监听服务端端口，等待客户端连接，一旦一个客户端通过Socket与服务端建立连接，
 * 那么ServerSocket会创建一个Socket与该客户端通讯
 * 3.注意该端口号不能和其他程序端口号冲突，否则会抛出端口号被占用异常
 * @author 24742
 *
 *
 *
 *ServerSocket提供的方法：
 *accept()该方法是一个阻塞方法，调用后即等待客户端的连接，一旦一个客户端通过端口连接，
 *那么accept方法会返回一个Socket实例，通过这个Socket实例可以与刚连接的客户端交互了
 */
public class Server { 
	private ServerSocket server;
	private Socket socket;
	private ExecutorService pool;
	//存储每一个客户端连接成功之后所获取的输出流(数据共享)
	private PrintWriter[] outAll=new PrintWriter[0];
	public  Server(){
		 try {
			this.server=new ServerSocket(8080);
			//创建线程池
			this.pool=Executors.newFixedThreadPool(2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//处理业务
	private void start(){
		try {
			while(true){
				System.out.println("等待客户端连接...........");
				this.socket=server.accept();//阻塞状态，等待客户端连接
				System.out.println("客户端连接成功！");
				ClientHandler clinet=new ClientHandler(socket);
				/*Thread t=new Thread(clinet);
				t.start();*/
				pool.execute(clinet);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//此线程负责每个客户端的输出和输入
class ClientHandler implements Runnable{//内部类
	private Socket socket;
	private InetAddress adress;//获取远程端口地址
	private int port;//获取远程端口号
	public ClientHandler(Socket socket){
		this.socket=socket;
		this.adress=socket.getInetAddress();
		this.port=socket.getPort();
	}
	public void run(){
		PrintWriter pw=null;
		try{
			System.out.println(adress+","+port+"连上了");
			//获取输出流
			OutputStream out=socket.getOutputStream();
		    pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(out,"utf-8")),true);
			
			synchronized (this) {
				//给outAll数组扩容
				outAll=Arrays.copyOf(outAll, outAll.length+1);
				//将pw存放在outAll数组中的最后一个元素
				outAll[outAll.length-1]=pw;
				//统计在线人数
				System.out.println("在线人数"+outAll.length);
			}
			
			
			
			//通过Socket获取输入流
			InputStream in=socket.getInputStream();
			//输入转换流
			InputStreamReader isr=new InputStreamReader(in,"UTF-8");
			//输入字符流
			BufferedReader br=new BufferedReader(isr);
			
			//读取数据
			/*
			 * 客户端在断开连接时，不同的系统会有不同的反应，
			 * Linux系统的客户断开后，br.readLine会返回null
			 * windows系统的客户端断开后，br.readLine会报java.net.SocketException异常
			 * 
			 */
			String line=null;
			while((line=br.readLine())!=null){
				System.out.println(adress+":"+port+":"+line);//接受消息
				synchronized (this) {
					//遍历所有客户端的输出流
					for(int i=0;i<outAll.length;i++){
						PrintWriter	 p=outAll[i];
						//给每一个客户端发送内容
						p.println(line);
						}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//处理客户端断开后的操作，将客户端的输出流从共享数组中删除
			synchronized (this) {
				for(int i=0;i<outAll.length;i++){
					if(outAll[i]==pw){
						outAll[i]=outAll[outAll.length-1];
						outAll=Arrays.copyOf(outAll, outAll.length-1);
			        }
			
				}
			}
			System.out.println(adress+","+port+"下线了");
			System.out.println("在线人数"+outAll.length);
			
			
			try {
				//客户端断开连接后,服务端关闭该客户的Socket,这样一来可以释放资源
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
      public static void main(String[] args) {
		Server s=new Server();
		s.start();
	}
}
