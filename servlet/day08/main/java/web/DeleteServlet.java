package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;

public class DeleteServlet extends HttpServlet {
            @Override
            protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            	try {
            		//获取请求参数id
                	String str=req.getParameter("id");
                	if(str==null||str==""){
                		throw new RuntimeException("用户id不存在");
                		}
                	int id=Integer.parseInt(str);
                	UserDao dao=new UserDaoImpl();
                	dao.deleteUserById(id);
                	//重定向到listUser.jsp
                	res.sendRedirect("find");
				} catch (Exception e) {
					String message=e.getMessage();
					System.out.println(message);
            	
            }
}
            }
