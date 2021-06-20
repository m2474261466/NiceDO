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
 * �����ң�����ˣ�
 * �����ڷ����ServerSocket����������Ҫ������:
 * 1.��ϵͳ���������ķ������˿ڣ��ͻ��˾���ͨ������˿������˽�������
 * 2.��������˶˿ڣ��ȴ��ͻ������ӣ�һ��һ���ͻ���ͨ��Socket�����˽������ӣ�
 * ��ôServerSocket�ᴴ��һ��Socket��ÿͻ���ͨѶ
 * 3.ע��ö˿ںŲ��ܺ���������˿ںų�ͻ��������׳��˿ںű�ռ���쳣
 * @author 24742
 *
 *
 *
 *ServerSocket�ṩ�ķ�����
 *accept()�÷�����һ���������������ú󼴵ȴ��ͻ��˵����ӣ�һ��һ���ͻ���ͨ���˿����ӣ�
 *��ôaccept�����᷵��һ��Socketʵ����ͨ�����Socketʵ������������ӵĿͻ��˽�����
 */
public class Server { 
	private ServerSocket server;
	private Socket socket;
	private ExecutorService pool;
	//�洢ÿһ���ͻ������ӳɹ�֮������ȡ�������(���ݹ���)
	private PrintWriter[] outAll=new PrintWriter[0];
	public  Server(){
		 try {
			this.server=new ServerSocket(8080);
			//�����̳߳�
			this.pool=Executors.newFixedThreadPool(2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//����ҵ��
	private void start(){
		try {
			while(true){
				System.out.println("�ȴ��ͻ�������...........");
				this.socket=server.accept();//����״̬���ȴ��ͻ�������
				System.out.println("�ͻ������ӳɹ���");
				ClientHandler clinet=new ClientHandler(socket);
				/*Thread t=new Thread(clinet);
				t.start();*/
				pool.execute(clinet);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//���̸߳���ÿ���ͻ��˵����������
class ClientHandler implements Runnable{//�ڲ���
	private Socket socket;
	private InetAddress adress;//��ȡԶ�̶˿ڵ�ַ
	private int port;//��ȡԶ�̶˿ں�
	public ClientHandler(Socket socket){
		this.socket=socket;
		this.adress=socket.getInetAddress();
		this.port=socket.getPort();
	}
	public void run(){
		PrintWriter pw=null;
		try{
			System.out.println(adress+","+port+"������");
			//��ȡ�����
			OutputStream out=socket.getOutputStream();
		    pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(out,"utf-8")),true);
			
			synchronized (this) {
				//��outAll��������
				outAll=Arrays.copyOf(outAll, outAll.length+1);
				//��pw�����outAll�����е����һ��Ԫ��
				outAll[outAll.length-1]=pw;
				//ͳ����������
				System.out.println("��������"+outAll.length);
			}
			
			
			
			//ͨ��Socket��ȡ������
			InputStream in=socket.getInputStream();
			//����ת����
			InputStreamReader isr=new InputStreamReader(in,"UTF-8");
			//�����ַ���
			BufferedReader br=new BufferedReader(isr);
			
			//��ȡ����
			/*
			 * �ͻ����ڶϿ�����ʱ����ͬ��ϵͳ���в�ͬ�ķ�Ӧ��
			 * Linuxϵͳ�Ŀͻ��Ͽ���br.readLine�᷵��null
			 * windowsϵͳ�Ŀͻ��˶Ͽ���br.readLine�ᱨjava.net.SocketException�쳣
			 * 
			 */
			String line=null;
			while((line=br.readLine())!=null){
				System.out.println(adress+":"+port+":"+line);//������Ϣ
				synchronized (this) {
					//�������пͻ��˵������
					for(int i=0;i<outAll.length;i++){
						PrintWriter	 p=outAll[i];
						//��ÿһ���ͻ��˷�������
						p.println(line);
						}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//����ͻ��˶Ͽ���Ĳ��������ͻ��˵�������ӹ���������ɾ��
			synchronized (this) {
				for(int i=0;i<outAll.length;i++){
					if(outAll[i]==pw){
						outAll[i]=outAll[outAll.length-1];
						outAll=Arrays.copyOf(outAll, outAll.length-1);
			        }
			
				}
			}
			System.out.println(adress+","+port+"������");
			System.out.println("��������"+outAll.length);
			
			
			try {
				//�ͻ��˶Ͽ����Ӻ�,����˹رոÿͻ���Socket,����һ�������ͷ���Դ
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
