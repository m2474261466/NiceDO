package day06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * �����ַ���������BufferedReader//�����������������У�һ������������������������Ǹ�
 * 
 * 
 * @author 24742
 *
 */
public class BufferedDemo {
           public static void main(String[] args) throws IOException {
			//�����ֽ���
        	 FileInputStream fis=new FileInputStream("pw3.txt");
        	//����ת����
        	 InputStreamReader fos=new InputStreamReader(fis,"UTF-8");
            //�����ַ���
        	BufferedReader rw=new BufferedReader(fos);
        	/*
        	 * BufferedReader�ṩ��String readline()����
        	 * ������ȡŵ�ɸ��ַ���ֱ����ȡ������λ�ã�Ȼ�󽫻���֮ǰ��ȡ���ַ���һ���ַ�����ʽ����
        	 * ֱ������null�����ʾ����ĩβ
        	 */
        	String line=null;
        	while((line=rw.readLine())!=null){
        		System.out.println(line);
        	}
        	rw.close();
		}
}
