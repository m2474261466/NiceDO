package SpringTests;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.Teacher;

public class TestConstruct {
             @Test
             public void tets(){
            	 ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext4.xml");
            	 System.out.println(act.getBean("teacher",Teacher.class));
             }
}
