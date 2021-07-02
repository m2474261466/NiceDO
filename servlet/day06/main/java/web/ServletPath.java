package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletPath
 */
public class ServletPath extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
			protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				//获取请求绝对路径
	             String path=req.getContextPath();
	              System.out.println(path);
	              //重定向到index.jsp
	             res.sendRedirect(path+"/other/index.jsp");
	              /*
	               * //这个不可访问，会出现404，
	               * 因为转发后的地址是HTTP Status 404 - /kunge2020Servlet_day05_03/kunge2020Servlet_day05_03/other/index.jsp,
	               * 但是改成index.jsp便可以
	               */
	              /*
	               * 转发错误(转发中不要以应用名直接写在路径里面)
	               */
	              // req.getRequestDispatcher(path+"/other/index.jsp").forward(req, res);
	             //  req.getRequestDispatcher("index.jsp").forward(req, res);
			   }

}
