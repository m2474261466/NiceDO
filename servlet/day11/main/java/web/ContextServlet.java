package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextServlet
 */
public class ContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	/*//��ȡ����
    	String data=req.getParameter("con");
    	req.setCharacterEncoding("utf-8");
    	res.setContentType("text/html;charset=utf-8");
    	PrintWriter pw=res.getWriter();
    	res.getWriter().print("����˵������"+data+"Υ��");*/
    	System.out.println("����servlet");
    }
}
