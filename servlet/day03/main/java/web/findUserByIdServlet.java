package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;
/**
 * 根据用户id查询用户数据
 * @author 24742
 *
 */
public class findUserByIdServlet extends HttpServlet {
        protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
           try {
        	   //获取用户的id
           	int id=Integer.parseInt(req.getParameter("id"));
           	//System.out.println(id);
           	//通过用户id查询用户数据
           	UserDao dao=new UserDaoImpl();
           	User user=dao.findUserById(id);
           	//绑定user数据
           	req.setAttribute("user", user);
           	//获取转发器并转发
           	req.getRequestDispatcher("updateUser.jsp").forward(req, res);
		} catch (Exception e) {
			req.setAttribute("message", e.getMessage());
			req.getRequestDispatcher("updateUser.jsp").forward(req, res);
		}
    }    
}
