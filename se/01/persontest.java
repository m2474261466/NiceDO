package day01;

import java.util.Arrays;

public class persontest {
	public static void main(String[] args) {
		person person = new person("����",12,10000,false);//�����ַ�ռ�              
		person =    new person("����1",12,10000,false);
		person.sleep("����",12);
		//�̳�  ��extends��Ŀ�ģ���д����
		//��������һ�㶼Ҫ������
		//��ͨ�������Է������� ���췽������һ������һ���¶��� ���췽�����ñ���ʹ��new 
		System.out.println(person);
		System.out.println("-------------");
	    System.out.println(person);
		String str = new String("abc");
		System.out.println(str);
         str  ="def";	
         System.out.println(str);
         int[] a = new int[10];
         System.out.println(a[0]);
         int[] b = {1,2,3,4,6};
         //����ַ������
         //��̬ static  ����ֱ�ӵ���   ��̬������������������ ֻ��һ�� ������
         //�Ǿ�̬ �������  һ������һ�� ��˽�У�
         //��װ����������ķ���
         System.out.println(Arrays.toString(b));
        for(int i=0;i<b.length;i++)
        	System.out.println(b[i]);
	}
}
