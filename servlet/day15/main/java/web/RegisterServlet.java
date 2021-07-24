package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;
import sun.security.provider.MD5;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	res.setContentType("text/html;charset=utf-8");
    	try {
    		String userEmail=req.getParameter("email");
        	String userName=req.getParameter("uname");
        	String userPhone=req.getParameter("phone");
        	String userPwd=req.getParameter("pwd");
        	if(userName==null||userName.isEmpty()){
        		throw new RuntimeException("用户名不能为空");
        	}
        	if(userPwd==null||userPwd.isEmpty()){
        		throw new RuntimeException("密码不能为空");
        	}
        	UserDao ud=new UserDaoImpl();
        	int count=ud.selectUserByName(userName);
        	if(count>=1){
        		throw new RuntimeException("用户名被占用");
        	}
        
        	String str="天问";
        	String MdPwd=DigestUtils.md5Hex(userPwd+str);
        	User user=new User();
        	user.setUserName(userName);
        	user.setUserPwd(MdPwd);
        	user.setUserEmail(userEmail);
        	user.setUserPhone(userPhone);
        	int n=ud.registerUser(user);
        	if(n==1){
        		res.sendRedirect(req.getContextPath()+"/login.jsp");
        	}
		} catch (Exception e) {
			System.out.println("zou");
			String message=e.getMessage();
			System.out.println(message);
			  if(message.equals("用户名不能为空")||message.equals("用户名被占用")){
         	    req.setAttribute("mes_name", message);
         	   }else if(message.equals("密码不能为空")){
         	    req.setAttribute("mes_pwd", message);
         	   }else{
         	    req.setAttribute("message", message);
         	   }  
         	   
         	   // 获取转发器并转发
         	   req.getRequestDispatcher("addUser.jsp").forward(req, res);
         	   }
			}
	
    }

