package day06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * ���ַ��������ļ�
 * 
 */
public class BufferedReader_copyFile {
   public static void main(String[] args) throws IOException, IOException {
	//�ַ�������
	  BufferedReader sd=new BufferedReader(
			  new InputStreamReader(
					  new FileInputStream("C:/Users/24742/Desktop/ss.txt"),"UTF-8"));
	  //�ļ������
	PrintWriter ss=new PrintWriter(
			new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream("C:/Users/24742/Desktop/sd.txt"),"UTF-8")));
	
	String line=null;
	while((line=sd.readLine())!=null){
		ss.println(line);
   
	
	 }
	System.out.println("�������");
	sd.close();
	ss.close();
    }
   }

