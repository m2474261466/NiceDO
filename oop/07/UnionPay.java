package day07;
/**
 * ��д�������нӿ�CCB�̳������ӿڣ���ʵ�ָýӿ�
 * 
 * ��д�������нӿ�CCB���������нӿڣ�
 * ���������й��������з��еĿ�Ƭ���ܣ�
 * �����������ӿڵĹ�������ϣ�
 * ������֧��ȼ���ѵĹ��ܡ�
 *
 * ����:UnionPay(����):������������ͳһָ���Ĺ���(��׼)
 * �������������¹���:
 * 1.��ѯ����
 * 2.��ѯ���
 * 3.ȡǮ
 * @author Lenovo
 *
 */
public interface UnionPay {
	//��ѯ����
	public boolean checkPwd(String input);
	
	//��ѯ���
	public double getBalance();
	
	//ȡǮ
	public boolean drawMoney(double number);
}
