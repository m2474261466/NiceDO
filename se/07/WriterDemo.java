package day06;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * �ַ���
 * java�������ն�д��λ����Ϊ�ֽ������ַ���
 * inputStream��OutputStream�������ֽ����ĸ���
 * �ַ���ֻ�Ƿ������Ƕ�д�ַ����ײ㱾�ʻ��Ƕ�д�ֽڣ�ֻ���ֽ����ַ���ת��
 * ����������ת���������
 * PrintWriter:�ַ���������ṩ�˹��췽�����£�
 * PrintWriter(String path)
 * PrintWriter(Filefile)
 * PrintWriter(Writer writer,Boolean,autoflush)
 * PrintWriter(String path,String charset)
 * charset:�����ʽ
 * writer��ת����
 * autoflush:�Զ���ˢ��
 * 
 * PrintWriter�Ĺ��췽���м����һ������Ϊ������ô��֧��һ�����صĹ��췽����
 * �����ٴ���һ��booleanֵ���͵Ĳ����������ֵΪture��������Զ���ˢ��
 * ���� ����ÿ��ʹ��println��������ʱд��һ���ַ�����ͻ��Զ�flush
 * @author 24742
 *
 */
public class WriterDemo {
   public static void main(String[] args) throws FileNotFoundException {
	  //�ַ������
	   PrintWriter pw=new PrintWriter("pw.txt");
	   pw.print("���Ǻܶ౶����");
	   System.out.println("д�����");
	 //pw.flush();//ǿ��ˢ��
	 pw.close();//�Դ�ǿ��ˢ��
     }
}
