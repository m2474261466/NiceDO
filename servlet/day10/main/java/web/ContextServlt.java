package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet上下文：
 * 1.什么是Servlet上下文？
 * 容器启动之后,会给每一个Web应用创建唯一的符合ServletContext接口要求的对象,该对象
 * 一般称之为Servlet上下文,一个Web应用对应一个上下文;
 * 特点:只要容器不关闭，上下文就一直存在;
 * 2.如何获取Servlet上下文?
 *  GenericServlet提供了getServletContext()方法来获取上下文
 * 3.作用:绑定数据
 * 
 * 
 * 注意:request,session,servlet上下文都提供了数据绑定相关方法,我们该如何选取?
 *     以上三个绑定数据对象生存时间依次为:request<sesiion<servletContext在满足使用条件的情况下,尽量先使用生命周期短的。
 * 4.如何在jsp页面获取servletContext绑定的数据？
 *     
 * 
 */
public class ContextServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//获取该对象的ServletContext上下文
		ServletContext sc=req.getServletContext();
		//通过上下文绑定数据
		sc.setAttribute("用户","dqwd");
		HttpSession session=req.getSession();
		//给session设置保鲜度20秒
		session.setMaxInactiveInterval(20);
		//用session绑定数据
		req.getSession().setAttribute("用户2", "小潘");
		//用request绑定数据
		req.setAttribute("用户上 ", "sda");
	}
  
}
