package day04;
/**
 * ��̬����:static
 * ��̬����:static
 * final:���ܸı�(����) ������д(����) ���ܼ̳�(��)
 * 
 * ����:static final(�ص� )
 * 
 * ��ʾ��̬��:
 * 	�﷨:static{}(�ص�)
 * 	1.��static����
 *  2.������,���౻�����ڼ��Զ�ִ�е�,ֻ������һ��,���Ծ�̬��ִֻ��һ��,
 *    ��ʵ��������Ҫִ�еĿ�
 *  3.��ʱ��:����/��ʼ����̬��Դ(ͼƬ,��Ƶ,��Ƶ��),���ж����õ�����
 * @author ����
 *
 */
public class DemoStatic {
	
	public DemoStatic(){
		System.out.println("���췽��");
	}
	
	static{//��̬��
		System.out.println("��̬��");
	}
	
	public static void main(String[] args) {
		DemoStatic d=new DemoStatic();
		DemoStatic d2=new DemoStatic();
		DemoStatic d3=new DemoStatic();
	}
	
}
