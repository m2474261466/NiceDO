package day06;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * �������ӵķ�ʽʹ��PrintWriter
 * 
 * 
 * PrintWriter�Ĺ��췽���м����һ������Ϊ������ô��֧��һ�����صĹ��췽����
 * �����ٴ���һ��booleanֵ���͵Ĳ����������ֵΪture��������Զ���ˢ��
 * ���� ����ÿ��ʹ��println��������ʱд��һ���ַ�����ͻ��Զ�flush
 * @author 24742
 *
 */
public class WriterDemo02 {
        public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
			
        	//����һ
        	//�ֽ�����������ļ��������
        	//FileOutputStream fos=new FileOutputStream("pw2.txt",true);//�����һ������Ϊ������ô��֧��һ�����صĹ��췽���������ٴ���һ��booleanֵ���͵Ĳ����������ֵΪture��������Զ���ˢ�¹��� 
        	//ת�������
        	//OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
        	//�ַ����������
        	//BufferedWriter bw=new BufferedWriter(osw);
        	//�ַ������
        	//PrintWriter pw=new PrintWriter(bw);
        	/*pw.print("����");//��Ϊû�л��У�����û�취ǿ��ˢ��
        	pw.println("������������");
        	System.out.println("д�����");
        	pw.close();//�Դ�ǿ��ˢ��*/
        	//������
        	PrintWriter bs=new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("pw3.txt",true),"UTF-8")));
        	bs.println("����");
        	bs.println("lalala");
        	bs.close();
        	
        	
        	
		}
}
