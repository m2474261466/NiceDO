package user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
            public static void main(String[] args) {
				//����Spring�ṩ�������Ĵ���spring����
            	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
			    //ͨ��Spring ���������Ǵ�������   
            	Person sc=(Person)ac.getBean("ds");
            	System.out.println(sc.getStudent().getName());
            	//Student st=ac.getBean("stu",Student.class);
            	//System.out.println(st);
            }
}
