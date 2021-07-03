package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Session��ʱ:
 * �������Ὣ���е�ʱ�������session����ɾ��������������Ŀ���ǽ�ʡsession�ռ�
 * Ĭ�ϵ�sessionʱ�䳤����30����(��Servers�ļ��е�tomcat/web.xml/579��)
 */
public class SomeServlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
           //��ȡsession����
    	   HttpSession session=req.getSession();
           //��ȡsessionʱ��(��)
    	   session.setMaxInactiveInterval(10);
    	   //������
    	   session.setAttribute("userName", "admin");
    	   session.setAttribute("userAge", "20");
    	   //�Ƴ����ݰ�(�˽�)
    	   session.removeAttribute("userName");
    	  // res.getWriter().print(session.getAttribute("userName"));
    	   req.getRequestDispatcher("a.jsp").forward(req, res);
    }
    

}
