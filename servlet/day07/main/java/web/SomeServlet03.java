package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Session超时:
 * 服务器会将空闲的时间过长的session对象删除掉，这样做的目的是节省session空间
 * 默认的session时间长度是30分钟(在Servers文件中的tomcat/web.xml/579行)
 */
public class SomeServlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
           //获取session对象
    	   HttpSession session=req.getSession();
           //获取session时间(秒)
    	   session.setMaxInactiveInterval(10);
    	   //绑定数据
    	   session.setAttribute("userName", "admin");
    	   session.setAttribute("userAge", "20");
    	   //移除数据绑定(了解)
    	   session.removeAttribute("userName");
    	  // res.getWriter().print(session.getAttribute("userName"));
    	   req.getRequestDispatcher("a.jsp").forward(req, res);
    }
    

}
