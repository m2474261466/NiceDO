 package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *Session(会话) 
 *1.什么是session
 *   服务器为了保存用户状态而创建的一个特殊的对象，它在服务器中;
 *   
 *2.session的工作原理
 *   当浏览器访问服务器时，服务器创建session对象(该对象有一个唯一的sessionID)，
 *   服务器会将sessionId以cookie的形式
 *   发送给浏览器,当浏览器再次访问服务器时，会将在消息头以cookie形式保存的 sessionId发送给服务器,
 *   服务器利用发送过来的sessionId找到对应的session对象，如果没有该id，
 *   那么将创建新的sessionid以set-cookie的形式发送给浏览器;
 *3.session的作用:
 *   将服务器中的数据进行共享；
 *   
 *  HttpSession session=request.getSession(boolean flag);
 *  1.HttpSession是一个接口
 *  2.当flag为true(默认为true),首先查看请求中是否有sessionId,如果没有则创建一个session对象，如果
 *  有sessionId,则依据该sessionId查找对应的session对象。
 *  3.当flag为false时,首先查看请求中是否有sessionId,如果没有则返回空指针异常,
 *  如果有则根据sessionId查找session对象
 *   
 *   
 *   
 *   
 */
public class SomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
         
        protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        	//获取session对象
        	HttpSession session=req.getSession();
        	//通过session对象获取sessionId
        	String sessionId=session.getId();
        	System.out.println(sessionId);
        	
        	
        	//利用session绑定数据
        	session.setAttribute("name", "坤哥");
        	//根据session绑定名获取session绑定的值
        	Object ss=session.getAttribute("name");
        	System.out.println(ss);
        	//重定向
        	res.sendRedirect(req.getContextPath()+"/a.jsp");
        }
	

}
