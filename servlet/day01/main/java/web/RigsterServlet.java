package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpContext;

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
                        //设置字符集   
                    	req.setCharacterEncoding("utf-8");
                        //获取用户数据并将用户数据封装到user   
                    	res.setContentType("text/html;charset=utf-8");
                    	//获取输出流
                    	PrintWriter pw=res.getWriter();
                    	   User user=new User();
                           user.setUserEmail(req.getParameter("user_email"));
                           user.setUserName(req.getParameter("user_name"));
                           user.setUserPhone(req.getParameter("user_phone"));
                           user.setUserPwd(req.getParameter("user_pwd"));
                           System.out.println(user);
                           //调用DAO层
                           UserDao us=new UserDaoImpl();
                           int n=us.registerUser(user);
                           if(n==1){
                        	   pw.print("注册成功");
                           }
                    }
}
