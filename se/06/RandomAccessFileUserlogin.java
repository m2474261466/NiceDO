package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import day01.string;

/**
 * �û���¼���ܣ������¼�ɹ���ʾ���û���������Ϣ
 * @author Thinkpad
 *
 */
public class RandomAccessFileUserlogin {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("demo5.txt","r");
		Scanner scanner=new Scanner(System.in);
		System.out.println("�˺����룺");
		String user_name=scanner.next();
		System.out.println("�������룺");
		String user_pwd=scanner.next();
		byte[] bs=new byte[32];
		boolean nameflag=false;
		boolean pwdflag=false;
		for(int i=0;i<raf.length()/100;i++){
			raf.seek(i*100);//����ָ��λ��
			System.out.println("ָ��λ�ã�"+raf.getFilePointer());
			raf.read(bs);//��ȡ����
			String name=new String(bs,"UTF-8").trim();
			if(name.equals(user_name)){
				System.out.println("�˺���ȷ��");
				nameflag=true;
				raf.read(bs);//��ȡ����
				String pwd=new String(bs,"UTF-8").trim();
				if(pwd.equals(user_pwd)){
					System.out.println("����������ȷ��");
					pwdflag=true;
					System.out.println("��¼�ɹ�����");
					raf.read(bs);//��ȡ�ǳ�
					String nick=new String(bs,"utf-8");
					int age=raf.readInt();
					System.out.println("����û���ϢΪ"+name+","+pwd+","+nick+","+age);
				}
				break;
			}
		}
		if(nameflag==false){
			System.out.println("�˺Ŵ���");
			return;
		}
		if(pwdflag==false){
			System.out.println("�������");
		}
	}
}
