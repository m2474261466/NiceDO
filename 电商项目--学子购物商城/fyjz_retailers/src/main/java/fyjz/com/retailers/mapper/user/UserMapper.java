package fyjz.com.retailers.mapper.user;

import org.apache.ibatis.annotations.Param;

import fyjz.com.retailers.entity.User;

/**
 * ӳ�����ӿ�
 * @author Lenovo
 *
 */
public interface UserMapper {
	/** �����û����ֲ��Ҹ����ֵ����� */
	int findNumByNameMapper(String name);
	
	/** �û�ע�� */
	boolean addUserMapper(User user);

	/** �û���¼ */
	User findUserByNameAndPwdMapper(@Param("name")String lname, @Param("pwd")String pwdMd5);

	boolean updateUserMapper(User user);

	
}
