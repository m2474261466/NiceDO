package day01;

public class stringcommon {
	
	public static void main(String[] args) {
		// C ������ ���� Java�����Ƚ϶� ��Ƚ϶�
				String str = "hello world!!";
				System.out.println(str.charAt(3));
				System.out.println(str.indexOf("h", 3));
				System.out.println(str.indexOf("o"));
				// �������� ���򣺼���֪�� ���� ���ݿ� �� ���� ���� ���� �����ݽṹ �������� = Ŀ¼ ���ҷ���
				System.out.println(str.lastIndexOf("o"));
				// ASCII 65 97 a 98b 99c 100d 101 e
				// ��������
				String sub = str.substring(2, 5);// ֱ�Ӵӿ�ʼλ�ý�ȡ��ĩβ
				System.out.println("sub:" + sub);
				CharSequence charSequence = str.subSequence(2, 5);
				System.out.println("charSequence:" + charSequence);
				// String ʵ���� charSequence �ӿ�
				// ��̬ ��̬�� ��װ �̳� ��̬
				CharSequence ch = new String("abc");
				System.out.println(ch);
				System.out.println(sub);
				System.out.println(str.indexOf(101));//ASCLLΪ101���ַ���e��λ��Ϊ����
				// equals �Ƚ�ֵ��ȾͿ��� ��ַ������� new == ֵ��ȣ���ַҲҪ���
				String first = new String("abc");
				String second = new String("ABC");
				System.out.println("equals:" + (first.equals(second)));
				System.out.println("ignoreCase:" + first.equalsIgnoreCase(second));
				System.out.println("���Ե�:" + (first == second));
				// �ַ����и�������� ���ó������е�ֵ
				String third = "abc";
				String fourth = "abc";
				String fifth = "abc" + "def" + "ghi";// �����ٽ���ƴ�Ӳ���
				System.out.println("fifth" + fifth);
				System.out.println(third == fourth);
				System.out.println(third.equals(fourth));
				String sixth = "hello";
				String seventh = "java";
				// I concat you!!
				// �ַ����������ʾ��Ƕ�������в���
				System.out.println(sixth.concat(seventh));//concatƴ��
				System.out.println(seventh.replace('a', 'e'));
				System.out.println(sixth.toUpperCase());// ��Ϊ��д
				System.out.println(sixth.toLowerCase());// ��ΪСд
				int num = 5;
				num = 12;
				boolean flag = true;
				char[] chars = { 'a', 'b', 'c', 'd' };
				// ��һ����������ת��Ϊ�ַ�������
				// �Ǿ�̬���Ե��þ�̬ ���Ƽ� ��̬���ܵ��÷Ǿ�̬
				// jdk 1.5 int=Integer byte = Byte
				System.out.println(String.valueOf(12));
				System.out.println(String.valueOf(chars, 2, 1));
				// �Ƚ���
				// Comparable �ӿ��е�һ������ CompareTo �����Ƚ��ַ��� �Ⱥ�˳�� �ֵ���() A B
				// A-B С��0 ��A<B �� ����0 (A=B)������(A>B)
				System.out.println("g".compareTo("f"));
				// java se�� ÿ�ֻ������Ͷ���Ӧ��һ����װ����
				// JDK1.5 �� int a =12 Integer a =12
				// ���� װ�� ���� �������ͺͰ�װ���Ϳ��Ի���
				int a = 12; // max min C����
				Integer b = new Integer(12);// �༴�з���Ҳ������
				Integer c = 12;
				byte b1 = 9;
				Byte b2 = 9;
				char c2 ='c';
				Character c1 = new Character('d');
				Character c3='d';//���� װ�� 
				System.out.println("c1="+c1);
				System.out.println("c3="+c3);
				
				System.out.println(Byte.MIN_VALUE);
				System.out.println(Byte.MAX_VALUE);
				System.out.println(Integer.MAX_VALUE);
				System.out.println(Integer.MIN_VALUE);
		
		
	}
}
