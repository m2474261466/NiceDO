package day07;

import java.io.Serializable;

/**
 * 
 * Serializable�ӿڣ�
 * ObjectOutputStream�ڶ���������л�ʱ�и�Ҫ����Ҫ���л�����
 * �������������ʵ��Serializable�ӿ�
 * 
 * ʵ�ָýӿڲ���Ҫ��д�κη�����Ŀ��ʱ���򻯵�һ�ֱ�ʶ
 * 
 * @author 24742
 *
 */
public class Student  implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * serialVersionUID���ã����л�ʱΪ�˱��ְ汾�ļ����ԣ�
	 * ��˼���ڰ汾����ʱ�����л��Ա��ֶ����Ψһ��
	 * 
	 * �����������ַ�ʽ��
	 * һ��Ĭ�ϵ�1L,����:private static final long serialVersionUID = 1L;
	 *��һ��������һ��64λ�Ĺ�ϣ�ֶ�
	 *private static final long serialVersionUID = -1122262302143624875L;
	 */
	private String name;
	private int age;
	private char gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
      
}
