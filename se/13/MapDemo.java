package day14;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map�ӿ�
 * Map��֮Ϊ���ұ������ݽṹ���ֵ�������һ�����������еı��
 * ����Ϊkey������Ϊvalue
 * Map���Ǹ���key�������Ӧ��value���洢Ԫ��ҲҪ��key-value�ɶԴ���
 * 
 * 
 * ������ʵ���ࣺjava.util.HashMap ��ϣ��
 * HashMap�ǻ���ɢ���㷨ʵ�ֵ�Map��Ҳ�ǵ������������Ĳ�ѯ�ṹ
 * @author 24742
 *
 */
public class MapDemo {
         public static void main(String[] args) {
			Map<String,Integer> map=new HashMap<String,Integer>();
			//��map�д洢Ԫ��
			/*
			 * map�ṩ�˴洢Ԫ�صķ���put(key,value)
			 * Map��һ��Ҫ��key�������ظ���key��equals�Ƚ϶���������
			 *��ʹ��Map���е�key����value�����滻valueֵ����ôput����
			 *���صľ��Ǳ��滻��value����û���滻����null�������ﷵ������
			 *�м�Ӧ���ǰ�װ����Integer������ᷢ����ָ���쳣
			 */
			Integer n=map.put("����", 95);
		    n=map.put("����",99);
			System.out.println(n);
			System.out.println(map);
			map.put("��ѧ", 100);
			map.put("Ӣ��", 95);
			map.put("����", 99);
			//Map���ϵĳ���
			System.out.println(map.size());
			System.out.println(map);
			/*
			 * ���ݸ�����key��ȡ��Ӧ��value����������key�������򷵻�null��
			 * Map�ṩ�˻�ȡvalueֵ�ķ���get(Key k)
			 */
			//�鿴����ɼ�
			Integer w=map.get("����");
			System.out.println(w);
			/*
			 * ɾ����ǰMap�и�����key����Ӧ�������ֵ�ԣ�����ֵΪkey����Ӧ��valueֵ
			 * ���������Key�����ڣ��򷵻�null
			 * Map�ṩ��ɾ��Ԫ�صķ���remove��Key k��
			 * 
			 */
			Integer y=map.remove("Ӣ��");
			System.out.println("����"+map.size()+"ɾ�����Map����"+map);
			System.out.println(y);
			
			
			
			
	}
}
