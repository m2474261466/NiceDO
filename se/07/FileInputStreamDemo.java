package day06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * �ļ�������
 * FileInputStream(String path)
 * FileInputStream(File file)
 * @author 24742
 *
 */
public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("fos.txt");
		byte[] b=new byte[100];
		int len=fis.read(b);
		String str=new String(b,0,len,"UTF-8");
		System.out.println(str);
		fis.close();
	}
}
