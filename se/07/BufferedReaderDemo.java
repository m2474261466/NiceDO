package day06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//缓冲字符输入流
public class BufferedReaderDemo {

	public static void main(String[] args) throws IOException {
		//字节输入流
		FileInputStream fis=new FileInputStream("pw3.txt");
		//输入转换流
		InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
		//字符输入流
		BufferedReader br=new BufferedReader(isr);
		/*
    	 * BufferedReader提供了String readline()方法
    	 * 连续读取诺干个字符，直到读取到换行位置，然后将换行之前读取的字符以
    	 * 一个字符串形式返回直到读到null，则表示读到末尾
    	 */
		String line=null;
		while((line=br.readLine())!=null){
			System.out.println(line);
		}
		br.close();
	}
}
