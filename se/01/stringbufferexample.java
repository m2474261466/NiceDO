package day01;

public class stringbufferexample {
	//Ϊ�˽�� String ����ƴ��Ч�ʱȽϵ����� StringBuffer/StringBuilder 
	//���ڻ���������
		//StringBuffer /StringBuilder �÷���࣬���ǻ��ڻ���������
		//StringBuffer �̰߳�ȫ  �Ŷӷ���  100 99 98 ��ȫ  Ч�ʵ�
		//StringBuilder �̲߳���ȫ 100 Ч�ʸ� ����ȫ 
		//Thread/���� �����Ը�Ƶ�㣩   Java thread  (����ϵͳ CPU)
		//���������е�Ӳ�� ���򶼲��ܲ��� ͨ������ϵͳ
		public static void main(String[] args) {
			//16λ
			// int[] a ={1,2,3,4} �� 2��3֮�����100 
			//���� a[0] a[1]
			//JVM  JDK  java����������JVM��java�������
			// �ڲ���ϵͳ�� window/linux /unix װJDK -> eclipse
			//һ�α��뵽������
			//�����Էǳ���
			
			StringBuffer sb = new StringBuffer("a");
			StringBuilder sbi = new StringBuilder();
			sbi.append("ddddd");
			System.out.println(sbi);
			System.out.println(sb.length());//���������ַ����ĳ���
			System.out.println(sb.capacity());//�������ĳ���
	        sb.append(true);
	        sb.append(56.7);
	        sb.append("abc");
	        sb.append("ghi");
	        System.out.println(sb);
	        sb = new StringBuffer("first");
	        sb.insert(2, "bigData");
	        System.out.println(sb);
	        char [] chars = {'i','n','u','i'};
	        sb.insert(3,chars,2,2);//��sb������λ�ò���char����ĵڶ���Ԫ�ؿ�ʼ��2��Ԫ�أ�
	        System.out.println(sb);
	        sb.setCharAt(0, 'P');
	        System.out.println(sb);
		}
}
