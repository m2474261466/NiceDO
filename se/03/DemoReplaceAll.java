package day02;
/**
 * replaceAll(String regex,String str);
 * String�ṩ�����ַ����滻������
 * replaceAll�����ַ�����ƥ��������ʽregex���ַ���ȫ���滻��str
 * replace:�滻��������
 * @author 24742
 *
 */

public class DemoReplaceAll {
	
	public static void main(String[] args) {
		//replace:�滻��������
		String str="1555�Ǻǵ�226�ĵ�555�ĵĻ�";
		
	   //���ַ���str�е�"226"�滻��"�Ǻǵ� "
		 //str=str.replace("226","�Ǻǵ�");
		 //System.out.println(str);
		
		//str=str.replaceAll("1555|226|555","�Ǻǵ�");//����Ҳ����
		str=str.replaceAll("\\d+","�Ǻǵ�");
		System.out.println(str);
		
		
		
		
	}

}
