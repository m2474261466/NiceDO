package day05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/*
 * ����ϵͳĬ���ַ���ת�������Ƽ�����Ϊ����ƽ̨���죩
 * byte[] getBytes(String scan) scan:�ַ���
 * ���ո������ַ���ת�����ַ��������ֲ����ִ�Сд��
 * GBK:���ʱ��룬����ռ2���ֽ�
 * UTF-8:Ҳ������룬����ռ3���ֽ�
 * ISO8859-1��ŷ���ַ�������֧�����ġ�
 */
public class RandomAccessFileWriteDemo3 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("demo2.txt", "rw");
		String str="��ã�������";
		byte[] b=str.getBytes("UTF-8");//���ַ���ת��Ϊ�ֽ�
		System.out.println(b.length);
		raf.write(b);
		System.out.println("������ϣ���");
		raf.close();
	}
}
