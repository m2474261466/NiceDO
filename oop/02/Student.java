package day01;
/**
 * 学生类,即"学生类"模板
 * @author Lenovo
 *
 */
public class Student {
	
	//特征---成员变量(或者全局变量)
		int age;		//年龄
		String name;	//名字
		char gender;	//性别
		int num;		//学号
	
		/*
		 * 构造方法是给成员变量初始化的
		 */
	public Student(){//无参构造方法
		age=20;
		name="测试";
		gender='女';
		num=9527;
		System.out.println("我是Student类的无参构造方法");
	}
	
	//有参构造方法
	public Student(int userAge,String userName,char userGender,int userNum){
		age=userAge;
		name=userName;
		gender=userGender;
		num=userNum;
		System.out.println("我是Student类的有参构造方法");
	}
	
	public void sleep(){//行为---方法
		System.out.println("我叫:"+name+",我的年龄:"+age+",性别:"+gender+",学号:"+num+",本人正在睡觉,请不要打扰我...");
	}
	
	public void study(){
		System.out.println("我叫:"+name+",我的年龄:"+age+",性别:"+gender+",学号:"+num+",本人正在学习,请不要打扰我...");
	}
}
