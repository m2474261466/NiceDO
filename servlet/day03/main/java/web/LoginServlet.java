package web;
/**
 * 用户登录
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import dao.UserDao;
import dao.UserDaoImpl;

public class LoginServlet extends HttpServlet {
              @Override
            protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            	try {
            		//设置请求字符集
              	  req.setCharacterEncoding("utf-8");
              	  //设置响应的字符集和响应类型
              	res.setContentType("text/html;charset=utf-8");
              	//获取用户提交数据
              	String userName=req.getParameter("uname");
              	String userPwd=req.getParameter("pwd");
              	if(userName==null||userName.trim().isEmpty()){
            		throw new RuntimeException("用户名不能为空!");
            	}
            	if(userPwd==null||userPwd.trim().isEmpty()){
            		throw new RuntimeException("密码不能为空!");
            	}
            	
              	//判断用户是否登录成功
              	UserDao dao=new UserDaoImpl();
              	String str="西安";
              	String md5Pwd=DigestUtils.md5Hex(userPwd+str);
              	int count=dao.userLogin(userName, md5Pwd);
              	if(count>0){//登录成功
              		//转发到用户查询页面
              //	req.getRequestDispatcher("").forward(req, res);
              		//重定向到查询用户数据页面
              		res.sendRedirect("find");
	              	}else{
	              		throw new RuntimeException("用户名或密码错误");
	              	}
				} catch (Exception e) {
					String message=e.getMessage();
					
					if(message.equals("用户名不能为空")){
                	    req.setAttribute("mes_name", message);
                	   }else if(message.equals("密码不能为空")){
                	    req.setAttribute("mes_pwd", message);
                	   }else{
                   	    req.setAttribute("message", message);
                   	   }  
                   	   
                   	   // 获取转发器并转发
                   	   req.getRequestDispatcher("login.jsp").forward(req, res);
                   	   }
				}
            	
            }

