package web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class TwoServlet
 */
public class TwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public TwoServlet(){
	   System.out.println("������TwoServlet");
   }
   public void init() throws ServletException {
       System.out.println("OneServlet�ĳ�ʼ��");
       //two�޷�����one�ľֲ���ʼ������
       String value=getInitParameter("password");
       System.out.println(value);
    }
 //��ȡȫ�ֵĳ�ʼ������
   @Override
  public void init(ServletConfig config) throws ServletException {
  	String value=config.getServletContext().getInitParameter("password");
     System.out.println("ȫ�ֵĲ���"+value);
   }
}
