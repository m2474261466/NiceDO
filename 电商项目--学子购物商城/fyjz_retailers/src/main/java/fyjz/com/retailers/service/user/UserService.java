package fyjz.com.retailers.service.user;

import fyjz.com.retailers.entity.User;

/**
 * ҵ���ӿ�
 * @author Lenovo
 *
 */
public interface UserService {
	/** �����û����ֲ��Ҹ����ֵ����� */
	int findNumByName(String name);
	
	/** �û�ע�� */
	boolean addUserService(User user);

	/** �û���¼ */
	User findUserByNameAndPwdService(String lname, String lwd);

	
	
	/** �û�������Ϣ */
	boolean updateUser(User user);
}
