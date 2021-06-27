package user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
            public static void main(String[] args) {
				//根据Spring提供的上下文创建spring容器
            	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
			    //通过Spring 来帮助我们创建对象   
            	Person sc=(Person)ac.getBean("ds");
            	System.out.println(sc.getStudent().getName());
            	//Student st=ac.getBean("stu",Student.class);
            	//System.out.println(st);
            }
}
