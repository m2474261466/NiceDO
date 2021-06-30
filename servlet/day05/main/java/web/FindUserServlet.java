package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

public class FindUserServlet extends HttpServlet {
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        	 PrintWriter pw= null;
        	try {
        		//设置响应类型和字符集
                res.setContentType("text/html;charset=utf-8");
                //获取输出流
               pw=res.getWriter();
                //调用Dao层数据
                UserDao dao=new UserDaoImpl();
                List<User> list=dao.findAllUserData();
                //绑定数据list
                req.setAttribute("list", list);
                //获取转发器
                RequestDispatcher rd=req.getRequestDispatcher("listUsers.jsp");
                //转发
                rd.forward(req, res);
               /* res.sendRedirect("listUser.jsp");*/
			} catch (Exception e) {
				String message=e.getMessage();
				req.setAttribute("meg", message);
		        req.setAttribute("message", message);
		        req.getRequestDispatcher("login.jsp").forward(req, res);
			}
        	
        }
}
