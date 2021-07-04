package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.junit.Test;

import entity.User;
import util.DButil;

/***
 * Dao层接口的实现类
 * @author 24742
 *
 */
public class UserDaoImpl implements UserDao {

    /**用户注册 */
	public int registerUser(User user) {
	  
		Connection conn=null;
		PreparedStatement ps=null;
	    try{
	    	//获取链接
	    	conn=DButil.getConnection();
	    	String sql="insert into t_user(user_name,user_pwd,user_email,user_phone) values(?,?,?,?)";
	    	ps=conn.prepareStatement(sql);
	    	ps.setString(1, user.getUserName());
	        ps.setString(2,user.getUserPwd());
	        ps.setString(3, user.getUserEmail());
	        ps.setString(4, user.getUserPhone());
	        int n=ps.executeUpdate();
	        return n;
	    }catch(Exception e){
	    	e.printStackTrace();
	    	throw new RuntimeException("插入失败");
	    }finally{
	    	DButil.closeConnection(conn,null,ps);
	    }
	
	
	}
	@Test
	public List<User> findAllUserData(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet res=null;
		List<User> list=new ArrayList<User>();
		try{
			conn=DButil.getConnection();
			String sql="select * from t_user";
			ps=conn.prepareStatement(sql);
			res=ps.executeQuery();
			while(res.next()){
				User user=new User();
				user.setId(res.getInt("id"));
				user.setUserName(res.getString("user_name"));
				user.setUserPwd(res.getString("user_pwd"));
				user.setUserEmail(res.getString("user_email"));
				user.setUserPhone(res.getString("user_phone"));
				list.add(user);
			}
			return list;
		}catch(Exception e){
			throw new RuntimeException("系统维护中");
		}finally{
			DButil.closeConnection(conn, res,ps);
		}
    }
	/**
	 * 根据用户名查询用户数量
	 * */
	@Override
	public int selectUserByName(String name) {

		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet res=null;
		int count=0;
		try {
			conn=DButil.getConnection();
			String sql="select * from t_user where user_name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			res=ps.executeQuery();
			if(res.next()){
				count++;
			}
			return count;
			
		} catch (Exception e) {
			throw new RuntimeException("系统维护，请稍等");
		}finally{
			DButil.closeConnection(conn,res,ps);
		}
		
	}
	@Override
	public User userLogin(String name, String password) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet res=null;
        User user=null;
		try {
			conn=DButil.getConnection();
			String sql="select * from t_user where user_name=? and user_pwd=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			res=ps.executeQuery();
			user=new User();
			if(res.next()){
				user.setId(res.getInt("id"));
				user.setUserName(res.getString("user_name"));
				user.setUserEmail(res.getString("user_email"));
				user.setUserPhone(res.getString("user_phone"));
				user.setUserPwd(res.getString("user_pwd"));
			}
			return user;
			
		} catch (Exception e) {
			throw new RuntimeException("系统维护，请稍等");
		}finally{
			DButil.closeConnection(conn,res,ps);
		}
	}
	@Override
	public void deleteUserById(Integer id) {
		Connection conn=null;
		PreparedStatement ps=null;
		
		
		try{
			conn=DButil.getConnection();
			String sql="delete from t_user where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(Exception e){
			throw new RuntimeException("系统维护，请稍等");
		}finally{
			DButil.closeConnection(conn,null,ps);
		}
		
		
	}
	
	/**
	 * 根据id查找用户数据
	 * @param id
	 */
	public User findUserById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet res=null;
		User user=null;
	try {
		conn=DButil.getConnection();
		String sql="select * from t_user where id=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		res=ps.executeQuery();
		if(res.next()){
			user=new User();
			user.setId(res.getInt("id"));
			user.setUserEmail(res.getString("user_email"));
			user.setUserName(res.getString("user_name"));
			user.setUserPhone(res.getString("user_phone"));
		}
		return user;
	} catch (Exception e) {
		throw new RuntimeException("系统维护，请稍等");
	}finally{DButil.closeConnection(conn,res,ps);
	}

	
	
	}
	@Override
	public void updateUser(User user) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DButil.getConnection();
			String sql="update t_user set user_name=? ,user_pwd=? ,user_phone=?, user_email=? where id=?";
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPwd());
			ps.setString(3, user.getUserPhone());
			ps.setString(4,user.getUserEmail());
			ps.setInt(5, user.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException("系统维护，请稍等");
		}finally{
			DButil.closeConnection(conn,null,ps);
		}
		
	} 

}
