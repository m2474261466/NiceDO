package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ͨ��session��������ȡ�û����ʸù��ܵĴ���
 */
public class SomeServlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	
    	//��ȡsession����
    	HttpSession hs=req.getSession();
    	Integer count=(Integer)hs.getAttribute("count");
    	if(count==null){//��һ�η���
    		count=1;
    	}else{
    		count++;
    	}
    	hs.setAttribute("count", count);
    	res.setContentType("text/html;charset=utf-8");
    	res.getWriter().print("���ǵ�"+count+"�η���");
    	//�ض���user.jsp
    	//res.sendRedirect("user.jsp");
    }
 
}
