package day06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *�ֽڻ�������
 *�ֽڻ������Ļ�����������
 *������ʵ���ϱ��ʾ��ǽ��п���д��������������ʹ�û����������κζ�д��ʽ��
 *�����ն��ᱻ������ת��Ϊ���д��ʽͨ���ļ�������ʵ�ʵĲ������������ڲ�ά����һ��8k��8192byte��
 *���ֽ������飬���ڿ��д����
 *
 *
 *BufferedInputStream:���뻺����
 *BufferedOutputStream:���������
 *
 *�������ṩһ��ǿ��д�����ݵķ�����flush()
 * @author 24742
 *
 */
public class Buffer_flushDemo {
	public static void main(String[] args) throws IOException{
		//�����
		FileOutputStream fos=new FileOutputStream("bos.txt");
		//�ֽڻ�����
		//���ֽ������fos���뵽������
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		String str="�������Ҹ���ֽ����";
		byte[] bs=str.getBytes("UTF-8");
		bos.write(bs);
		bos.flush();//ǿ��д��
		System.out.println("д����ϣ�");
		bos.close();//�ڹرշ������Դ�ǿ��д������flush()
	}

}
