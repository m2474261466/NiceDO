package dao;

import java.util.List;

import entity.User;

/**
 * Dao��ӿ�
 * @author 24742
 *
 */
public interface UserDao {
       /**�û�ע��**/
	int registerUser(User user);
	/**
	 * ��ѯ�û�
	 * @return
	 */
	List<User> findAllUserData();
}
