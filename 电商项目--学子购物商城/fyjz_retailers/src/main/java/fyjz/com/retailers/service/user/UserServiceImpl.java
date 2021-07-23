package fyjz.com.retailers.service.user;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fyjz.com.retailers.entity.User;
import fyjz.com.retailers.mapper.user.UserMapper;
import fyjz.com.retailers.service.commons.NameExistsException;
import fyjz.com.retailers.service.commons.NameNotNullException;
/**
 * 业务层实现类
 * @author Lenovo
 *
 */
// 需要被Spring管理
@Service
public class UserServiceImpl implements UserService {
	// 将mapper注入进来
	@Autowired
	private UserMapper mapper;
	
	/** 根据用户名字查找该名字的数量 */
	public int findNumByName(String name) {
		if(name == null || name.trim().isEmpty()){
			throw new NameNotNullException("用户名不能为空~~");
		}
		int n = mapper.findNumByNameMapper(name);
		if(n > 0){
			throw new NameExistsException("用户名已存在~~");
		}
		return n;
	}

	/** 用户注册 */
	public boolean addUserService(User user) {
		// 获取用户输入的密码
		String pwd = user.getPassword();
		// 对该密码进行md5加密
		String data = "风云";
		String pwdMd5 = DigestUtils.md5Hex(pwd + data);
		user.setPassword(pwdMd5);
		boolean b = mapper.addUserMapper(user);
		if(b == false){
			throw new RuntimeException("系统维护中 . . . ");
		}else{
			return b;
		}	
	}

	/** 用户登录 */
	public User findUserByNameAndPwdService(String lname, String lwd) {
		// 对该密码进行md5加密
		String data = "风云";
		String pwdMd5 = DigestUtils.md5Hex(lwd + data);
		User user = mapper.findUserByNameAndPwdMapper(lname,pwdMd5);
		if(user == null){
			throw new RuntimeException("用户名或密码错误~");
		}
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		boolean b=mapper.updateUserMapper(user);
		if(b == false){
			throw new RuntimeException("系统维护中 . . . ");
		}else{
			return b;
		}
		
	}



	
	
}
