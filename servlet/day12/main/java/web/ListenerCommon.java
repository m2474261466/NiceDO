package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听器：（相当于监听sessionid的个数）
 * 被监听的类需要实现一个接口
 * @author 24742
 *
 */
public class ListenerCommon  implements HttpSessionListener{
      public ListenerCommon(){
    	  System.out.println("监听器实例化");
      }
      /*.
       *session对象创建后执行sessionCreated(HttpSessionEvent se)方法
       *se就是事件对象 
       * @param se
       */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//1.通过HttpSessionEvent事件源来获取session
		HttpSession session=se.getSession();
		session.setMaxInactiveInterval(10);
		//2.通过HttpSession获取上下文
		ServletContext sc=session.getServletContext();
		//3.通过ServletContext绑定数据并且获取在线人数
		Integer count=(Integer)sc.getAttribute("count");
		if(count==null){
			count=1;
		}else{
			count++;
		}
		sc.setAttribute("count", count);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		/*
		 * 什么时候监听器销毁？
		 * sessionid过期之后销毁
		 */
		System.out.println("监听器被销毁");
		
		
		
	}

}
