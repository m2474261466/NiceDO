package day12;
/**
 * JDK1.5�汾֮���Ƴ���һ���µ�����
 * ��ǿforѭ����Ҳ����ѭ��
 * 
 * ��ѭ�������ܴ��洫ͳ��forѭ������ֻ�������������ϻ�������ʹ��
 * @author 24742
 *
 */
public class NewForDemo {
      public static void main(String[] args) {
		String[] arr={"one","two","three","four"};
		//��ͳ��forѭ��
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}

		//��ǿforѭ��
		/*
		 * ��ѭ���Ǳ������Ͽɣ����������ڱ���Դ����ʱ��Ϊʹ�ô�ͳ��forѭ������������߼���
		 */
		for(String s:arr){//����������  ���ƣ�������߼��ϣ����ͱ��뱣֤���ϻ��������е�Ԫ�ض���ͬһ���ͣ�ͬһ���ͷ��ظ����ͣ���ͬ���ͷ���Object
			System.out.println(s);
		}
	}
}
