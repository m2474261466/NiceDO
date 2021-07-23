package testRetailersUser;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fyjz.com.retailers.entity.User;
import fyjz.com.retailers.mapper.user.UserMapper;
import fyjz.com.retailers.service.user.UserService;

public class TestUser {
	ApplicationContext act;
	UserMapper mapper;
	UserService service;
	@Test
	@Before
	public void init(){
		act = new ClassPathXmlApplicationContext("spring-dao.xml");
		mapper = act.getBean("userMapper",UserMapper.class);
		
	}
	
	/*
	 * ≤‚ ‘”√ªß◊¢≤·
	 */
	@Test
	public void testAddUser(){
		User user = new User();
		user.setUserName("Idiot");
		user.setPassword("233333");
		user.setEmail("1654013191@qq.com");
		user.setPhone("13154004061");
		user.setCreateUser("Idiot");
		user.setModifiedUser("Idiot");
		mapper.addUserMapper(user);
	}
	
	@Test 
	public void testupDateUser(){
		User user=new User();
		user.setId(8);
		user.setGender(1);
		user.setPassword("1235522");
		boolean b=mapper.updateUserMapper(user);
	}
	

}
