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
				//��ȡ�������·��
	             String path=req.getContextPath();
	              System.out.println(path);
	              //�ض���index.jsp
	             res.sendRedirect(path+"/other/index.jsp");
	              /*
	               * //������ɷ��ʣ������404��
	               * ��Ϊת����ĵ�ַ��HTTP Status 404 - /kunge2020Servlet_day05_03/kunge2020Servlet_day05_03/other/index.jsp,
	               * ���Ǹĳ�index.jsp�����
	               */
	              /*
	               * ת������(ת���в�Ҫ��Ӧ����ֱ��д��·������)
	               */
	              // req.getRequestDispatcher(path+"/other/index.jsp").forward(req, res);
	             //  req.getRequestDispatcher("index.jsp").forward(req, res);
			   }

}
