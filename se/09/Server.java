package day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

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
      public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(8080);
			System.out.println("等待客户端连接...........");
			Socket socket=server.accept();//阻塞状态，等待客户端连接
			System.out.println("客户端连接成功！");
			//通过Socket获取输入流
			InputStream in=socket.getInputStream();
			//输入转换流
			InputStreamReader isr=new InputStreamReader(in,"UTF-8");
			//输入字符流
			BufferedReader br=new BufferedReader(isr);
			//读取数据
			/*String line=br.readLine();
			System.out.println(line);
			*/
			String line=null;
			while((line=br.readLine())!=null){
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
