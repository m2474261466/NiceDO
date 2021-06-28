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
	
	/**
	 * �����û�����ѯ�û�����
	 * */
	int selectUserByName(String name);
	
	/**�û���¼*/
	int userLogin(String name,String password);
	/**
	 * �����û�IDɾ���û�����
	 * 
	 */
	void deleteUserById(Integer id);
	/**
	 * ����id�����û�����
	 * @param id
	 */
	User findUserById(int id);
	/**�޸��û�����*/
	void updateUser(User user);
}
