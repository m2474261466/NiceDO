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
 * Servlet�����ģ�
 * 1.ʲô��Servlet�����ģ�
 * ��������֮��,���ÿһ��WebӦ�ô���Ψһ�ķ���ServletContext�ӿ�Ҫ��Ķ���,�ö���
 * һ���֮ΪServlet������,һ��WebӦ�ö�Ӧһ��������;
 * �ص�:ֻҪ�������رգ������ľ�һֱ����;
 * 2.��λ�ȡServlet������?
 *  GenericServlet�ṩ��getServletContext()��������ȡ������
 * 3.����:������
 * 
 * 
 * ע��:request,session,servlet�����Ķ��ṩ�����ݰ���ط���,���Ǹ����ѡȡ?
 *     �������������ݶ�������ʱ������Ϊ:request<sesiion<servletContext������ʹ�������������,������ʹ���������ڶ̵ġ�
 * 4.�����jspҳ���ȡservletContext�󶨵����ݣ�
 *     
 * 
 */
public class ContextServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//��ȡ�ö����ServletContext������
		ServletContext sc=req.getServletContext();
		//ͨ�������İ�����
		sc.setAttribute("�û�","dqwd");
		HttpSession session=req.getSession();
		//��session���ñ��ʶ�20��
		session.setMaxInactiveInterval(20);
		//��session������
		req.getSession().setAttribute("�û�2", "С��");
		//��request������
		req.setAttribute("�û��� ", "sda");
	}
  
}
