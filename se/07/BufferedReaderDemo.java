package day06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//�����ַ�������
public class BufferedReaderDemo {

	public static void main(String[] args) throws IOException {
		//�ֽ�������
		FileInputStream fis=new FileInputStream("pw3.txt");
		//����ת����
		InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
		//�ַ�������
		BufferedReader br=new BufferedReader(isr);
		/*
    	 * BufferedReader�ṩ��String readline()����
    	 * ������ȡŵ�ɸ��ַ���ֱ����ȡ������λ�ã�Ȼ�󽫻���֮ǰ��ȡ���ַ���
    	 * һ���ַ�����ʽ����ֱ������null�����ʾ����ĩβ
    	 */
		String line=null;
		while((line=br.readLine())!=null){
			System.out.println(line);
		}
		br.close();
	}
}
