package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet线程安全问题(面试题)
 * 1.为什么说Servlet会有线程安全问题?
 *   a.容器只会创建一个Servlet实例
 *   b.容器收到一个请求,就会启动一个线程,由这个线程来调用Servlet实例来处理请求,
 *   这样的话就有可能会有多个线程同时调用servlet实例
 * 2.如何解决Servlet线程安全问题？
 * 使用 synchronized同步锁对有可能产生线程安全问题的代码块加锁，在这里注意，性能之后会影响性能
 */
public class synchronizedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      //需要在可能在线程安全问题的代码块加锁，例如：用户购买商品
    	synchronized(this){
    		//用户购买商品业务
    	}
    	
    }

}
