package day04;

import java.io.File;
import java.io.IOException;

/**
 * File��ÿһ��ʵ��ʱ��ʾӲ���ϵ�һ���ļ�����Ŀ¼��
 * ʹ��File��
 * 1.�������ʾ���ļ�����Ŀ¼��������Ϣ����С�����ֵȣ�
 * 2.�����ļ�����Ŀ¼��������ɾ����
 * 3.����һ��Ŀ¼�����е�����ǲ��ܷ����ļ�����
 * 
 * �ڱ�ʾ�ļ�����Ŀ¼��ָ��·��������Ҫʹ�þ���·������Ϊ��ͬ�Ĳ���ϵͳ��ʽ��һ��
 * �����·��ʱ��õģ��������·���������Ҫ���������Ǹ����л������У�Ҳ�������л���
 * ���������·��
 * 
 * ��eclipse�����г���ʱ������ǰĿ¼��ָ��������������Ŀ�á�./����ʾ
 * @author Thinkpad
 *
 */
public class CreateFileDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * �ڵ�ǰĿ¼�ļ����½�һ���ļ�demo.txt��
		 * file�ṩcreateNewFile���������������ļ�
		 */
		File file=new File("./demo.txt");
		/*
		 * file�ṩ��boolean exites�����÷��������жϵ�ǰFile��ʾ�ļ�����Ŀ¼�Ƿ����
		 * ���ڷ���true
		 */
		if(!file.exists()){
			file.createNewFile();
			System.out.println("�����ɹ���");
		}else{
			System.out.println("���ļ��Ѿ�������");
		}
	}
}
