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

/**
  * 用户注册业务
  * @author 24742
  *
  */
public class RigsterServlet  extends  HttpServlet{
                    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
                        try {
                        	
                            //设置字符集   
                        	req.setCharacterEncoding("utf-8");
                            //获取用户数据并将用户数据封装到user   
                        	res.setContentType("text/html;charset=utf-8");
                        	
                        	String userEmail=req.getParameter("email");
                        	String userName=req.getParameter("uname");
                        	String userPhone=req.getParameter("phone");
                        	String userPwd=req.getParameter("pwd");
                        	if(userName==null||userName.trim().isEmpty()){
                        		throw new RuntimeException("用户名不能为空!");
                        	}
                        	if(userPwd==null||userPwd.trim().isEmpty()){
                        		throw new RuntimeException("密码不能为空!");
                        	}
                        	
                        	  //调用DAO层
                            UserDao us=new UserDaoImpl();
                        	//判断用户名是否被占用
                             int count=us.selectUserByName(userName);
                        	 if(count>=1){
                        		 throw new RuntimeException("用户名被占用");
                        	 }
                        	 if(userName==null||userName.trim().isEmpty()){
                         		throw new RuntimeException("密码不能为空!");
                         	}
                        	 //对用户密码进行MD5加密
                        	 String str="西安";
                        	 String md5Pwd=DigestUtils.md5Hex(userPwd+str);
                             
                        	 
                        	 //封装用户的数据到对象中
                        	   User user=new User();
                               user.setUserEmail(userEmail);
                               user.setUserName(userName);
                               user.setUserPhone(userPhone);
                               user.setUserPwd(md5Pwd);
                               System.out.println(user);
                              
                               int n=us.registerUser(user);
                              if(n==1){
                            	  //注册成功，重定向到登录页面
                            	  res.sendRedirect("login.jsp");
                              }
                           } catch (Exception e) {
                        	   String message = e.getMessage();   
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