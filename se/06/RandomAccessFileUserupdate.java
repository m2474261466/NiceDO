package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

import day01.string;

/*
 * �޸��û��������룬ǰ���ǵ�½�ɹ��ſ����޸�
 */
public class RandomAccessFileUserupdate {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("demo5.txt","rw");
		Scanner scanner=new Scanner(System.in);
		System.out.println("�����û�����");
		String user_name=scanner.next();
		System.out.println("��������");
		String user_pwd=scanner.next();
		byte[] bs=new byte[32];
		boolean nameflag=false;
		boolean pwdflag=false;
		for(int i=0;i<raf.length()/100;i++){
			raf.seek(i*100);
			System.out.println("ָ��λ�ã�"+raf.getFilePointer());
			raf.read(bs);
			String name=new String(bs,"UTF-8").trim();
			if(name.equals(user_name)){
				System.out.println("�˺�������ȷ��");
				nameflag=true;
				raf.read(bs);
				String pwd=new String(bs,"UTF-8").trim();
				if(pwd.equals(user_pwd)){
					System.out.println("����������ȷ��");
					pwdflag=true;
					System.out.println("�޸����룺");
					String str=scanner.next();
					raf.seek(i*100+32);//����ָ��λ�� ����(raf.getFilePointer()-32)
					byte[] pdd=str.getBytes("UTF-8");
					pdd=Arrays.copyOf(pdd,32);//����
					raf.write(pdd);
					System.out.println("�����޸ĳɹ���");
					
				}
				break;
			}
		}
		if(nameflag==false){
			System.out.println("�˺Ŵ��󣡣�");
			return;
		}
		
		if(pwdflag==false){
			System.out.println("������󣡣�");
		}
	}
}
