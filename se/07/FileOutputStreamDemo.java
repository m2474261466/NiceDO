package day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * * java io
 * java�ṩ�˱�׼��IO����,����������;
 * IO�������ǿ��������ǵĳ��������������ݽ���,����������д����,��ȡ��������,д���ļ����ݵȵ�;
 * ��׼��IO���ݽ����ܰ��շ��򻮷�
 * ����:����絽�����еĹ���,����"��"�Ĺ���;
 * ���:�ӳ����������Ĺ���,����"д"�Ĺ���;
 * 
 * ѧϰIO���ص�:��������Ӳ���,ͨ��Ӧ��������,������Ҫ��ϸ߼�����ͼ���,��ɶ�д����;
 * 
 * ����Ϊ:�ڵ���(�ͼ���),������(�߼���)
 * 
 * �ڵ���:ʵ�����ӳ�������һ�˵Ĺܵ�,����������֮�䴫������,ע��:��дһ���ǽ����ڽڵ��������Ͻ��е�.
 * ������:���ܶ�������,������������������,�������Դ�ĳ�ֶ����ݵļӹ�����,���������������������Щ����
 * ���д���,�������Լ����Ƕ����ݵĴ������;
 * 
 * java.io.InputStream
 * �����ֽ��������ĸ���,��һ��������,�涨�������ֽ�������,����߱��Ķ�ȡ�ֽڵķ���;
 * 
 * java.io.OutputStream
 * �����ֽ�������ĸ���,��һ��������,�涨�������ֽ������,����߱���д���ֽڵķ���;
 * 
 * �ļ���:��һ�׵ͼ���,�����Ƕ�д�ļ�����;
 * 
 * �ļ�����RandomAccessFile�ĶԱ�:
 * 1: �۹�����һ��,����������д�ļ�����;
 * 2: RandomAccessFile�����ļ����ɶ�Ҳ��д,�����ļ�������,�ļ�������ֻ�������ļ�����,�ļ�������������ļ���д������;
 * 3: �����ص���˳���д����,��:��д�ǲ��ܻ��˵�,RandomAccessFile�������д����,��Ϊ����ָ��λ�ý��ж�д,���Կ���ͨ������
 *    ָ����ļ�����λ�������д;
 * 
 * 
 * ���ļ���д��һ���ַ���
 * 
 * �ļ������֧������ģʽ:
 * 1:����д����,��:��д�����ļ�������,��ԭ������ȫ��ɾ��,������ͨ��д����������Ϊ�ļ�����.
 * FileOutputStream(String path)
 * FileOutputStream(File file)
 * 2:׷�Ӳ���,���ļ���������ȫ������,�Ӹ��ļ�ĩβ׷������
 * FileOutputStream(String path,boolean append)
 * FileOutputStream(File file,boolean append)
 * @author 24742
 *
 */
public class FileOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		//��ʽһ
		/*File file=new File("fi.txt");
		//�����ļ������
		FileOutputStream fos=new FileOutputStream(file);
		System.out.println("���");*/
		//��ʽ��
		FileOutputStream fos=new FileOutputStream("fos.txt");
		//String str="����Ͻ��Ҹ�С�����������";
		String  str="����ȴ���";
		byte[] bs=str.getBytes("UTF-8");
		fos.write(bs);
		System.out.println("д����ϣ�");
		fos.close();
	}

}
