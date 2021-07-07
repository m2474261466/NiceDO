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
    	
    	//��ȡ���°󶨵�����
    	String user=(String)req.getServletContext().getAttribute("�û�");
    	System.out.println("servletcontext�󶨵��û�:"+user);
    	//��ȡsession�󶨵�����
    	String user2=(String)req.getSession().getAttribute("�û�2");
    	System.out.println("session�󶨵��û�2:"+user2);
    	//��ȡrequest�󶨵�����
    	String user3=(String)req.getAttribute("�û���");
    	System.out.println("request�󶨵��û���"+user3);
    }
}
