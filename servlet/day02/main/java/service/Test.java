package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.Person;
import dao.StudentImpl;
import dao.TeacherImpl;
import user.Student;


public class Test {
	      
           public static void main(String[] args) {
        	 //根据Spring提供的上下文创建spring容器
			ApplicationContext  acc=new ClassPathXmlApplicationContext("applicationContext2.xml");
			//通过Spring 来帮助我们创建对象   
			PersonService ps=(PersonService)acc.getBean("ps");
		    ps.getPer().sleep();
			
		}
}
