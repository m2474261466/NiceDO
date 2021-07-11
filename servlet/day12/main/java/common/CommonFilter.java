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
		//1.获取session所绑定的值
		HttpSession session=req.getSession();
		User user=(User)session.getAttribute("user");
		//2.登录和注册不需要过滤
		String uri=req.getRequestURI();
		if(uri.endsWith("/toLogin.do")||uri.endsWith("/toRegister.do")){
			chain.doFilter(req, res);
			return;
		}
		//3.过滤所有的请求路径,如果获取session所绑定的登录成功后所绑定的值不为null则通过,否则重定向到登录页面
		if(user==null){//重定向到登录页面
			res.sendRedirect(req.getContextPath()+"/login.jsp");
		}else{//通过
			chain.doFilter(req, res);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
