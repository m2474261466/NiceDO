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
            	//��ȡspring�����е�bean����
            /*���Ǿ�̬�Ĺ���ģʽ
             * //Calendar s=ac.getBean("conn", Calendar.class);
            	//System.out.println(s);
             */            
            	//���Ƕ�̬�Ĺ���ģʽ
            	Date s=(Date)ac.getBean("time");
            	//Date s=ac.getBean("time",Date.class);��������ı任��ʽ�����д�������
            	System.out.println(s);
            	
            	
            	}
}
