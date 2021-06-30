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
	
	/**
	 * 根据用户名查询用户数量
	 * */
	int selectUserByName(String name);
	
	/**用户登录*/
	int userLogin(String name,String password);
	/**
	 * 根据用户ID删除用户数据
	 * 
	 */
	void deleteUserById(Integer id);
	/**
	 * 根据id查找用户数据
	 * @param id
	 */
	User findUserById(int id);
	/**修改用户数据*/
	void updateUser(User user);
}
