package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.Person;
import dao.StudentImpl;
import dao.TeacherImpl;
import user.Student;


public class Test {
	      
           public static void main(String[] args) {
        	 //����Spring�ṩ�������Ĵ���spring����
			ApplicationContext  acc=new ClassPathXmlApplicationContext("applicationContext2.xml");
			//ͨ��Spring ���������Ǵ�������   
			PersonService ps=(PersonService)acc.getBean("ps");
		    ps.getPer().sleep();
			
		}
}
