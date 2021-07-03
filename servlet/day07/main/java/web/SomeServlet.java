 package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *Session(�Ự) 
 *1.ʲô��session
 *   ������Ϊ�˱����û�״̬��������һ������Ķ������ڷ�������;
 *   
 *2.session�Ĺ���ԭ��
 *   ����������ʷ�����ʱ������������session����(�ö�����һ��Ψһ��sessionID)��
 *   �������ὫsessionId��cookie����ʽ
 *   ���͸������,��������ٴη��ʷ�����ʱ���Ὣ����Ϣͷ��cookie��ʽ����� sessionId���͸�������,
 *   ���������÷��͹�����sessionId�ҵ���Ӧ��session�������û�и�id��
 *   ��ô�������µ�sessionid��set-cookie����ʽ���͸������;
 *3.session������:
 *   ���������е����ݽ��й���
 *   
 *  HttpSession session=request.getSession(boolean flag);
 *  1.HttpSession��һ���ӿ�
 *  2.��flagΪtrue(Ĭ��Ϊtrue),���Ȳ鿴�������Ƿ���sessionId,���û���򴴽�һ��session�������
 *  ��sessionId,�����ݸ�sessionId���Ҷ�Ӧ��session����
 *  3.��flagΪfalseʱ,���Ȳ鿴�������Ƿ���sessionId,���û���򷵻ؿ�ָ���쳣,
 *  ����������sessionId����session����
 *   
 *   
 *   
 *   
 */
public class SomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
         
        protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        	//��ȡsession����
        	HttpSession session=req.getSession();
        	//ͨ��session�����ȡsessionId
        	String sessionId=session.getId();
        	System.out.println(sessionId);
        	
        	
        	//����session������
        	session.setAttribute("name", "����");
        	//����session������ȡsession�󶨵�ֵ
        	Object ss=session.getAttribute("name");
        	System.out.println(ss);
        	//�ض���
        	res.sendRedirect(req.getContextPath()+"/a.jsp");
        }
	

}
