package day02;

public class DemoString {
	public static void main(String[] args) {
		     String s="abc";//������һ������
		     String s2=s;
		     String s3="bc";		     
		     String s4="a"+s3;
		     String s5="abc";
		     System.out.println(s==s2);//true
		     System.out.println(s==s4);//false
		     System.out.println(s==s5);//true
		     //���Ա�����
		     String str=new String("ehf");
		     //�����ϴ����˼�������2������  newString������һ������
		     //��enh����һ���ַ��������ڳ�����û�С�ehf����������Ҫ����һ����efh������
		     //��˴�������������ŵ���������С�ehf���������ó������еġ�efh��������ôString str=new String("ehf ");�򴴽�һ������
		
		
		
		
		
		
	}

}
