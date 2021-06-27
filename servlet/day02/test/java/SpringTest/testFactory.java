package SpringTest;

import java.util.Date;
import java.util.Calendar;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testFactory {
            @SuppressWarnings("resource")
			@Test
            public void Factory(){
            	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext3.xml");
            	//获取spring容器中的bean对象
            /*这是静态的工厂模式
             * //Calendar s=ac.getBean("conn", Calendar.class);
            	//System.out.println(s);
             */            
            	//这是动态的工厂模式
            	Date s=(Date)ac.getBean("time");
            	//Date s=ac.getBean("time",Date.class);这是上面的变换形式，最好写下面这个
            	System.out.println(s);
            	
            	
            	}
}
