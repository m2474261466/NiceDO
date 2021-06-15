package day06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 缓冲字符输入流：BufferedReader//缓冲流和输入流都有，一顶二，而输出流的这两个各是各
 * 
 * 
 * @author 24742
 *
 */
public class BufferedDemo {
           public static void main(String[] args) throws IOException {
			//输入字节流
        	 FileInputStream fis=new FileInputStream("pw3.txt");
        	//输入转换流
        	 InputStreamReader fos=new InputStreamReader(fis,"UTF-8");
            //输入字符流
        	BufferedReader rw=new BufferedReader(fos);
        	/*
        	 * BufferedReader提供了String readline()方法
        	 * 连续读取诺干个字符，直到读取到换行位置，然后将换行之前读取的字符以一个字符串形式返回
        	 * 直到读到null，则表示读到末尾
        	 */
        	String line=null;
        	while((line=rw.readLine())!=null){
        		System.out.println(line);
        	}
        	rw.close();
		}
}
