package day06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * ��ת������ȡ�ַ�
 * @author 24742
 *
 */
public class InputStreamreaderDemo {
   public static void main(String[] args) throws IOException {
	FileInputStream fis=new FileInputStream("osw.txt");
	InputStreamReader bis=new InputStreamReader(fis,"UTF-8");
	/*int len=-1;//�ַ�������Ϊ-1
	while((len=bis.read())!=-1){//��len=bis.read()=-1ʱ��������ĩβ
		System.out.println((char)len);//���ֱ�����len�Ļ�ʱASCALL������ɵģ����Ǽ���char֮�����������ַ���
	}*/
	char[] c=new char[20];
	int n=bis.read(c);//ʵ�ʶ������ַ�����
	String str=new String(c,0,n);
	System.out.println(str);
	bis.close();
 }
}
