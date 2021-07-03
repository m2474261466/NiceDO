package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 通过session技术来获取用户访问该功能的次数
 */
public class SomeServlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	
    	//获取session对象
    	HttpSession hs=req.getSession();
    	Integer count=(Integer)hs.getAttribute("count");
    	if(count==null){//第一次访问
    		count=1;
    	}else{
    		count++;
    	}
    	hs.setAttribute("count", count);
    	res.setContentType("text/html;charset=utf-8");
    	res.getWriter().print("这是第"+count+"次访问");
    	//重定向到user.jsp
    	//res.sendRedirect("user.jsp");
    }
 
}
