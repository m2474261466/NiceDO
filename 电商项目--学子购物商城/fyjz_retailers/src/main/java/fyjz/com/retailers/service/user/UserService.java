package fyjz.com.retailers.service.user;

import fyjz.com.retailers.entity.User;

/**
 * 业务层接口
 * @author Lenovo
 *
 */
public interface UserService {
	/** 根据用户名字查找该名字的数量 */
	int findNumByName(String name);
	
	/** 用户注册 */
	boolean addUserService(User user);

	/** 用户登录 */
	User findUserByNameAndPwdService(String lname, String lwd);

	
	
	/** 用户更改信息 */
	boolean updateUser(User user);
}
