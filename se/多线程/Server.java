package day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

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
      public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(8080);
			System.out.println("�ȴ��ͻ�������...........");
			Socket socket=server.accept();//����״̬���ȴ��ͻ�������
			System.out.println("�ͻ������ӳɹ���");
			//ͨ��Socket��ȡ������
			InputStream in=socket.getInputStream();
			//����ת����
			InputStreamReader isr=new InputStreamReader(in,"UTF-8");
			//�����ַ���
			BufferedReader br=new BufferedReader(isr);
			//��ȡ����
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
