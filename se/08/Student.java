package day07;

import java.io.Serializable;

/**
 * 
 * Serializable接口：
 * ObjectOutputStream在对象进行序列化时有个要求需要序列化对象
 * 所属的类必须是实现Serializable接口
 * 
 * 实现该接口不需要重写任何方法，目的时可序化的一种标识
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
	 * serialVersionUID作用：序列化时为了保持版本的兼容性，
	 * 意思是在版本升级时反序列化仍保持对象的唯一性
	 * 
	 * 它由以下两种方式：
	 * 一个默认的1L,比如:private static final long serialVersionUID = 1L;
	 *另一个是来自一个64位的哈希字段
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
