package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;

public class CommonFilter  implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		//1.��ȡsession���󶨵�ֵ
		HttpSession session=req.getSession();
		User user=(User)session.getAttribute("user");
		//2.��¼��ע�᲻��Ҫ����
		String uri=req.getRequestURI();
		if(uri.endsWith("/toLogin.do")||uri.endsWith("/toRegister.do")){
			chain.doFilter(req, res);
			return;
		}
		//3.�������е�����·��,�����ȡsession���󶨵ĵ�¼�ɹ������󶨵�ֵ��Ϊnull��ͨ��,�����ض��򵽵�¼ҳ��
		if(user==null){//�ض��򵽵�¼ҳ��
			res.sendRedirect(req.getContextPath()+"/login.jsp");
		}else{//ͨ��
			chain.doFilter(req, res);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
