package testPerson02;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test5 {
         @Test
         public void rs() throws SQLException{
        	 ApplicationContext ad=new ClassPathXmlApplicationContext("applicationContext7.xml");
        	 DataSource sd=ad.getBean("dataSource",BasicDataSource.class);
        	Connection ds=sd.getConnection();
        	 
         }
}
