package day06;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/*
 * ���ַ��������ļ�
 */
public class PrintWriterReaderDemo {
	public static void main(String[] args) throws IOException{
		//�ַ�������
		BufferedReader br=new BufferedReader (
				new InputStreamReader(
						new FileInputStream("D:/CloudMusic/Against the Current - Legends Never Die.mp3"),"UTF-8"));
		//�ַ������
		PrintWriter pd=new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:/CloudMusic/366152Against the Current - Legends Never Die.mp3",true),"UTF-8")),true);
		
		String line=null;
		while((line=br.readLine())!=null){
			pd.println(line);
		}
		System.out.println("������ϣ���");
		
	}
}
