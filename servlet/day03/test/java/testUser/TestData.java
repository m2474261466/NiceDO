package testUser;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

public class TestData {
	@Test
     public void testCountByName(){
    	 UserDao dao=new UserDaoImpl();
    	 int count=dao.selectUserByName("坤哥");
    	 if(count>=1){
    		 System.out.println("用户名被占用");
    	 }else{
    		 System.out.println("通过");
    	 }
     }
      
	@Test
	public void testuserLogin(){
		 UserDao dao=new UserDaoImpl();
		 String name="郝亚美好大二";
		 String pwd="m20000509";
		 String mad5Pwd=DigestUtils.md5Hex(pwd+"西安");
		 int count=dao.userLogin(name, mad5Pwd);
		 if(count>0){
			 System.out.println("通过");
		 }else{
			 System.out.println("不通过");
		 }
	}
	@Test
	public void testupdateUser(){
		User user=new User(6,"郝亚美哈哈哈哈","855858","haoyamei@fyjz.com","18888888888");
		UserDao ss=new UserDaoImpl();
		ss.updateUser(user);
	}
}
