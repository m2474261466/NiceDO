package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;

/**
 * Servlet implementation class SomeServlet
 */
public class SomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   @Override
		protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			List<User> list=new ArrayList<User>();
			for(int i=1;i<=10;i++){
				User user=new User();
				 user.setAge(20+i);
				 user.setName("admin"+i);
				 list.add(user);
			}
			//绑定数据
			req.getSession().setAttribute("list", list);
			//重定向
			res.sendRedirect(req.getContextPath()+"/DemoJstl02.jsp");
			
		}

}
