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
	   System.out.println("创建了TwoServlet");
   }
   public void init() throws ServletException {
       System.out.println("OneServlet的初始化");
       //two无法访问one的局部初始化参数
       String value=getInitParameter("password");
       System.out.println(value);
    }
 //获取全局的初始化参数
   @Override
  public void init(ServletConfig config) throws ServletException {
  	String value=config.getServletContext().getInitParameter("password");
     System.out.println("全局的参数"+value);
   }
}
