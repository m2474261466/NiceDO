package day09;

import java.io.BufferedWriter;
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
 * ��ѯ�Լ������ϵ�IP��ַ��cmd_>ipconfig
 * @author 24742
 *
 */
public class Client {
    public static void main(String[] args) {
	   try {
		Socket socket=new Socket("192.168.3.37",8080);
		System.out.println("�ͻ������ӳɹ���");
		
		/*
		 * ͨ��Socket��ȡ�ֽ��������Socket�ṩ�˷���getOutputStream()
		 * ����OutputStream
		 * ͨ�����ص��ֽ������д�������ݻᷢ�͸�Զ�˵ļ���������ڿͻ���
		 * ��߶���Զ�˼�������Ƿ����
		 */
		OutputStream out=socket.getOutputStream();
		//ת����
		OutputStreamWriter osw=new OutputStreamWriter(out,"UTF-8");	
		//�ַ�������
		BufferedWriter bw=new BufferedWriter(osw);
		//�ַ���
		PrintWriter pw=new PrintWriter(bw,true);
		Scanner scanner =new Scanner(System.in);
		while (true) {
			String message=scanner.next();
			pw.println(message);
			
		}
		//pw.println("��ã����ǿͻ��ˣ�������");
	       } catch (Exception e) {
		    e.printStackTrace();
	     } 
	}
}
