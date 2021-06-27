package SpringTest;

import java.sql.Statement;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class springtest02 {
      @Test
      public void ede(){
    	  ApplicationContext all=new ClassPathXmlApplicationContext("applicationContext3.xml");
    	  Statement t=all.getBean("bb",Statement.class);
    	  System.out.println(t);
      }
}
