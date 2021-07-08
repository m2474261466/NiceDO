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
 * 过滤器:
 * Servlet规范当中定义的一种特殊的组件，用来过滤(拦截)servlet容器的调用过程，当容器收到请求后，会先
 * 调用过滤器，再调用后续的其他组件，例如servlet；
 * 如何编写过滤器？
 * 1.当一个类实现了Filter接口，那么这个类就是一个过滤器；
 * 2.在接口方法中，实现过滤(拦截)处理逻辑；
 * 3.在web.xml中配置过滤器；
 * 
 * @author 24742
 *
 */
public class CommonFilter implements Filter{
	
	//过滤器的实例,容器启动后立刻将过滤器实例化，创建一次
	public CommonFilter(){
		System.out.println("这个是CommonFilter的构造方法");
	}
	

	@Override
	//过滤器的初始化,实例化后容器立刻调用init()方法完成初始化操作,执行一次
	//FilterConfig提供getInitParameter()获取初始化参数
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("这个是CommonFilter的初始化");
		//获取局部参数
		String initName=filterConfig.getInitParameter("userName");
		System.out.println(initName);
		//获取全局参数
		String age=filterConfig.getServletContext().getInitParameter("age");
		System.out.println(age);
	}

	
	//过滤器
	/*
	 * 容器收到请求后，会调用doFilter方法来处理请求，容器会将request和response对象的参数传递过来
	 * 注意:ServletRequset是HttpServletRequest父接口
	 *     ServletResponse是HttpServletResponse父接口
	 * 如果调用了FilterChain调用了doFilter()方法,则容器会继续向后调用(例如执行servlet),否则中断请求,响应处理结果
	 * 
	 */
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		System.out.println("过滤开始了");
		//设置请求参数的字符集
		req.setCharacterEncoding("utf-8");
		//设置响应的类型和字符集
		res.setContentType("text/html;charset=utf-8");
		//在过滤器中获取参数
		String data=req.getParameter("con");
		
		if(data.contains("卧槽")||data.contains("我日")){//被过滤，不能进入servlet
			res.getWriter().print("请使用文明用语");
		}else{//否则通过
			chain.doFilter(req, res);
			System.out.println("过滤结束了");
		}
				
		
		
	}

	@Override
	//销毁（关闭容器可销毁过滤器）
	public void destroy() {
		
		System.out.println("销毁过滤器");
	}

}
