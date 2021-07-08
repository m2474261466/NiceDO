package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ������:
 * Servlet�淶���ж����һ��������������������(����)servlet�����ĵ��ù��̣��������յ�����󣬻���
 * ���ù��������ٵ��ú������������������servlet��
 * ��α�д��������
 * 1.��һ����ʵ����Filter�ӿڣ���ô��������һ����������
 * 2.�ڽӿڷ����У�ʵ�ֹ���(����)�����߼���
 * 3.��web.xml�����ù�������
 * 
 * @author 24742
 *
 */
public class CommonFilter implements Filter{
	
	//��������ʵ��,�������������̽�������ʵ����������һ��
	public CommonFilter(){
		System.out.println("�����CommonFilter�Ĺ��췽��");
	}
	

	@Override
	//�������ĳ�ʼ��,ʵ�������������̵���init()������ɳ�ʼ������,ִ��һ��
	//FilterConfig�ṩgetInitParameter()��ȡ��ʼ������
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("�����CommonFilter�ĳ�ʼ��");
		//��ȡ�ֲ�����
		String initName=filterConfig.getInitParameter("userName");
		System.out.println(initName);
		//��ȡȫ�ֲ���
		String age=filterConfig.getServletContext().getInitParameter("age");
		System.out.println(age);
	}

	
	//������
	/*
	 * �����յ�����󣬻����doFilter�������������������Ὣrequest��response����Ĳ������ݹ���
	 * ע��:ServletRequset��HttpServletRequest���ӿ�
	 *     ServletResponse��HttpServletResponse���ӿ�
	 * ���������FilterChain������doFilter()����,�����������������(����ִ��servlet),�����ж�����,��Ӧ������
	 * 
	 */
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		System.out.println("���˿�ʼ��");
		//��������������ַ���
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ͺ��ַ���
		res.setContentType("text/html;charset=utf-8");
		//�ڹ������л�ȡ����
		String data=req.getParameter("con");
		
		if(data.contains("�Բ�")||data.contains("����")){//�����ˣ����ܽ���servlet
			res.getWriter().print("��ʹ����������");
		}else{//����ͨ��
			chain.doFilter(req, res);
			System.out.println("���˽�����");
		}
				
		
		
	}

	@Override
	//���٣��ر����������ٹ�������
	public void destroy() {
		
		System.out.println("���ٹ�����");
	}

}
