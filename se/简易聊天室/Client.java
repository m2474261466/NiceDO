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
 * �����ң��ͻ��ˣ�
 * ʵ����socket�������ӷ���˵Ĺ��̣�
 * ����1.����˵�ַ
 * ����2.����˿����Ķ˿�
 * ͨ������IP��ַ�ҵ��������������������ͨ���˿��ҵ������ڷ���˼�����ϵķ���Ӧ�ó���
 * 
 * localhost������IP��ַ
 * ��ѯ�Լ������ϵ�IP��ַ��cmd->ipconfig
 * @author 24742
 *
 */
public class Client {//����ip��192.168.3.37
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
				System.out.println("�ͻ������ӳɹ���");
				
				/*
				 * ͨ��Socket��ȡ�ֽ��������Socket�ṩ�˷���getOutputStream()
				 * ����OutputStream
				 * ͨ�����ص��ֽ������д�������ݻᷢ�͸�Զ�˵ļ���������ڿͻ���
				 * ��߶���Զ�˼�������Ƿ����
				 */
				//���̸߳�����շ��������
				ServerHandler server=new ServerHandler(socket);
				Thread t=new Thread(server);
				t.start();
				
				OutputStream out=socket.getOutputStream();
				//ת����
				OutputStreamWriter osw=new OutputStreamWriter(out,"UTF-8");	
				//�ַ�������
				BufferedWriter bw=new BufferedWriter(osw);
				//�ַ���
				PrintWriter pw=new PrintWriter(bw,true);
				Scanner scanner =new Scanner(System.in);
				System.out.println("���Է���Ϣ��ѽ");
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
		//��ȡ������
		try {
			InputStream in= socket.getInputStream();
			BufferedReader br=new  BufferedReader((new InputStreamReader(in,"utf-8")));
			String message=null;
			while((message=br.readLine())!=null){
				System.out.println("�����˵��"+message);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}