package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet����������
 * 1.ʲô��servlet����������?
 * Servlet��������Servlet����,��Servlet��������������̳�֮ΪServlet��������.
 * 2.������������:
 * 2-1:
 *  a.ʲôʱ��ʵ������
 *  
 *  ���1:�����յ�����󴴽�Servlet����
 *  ���2:��������֮����������Servlet����(��Ҫ�����ļ�)
 *     �������������������Servlet�Ĺ�������������
 *  b.��������ʵ��?
 *    ����ֻ������һ��ʵ����
 * 2-2:��ʼ��
 *    a:ʲô�ǳ�ʼ��?
 *    ��������servlet��init����(�÷���ִֻ����һ��)
 *    b:GenericServlet�Ѿ��ṩ��init������ʵ��
 *    c:���ʵ���Լ��ĳ�ʼ�������߼�?
 *      ֻҪ��дGenericServlet��init����(�����в�����init����)
 *    d:��ʼ������
 *      1.���ó�ʼ������
 *      2.ʹ��servletConfig�ṩ��genInitParameter��������ȡ��ʼ������
 * 2-3:����(����service����)
 *    �����յ�����֮�����servlet��service������������
 * 2-4:����
 * GenericServlet�ṩ��destroy����������ɾ��servlet����֮ǰ�����destroy������ʵ�����ٹ���
 *  
 *  
 *  �ܽ�:��Ϊ�Ĳ��� ,˳��:ʵ����-->��ʼ��-->����-->����
 */
public class OneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//����Servletʵ��
	//ֻ��һ��ʵ��  ������һ��ʵ������
     public OneServlet(){
    	 System.out.println("������OneServlet����");
     }
     //2.ͨ����дGenericServlet��init������ʵ�ָ�Servlet�ĳ�ʼ��
     //һ������ĳ�ʼ������ Ҳ��һ��
     public void init() throws ServletException {
        System.out.println("OneServlet�ĳ�ʼ��");
        //��ȡ�ֲ���ʼ������
        String value=getInitParameter("userName");
        System.out.println(value);
     }
     //3.����service����
     //����ҵ����� ���󼸴� ������
     @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("OneServlet�е�service����");
    }
     //4.����:ͨ����дGenericServlet���е�destroy������ʵ������
     @Override
     public void destroy() {
       System.out.println("��servlet��������");
     }
     //��ȡȫ�ֵĳ�ʼ������
     //�в�������ִ���в�����   public void init(ServletConfig config) throws ServletException  
     //��ִ���޲�����getInitParameter("userName");
     
     @Override
    public void init(ServletConfig config) throws ServletException {
    	String value=config.getServletContext().getInitParameter("password");
       System.out.println("ȫ�ֵĲ���"+value);
     }
}
