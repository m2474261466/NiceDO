package day06;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 2:׷�Ӳ���,���ļ���������ȫ������,�Ӹ��ļ�ĩβ׷������
 * FileOutputStream(String path,boolean append)
 * FileOutputStream(File file,boolean append)
 * appendĬ��Ϊfalse��������Ϊtrue�����ļ�����β��׷��
 * @author 24742
 *
 */
public class FileOutputStreamDemo02 {
      public static void main(String[] args) throws IOException {
		FileOutputStream fos=new FileOutputStream("fos.txt",true);
		//String str="����Ͻ��Ҹ�С�����������";
		String  str="����Ҳ���Ҹ����ӽ����";
		byte[] bs=str.getBytes("UTF-8");
		fos.write(bs);
		System.out.println("д����ϣ�");
		fos.close();
	}
}
