package day01;

import java.nio.charset.Charset;

public class string {
	
	public static void main(String[] args) {
		//�ַ���һ���������޷��ı�����
		//����һ��
		String str=new String("der");
		System.out.println(str);
		
		//��������
		str="poi";
		System.out.println(str);
		
		//��������
		char[] a={'a','b','c','s','s'};
		str=new String(a);
		System.out.println(str);
		
		str=new String(a,1,3);
		System.out.println(str);
		
		Charset charset=Charset.forName("UTF-8");
		byte bytes[]={97,98,99};
		str=new String(bytes,charset);
		System.out.println("   "+str);
		
		
	}
}
