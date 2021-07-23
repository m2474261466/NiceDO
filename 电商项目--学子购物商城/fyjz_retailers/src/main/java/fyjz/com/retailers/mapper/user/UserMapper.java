package fyjz.com.retailers.mapper.user;

import org.apache.ibatis.annotations.Param;

import fyjz.com.retailers.entity.User;

/**
 * 映射器接口
 * @author Lenovo
 *
 */
public interface UserMapper {
	/** 根据用户名字查找该名字的数量 */
	int findNumByNameMapper(String name);
	
	/** 用户注册 */
	boolean addUserMapper(User user);

	/** 用户登录 */
	User findUserByNameAndPwdMapper(@Param("name")String lname, @Param("pwd")String pwdMd5);

	boolean updateUserMapper(User user);

	
}
