package day06;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * ת������
 * java.io.InputStreamReader
 * java.io.OutStreamWriter
 * java�ṩ�������߼��ַ�������һ���ص����ֻ�������������ַ����ϣ�����ͨ���ͼ���
 * �����ֽ�������͵����ַ�������ֱ�Ӵ����ֽ���������ת�������⣬���Ǳ�������ַ�����
 * �����ǿ��������ַ����ֿ��������ַ�����������ʵ�ʿ����е�����ʹ�ø߼����ַ���ʱ��
 * ͨ�����ֽ�������ʱ��Ҫʹ��ת�����������ˡ��������¡�������
 * �ṩ�Ĺ��췽�����£�
 * OutputStreamWriter(OutputStream out)
 * OutputStreamWriter(OutputStream out,String charset)
 * 
 * 
 * OutputStreamWriter(InputStream in)
 * OutputStreamWriter(InputStream in,String charset)
 * @author 24742
 *charset:�ַ���
 */
public class OutputStreamWriteDemo {
  public static void main(String[] args) throws IOException {
	//����ļ���
	  FileOutputStream fos=new FileOutputStream("osw.txt",true);//�������true�ſ���׷�ӣ��������Ǹ���
	  //ת����
	 OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
	 String str="���";
	 osw.write(str);//ͨ��ת����ֱ��д���ı��������䱾�ʻ���ͨ���ײ���ֽ���д��ģ�ֻ��ת����������
	 System.out.println("д�����");
	 osw.close();
   }
}
