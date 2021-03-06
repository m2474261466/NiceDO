package dao;

import java.util.List;

import entity.User;

/**
 * Dao层接口
 * @author 24742
 *
 */
public interface UserDao {
       /**用户注册**/
	int registerUser(User user);
	/**
	 * 查询用户
	 * @return
	 */
	List<User> findAllUserData();
}
