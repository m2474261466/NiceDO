package day06;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/*
 * �������ӵķ�ʽʹ��PrintWriter
 * 
 *  printWriter�Ĺ��췽��������һ������Ϊ������ô��֧��һ�����صĹ��췽����
 * �����ٴ���һ��booleanֵ���͵Ĳ���������ֵΪtrue��������Զ�ˢ�¹���
 * ����ÿ��ʹ��println��������ʱд��һ���ַ�������Զ�flush
 */
public class WriterDemo2 {
	public static void main(String[] args) throws IOException {
		//�ֽ���������ļ��������
		FileOutputStream fos=new FileOutputStream("pw2.txt",true);
		//ת�������
		OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
		//�ַ����������
		BufferedWriter bw=new BufferedWriter(osw);
		//�ַ������
		PrintWriter pw=new PrintWriter(bw,true);
		pw.println("������");
		pw.println("��ǿ");
		System.out.println("д�����");
		pw.close();
		
		
		
		//�淶��д
		PrintWriter pd=new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("pw3.txt",true),"UTF-8")),true);
		pd.println("������");
		pd.close();
	}
}
