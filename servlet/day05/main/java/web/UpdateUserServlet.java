package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

/**
 * 根据用户id修改用户数据
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	
    	res.setContentType("text/html;charset=utf-8");
    	PrintWriter pw=res.getWriter();
    	
    	
    	try {
    		//设置请求参数的编码格式
        	req.setCharacterEncoding("utf-8");
        	//获取用户参数
        	int id=Integer.parseInt(req.getParameter("id"));
        	String userName=req.getParameter("uname");
        	String userEmail=req.getParameter("email");
        	String userPhone=req.getParameter("phone");
        	String userPwd=req.getParameter("updatePwd");
        	String userConfirm=req.getParameter("confrimPwd");
        	
        	if(userName==null||userName.trim().isEmpty()){
        		throw new RuntimeException("用户名不能为空!");
        	}
        	if(userPwd==null||userPwd.trim().isEmpty()){
        		throw new RuntimeException("密码不能为空!");
        	}
        	//加密后的密码和确认密码
        	String md5Pwd=DigestUtils.md5Hex(userPwd+"西安");
        	String md5PwdConfirm=DigestUtils.md5Hex(userConfirm+"西安");
        	if(!md5Pwd.equals(md5PwdConfirm)){//判断修改密码和确认密码是否一致
        		throw new RuntimeException("密码不一致");
        		
        	}
        	//调用dao层
        	UserDao dao=new UserDaoImpl();
        	User user=new User(id,userName,md5Pwd,userEmail,userPhone);
        	dao.updateUser(user);
        	
        	//重定向find
        	res.sendRedirect("find");
		} catch (Exception e) {
			String message=e.getMessage();
			if(message.equals("用户名不能为空")){
				pw.print(message);
			}else if(message.equals("密码不能为空")){
				pw.print(message);
			}else if(message.equals("密码不一致")){
				pw.print(message);
			}else{
				pw.print(message);
			}
			
			
		}
    		
    	
    }

}
