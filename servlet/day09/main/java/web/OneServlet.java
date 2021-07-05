package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet的生命周期
 * 1.什么是servlet的生命周期?
 * Servlet容器创建Servlet对象,到Servlet对象销毁这个过程称之为Servlet生命周期.
 * 2.生命周期如下:
 * 2-1:
 *  a.什么时候实例化？
 *  
 *  情况1:容器收到请求后创建Servlet对象
 *  情况2:启动容器之后立即创建Servlet对象(需要配置文件)
 *     以上两种情况容器调用Servlet的构造器创建对象
 *  b.创建几个实例?
 *    容器只创建了一个实例。
 * 2-2:初始化
 *    a:什么是初始化?
 *    容器调用servlet的init方法(该方法只执行了一次)
 *    b:GenericServlet已经提供了init方法的实现
 *    c:如何实现自己的初始化处理逻辑?
 *      只要重写GenericServlet的init方法(不带有参数的init方法)
 *    d:初始化参数
 *      1.配置初始化参数
 *      2.使用servletConfig提供的genInitParameter方法来读取初始化参数
 * 2-3:就绪(调用service方法)
 *    容器收到请求之后调用servlet的service方法来请求处理
 * 2-4:销毁
 * GenericServlet提供的destroy方法在容器删除servlet对象之前会调用destroy方法来实现销毁功能
 *  
 *  
 *  总结:分为四部分 ,顺序:实例化-->初始化-->就绪-->销毁
 */
public class OneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//创建Servlet实例
	//只有一个实例  创建了一个实例对象
     public OneServlet(){
    	 System.out.println("创建了OneServlet对象");
     }
     //2.通过重写GenericServlet的init方法来实现该Servlet的初始化
     //一个对象的初始化方法 也是一次
     public void init() throws ServletException {
        System.out.println("OneServlet的初始化");
        //获取局部初始化参数
        String value=getInitParameter("userName");
        System.out.println(value);
     }
     //3.调用service方法
     //这是业务代码 请求几次 调几次
     @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("OneServlet中的service方法");
    }
     //4.销毁:通过重写GenericServlet类中的destroy方法来实现销毁
     @Override
     public void destroy() {
       System.out.println("该servlet对象被销毁");
     }
     //获取全局的初始化参数
     //有参数的先执行有参数的   public void init(ServletConfig config) throws ServletException  
     //后执行无参数的getInitParameter("userName");
     
     @Override
    public void init(ServletConfig config) throws ServletException {
    	String value=config.getServletContext().getInitParameter("password");
       System.out.println("全局的参数"+value);
     }
}
