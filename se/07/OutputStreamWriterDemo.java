package day06;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 * ת������
 * java.io.InterStreamReader
 * java.io.OutputStreamWriter
 * java�ṩ�������߼��ַ�������һ���ص����ֻ�������������ַ����ϣ�����ͨ��
 * �ͼ��������ֽ�������͵������ַ�������ֱ�Ӵ��������ֽ���ʹ�ã�����ת�������⣬
 * ���Ǳ�������ַ����������ǿ��������ֽ����ֿ��������ַ�����������ʵ�ʿ�����
 * ������ʹ�ø߼����ַ���ʱͨ�����ֽ�������ʱ��Ҫʹ��ת���������𵽳������µ�����.
 * �ṩ�Ĺ��췽�����£�
 * OutputStreamWriter��inputstream out��
 * OutputStreamWriter(inputstream out,string charset)
 * 
 * OutputStreamWriter��inputstream in��
 * OutputStreamWriter(inputstream in,string charset)
 * charest���ַ���
 */
public class OutputStreamWriterDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos=new FileOutputStream("osw.txt",true);//�ļ������
		OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");//ת����
		String str="��������";
		osw.write(str);
		System.out.println("д�����");
		osw.close();
	}
}
