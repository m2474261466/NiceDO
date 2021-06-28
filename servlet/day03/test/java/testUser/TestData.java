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
    	 int count=dao.selectUserByName("����");
    	 if(count>=1){
    		 System.out.println("�û�����ռ��");
    	 }else{
    		 System.out.println("ͨ��");
    	 }
     }
      
	@Test
	public void testuserLogin(){
		 UserDao dao=new UserDaoImpl();
		 String name="�������ô��";
		 String pwd="m20000509";
		 String mad5Pwd=DigestUtils.md5Hex(pwd+"����");
		 int count=dao.userLogin(name, mad5Pwd);
		 if(count>0){
			 System.out.println("ͨ��");
		 }else{
			 System.out.println("��ͨ��");
		 }
	}
	@Test
	public void testupdateUser(){
		User user=new User(6,"��������������","855858","haoyamei@fyjz.com","18888888888");
		UserDao ss=new UserDaoImpl();
		ss.updateUser(user);
	}
}
