package testPerson02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.Person;
import user.Person02;

public class TestSetDI {
	/*@Test
           public void dw(){
        	   ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext5.xml");
        	   Person02 ss=ac.getBean("person",Person02.class);
        	   System.out.println(ss);
        	   System.out.println(ss.getAddress().getCity());
        	   System.out.println(ss.getAddress().getArea());
        	  
           }*/
	     @Test
	     public void das(){
	    	 ApplicationContext acx=new ClassPathXmlApplicationContext("applicationContext6.xml");
	    	      Person p=acx.getBean("p",Person.class);
	    	      System.out.println(p);
	     }
}
