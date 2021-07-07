package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetDataServlet
 */
public class GetDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	//获取上下绑定的数据
    	String user=(String)req.getServletContext().getAttribute("用户");
    	System.out.println("servletcontext绑定的用户:"+user);
    	//获取session绑定的数据
    	String user2=(String)req.getSession().getAttribute("用户2");
    	System.out.println("session绑定的用户2:"+user2);
    	//获取request绑定的数据
    	String user3=(String)req.getAttribute("用户上");
    	System.out.println("request绑定的用户上"+user3);
    }
}
