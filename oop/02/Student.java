package day01;
/**
 * ѧ����,��"ѧ����"ģ��
 * @author Lenovo
 *
 */
public class Student {
	
	//����---��Ա����(����ȫ�ֱ���)
		int age;		//����
		String name;	//����
		char gender;	//�Ա�
		int num;		//ѧ��
	
		/*
		 * ���췽���Ǹ���Ա������ʼ����
		 */
	public Student(){//�޲ι��췽��
		age=20;
		name="����";
		gender='Ů';
		num=9527;
		System.out.println("����Student����޲ι��췽��");
	}
	
	//�вι��췽��
	public Student(int userAge,String userName,char userGender,int userNum){
		age=userAge;
		name=userName;
		gender=userGender;
		num=userNum;
		System.out.println("����Student����вι��췽��");
	}
	
	public void sleep(){//��Ϊ---����
		System.out.println("�ҽ�:"+name+",�ҵ�����:"+age+",�Ա�:"+gender+",ѧ��:"+num+",��������˯��,�벻Ҫ������...");
	}
	
	public void study(){
		System.out.println("�ҽ�:"+name+",�ҵ�����:"+age+",�Ա�:"+gender+",ѧ��:"+num+",��������ѧϰ,�벻Ҫ������...");
	}
}
