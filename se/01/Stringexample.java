package day01;

import java.nio.charset.Charset;

public class Stringexample {
	public static void main(String[] args) {
		// һ���඼��д��toString
				String str = new String("abc");
				System.out.println(str.toString());
				// һ������ �޷��ı������
				// ���� stack ջ //���� heap ��
				String str1 = new String("def");
				// �ַ�����0��ʼ Ϊʲô���㿪ʼ��
				str1 = "ghi���";// ��� �������
				char a[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
				str1 = new String(a);
				System.out.println(str1);
				str1 = new String(a, 1, 3);
				System.out.println(str1);
				// byte short int long c
				// *.java ->*.class
				//��̵�ʱ��1.�﷨���� �������﷨���� IDE �����ǽ�� 2. �߼������ص㣩 �ϵ����
				//ASCII
				//����һ������ʱ����Ҫֱ��new ��Ҫ���ĵ���API����һ��Դ��
				//javaweb
				//����ľ��� �ײ�
				Charset charset = Charset.forName("UTF-8");
				byte bytes[] = { 97, 98, 99 };
				str1 = new String(bytes,charset);
				System.out.println("byte:"+str1);
				//final char
				String str4 = "dddff";
				System.out.println(str4);
				String str3 = "abc"+"def"+"hhh";//3����ƴ�� ����´�
				System.out.println(str3);
				StringBuffer sb = new StringBuffer("def");
				sb.append("ddd");//������ͬһ������
				String str2 = new String(new StringBuffer("dd"));
				System.out.println(str2+"abc"+12);
	}
}
