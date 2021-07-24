package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 数据库的连接管理 
 * DBCP：DataBase  Connection Pool 数据库连接池是一个java连接池项目，DBCP通过
 * 连接池预先和数据库建立一个连接放在内存当中  （也就是连接池），应用程序需要建立数据库连接时
 * 直接从连接池当中申请一个连接使用，使用完后连接池回收该连接（归还资源Connection）
 * 从而达到了连接的复用，减少了资源的消耗   
 * 
 * 连接池的管理Connection这样可以重复使用，有了连接池，我们就不用自己来创建Connection,而是通过连接池
 * 来获取Connection对象，当使用完Connection调用连接池当中的close()方法来进行归还资源
 * 
 * 注意：在这里连接池的close()方法  起到的时把Connection 放到连接池的资源  归还的作用 
 * 而并不是关闭Connection资源 ，这样连接池就可以再次的 使用连接池对象了   
 * @author dell
 * 
 * PreparedStatement 提前编译好sql      大数量的sql语句  
 * Statement   直接执行sql语句      次数少的直接执行的   只执行一次的，少了一个提前编译好的环节     
 *
 */
public class DButil {
	//数据库连接池对象  BasicDataSource  
	private static BasicDataSource ds;
	
	//初始化连接池 
	//静态代码块  随着类的加载
	static{
		
		try {
			//   取读取我们配置文件当中的内容 
			//  Properties 类继承了HashTable   
			Properties p=new Properties();
			//  提供了  load方法   参数是我们读取的  字节流（文件地址）；
			//p.load(new FileInputStream("src/db.properties"));
			p.load(DButil.class.getClassLoader().getResourceAsStream("db.properties"));
			//获取Mysql  驱动   getProperty("")   里面的参数字符串是文件当中写的 
			String driver=p.getProperty("drivername");
			//获取连接地址
			String url=p.getProperty("url");
			//获取数据库账号
			String name=p.getProperty("name");
			// 获取数据库的密码 
			String password=p.getProperty("password");
			//获取最大连接数量  maxActive  
			int maxActive=Integer.parseInt(p.getProperty("maxActive"));
			//获取最大的等待时间   字符串转为Int 类型  maxWait 
			int maxWait=Integer.parseInt(p.getProperty("maxWait"));
			System.out.println("数据库初始化.....");
			
			
			//创建数据库的连接池   BasicDataSource   提供了  setUrl  setUsername   setPassword
			ds=new BasicDataSource();
			//Class.forName  设置mysql驱动
			ds.setDriverClassName(driver);
			//DriverManager.getConnection(url,name,password) 设置连接数据  地址，名字 密码
			ds.setUrl(url);
			ds.setUsername(name);
			ds.setPassword(password);
			//设置最大的连接数量
			ds.setMaxActive(maxActive);
			//ds.setMaxActive(maxActive);
			// 设置最大的等待时间
			ds.setMaxWait(maxWait);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 获取数据库的连接 
	public static Connection getConnection(){
		try {
			/*
			 * 1. 像连接池获取Connection 连接  若连接池当中没有可用的连接池
			 * 就会出现阻塞当前的线程，阻塞的时间由连接池设置的maxWait决定的
			 * 当阻塞的过程中连接池有了Connection连接，那么则会立即使用空闲的Connection连接，
			 * 若超时仍然没有可用的Connection连接  该方法就会抛出异常  
			 * 2. 数据库的连接池当中给我们提供了方法getConnection(),从数据库连接池当中获取连接  
			 */
			Connection conn=ds.getConnection();
			System.out.println("连接成功");
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("连接异常，稍后再试");
		}
		
	}
	//   关于归还资源的话  我们专门的写了集几个方法
	//归还资源    conn.preparedStatement   查询的 有结果集的    带有提前编译的 
	public static void closeConnection(Connection conn,ResultSet rs,PreparedStatement ps){
		try {
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				// 连接池的连接对于close()方法处理是将在连接池中状态设置为空闲（也就是归还）
			conn.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//归还资源的  使用的是Statement   conn.createStatement()
	public static void closeConnection(Connection conn,ResultSet rs,Statement stat){
		try {
			if(conn!=null){
				// 连接池的连接对于close()方法处理是将在连接池中状态设置为空闲（也就是归还）
			conn.close();
			}
			if(rs!=null){
				rs.close();
			}
			if(stat!=null){
				stat.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static   void closeConnection(Connection conn,Statement stat){
		try {
			if(conn!=null){
			conn.close();
			}
			if(stat!=null){
				stat.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Connection conn=DButil.getConnection();
		System.out.println(conn);
	}
	
	

}
