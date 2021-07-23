package fyjz.com.retailers.service.user;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fyjz.com.retailers.entity.User;
import fyjz.com.retailers.mapper.user.UserMapper;
import fyjz.com.retailers.service.commons.NameExistsException;
import fyjz.com.retailers.service.commons.NameNotNullException;
/**
 * ҵ���ʵ����
 * @author Lenovo
 *
 */
// ��Ҫ��Spring����
@Service
public class UserServiceImpl implements UserService {
	// ��mapperע�����
	@Autowired
	private UserMapper mapper;
	
	/** �����û����ֲ��Ҹ����ֵ����� */
	public int findNumByName(String name) {
		if(name == null || name.trim().isEmpty()){
			throw new NameNotNullException("�û�������Ϊ��~~");
		}
		int n = mapper.findNumByNameMapper(name);
		if(n > 0){
			throw new NameExistsException("�û����Ѵ���~~");
		}
		return n;
	}

	/** �û�ע�� */
	public boolean addUserService(User user) {
		// ��ȡ�û����������
		String pwd = user.getPassword();
		// �Ը��������md5����
		String data = "����";
		String pwdMd5 = DigestUtils.md5Hex(pwd + data);
		user.setPassword(pwdMd5);
		boolean b = mapper.addUserMapper(user);
		if(b == false){
			throw new RuntimeException("ϵͳά���� . . . ");
		}else{
			return b;
		}	
	}

	/** �û���¼ */
	public User findUserByNameAndPwdService(String lname, String lwd) {
		// �Ը��������md5����
		String data = "����";
		String pwdMd5 = DigestUtils.md5Hex(lwd + data);
		User user = mapper.findUserByNameAndPwdMapper(lname,pwdMd5);
		if(user == null){
			throw new RuntimeException("�û������������~");
		}
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		boolean b=mapper.updateUserMapper(user);
		if(b == false){
			throw new RuntimeException("ϵͳά���� . . . ");
		}else{
			return b;
		}
		
	}



	
	
}
