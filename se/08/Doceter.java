package day07;

import java.io.Serializable;

/*
 * transient���ԣ�
 * �Ѳ���Ҫ���л������Ժ��Ե����������Դﵽ�����ļ��ġ�����Ŀ�ġ�
 * 
 */
public class Doceter implements Serializable{
	private String name;
	private int age;
	private transient String nick;
	
	
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
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}

	public String toString() {
		return "Doceter [name=" + name + ", age=" + age + "]";
	}
	
	
}
