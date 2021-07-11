package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * �����������൱�ڼ���sessionid�ĸ�����
 * ������������Ҫʵ��һ���ӿ�
 * @author 24742
 *
 */
public class ListenerCommon  implements HttpSessionListener{
      public ListenerCommon(){
    	  System.out.println("������ʵ����");
      }
      /*.
       *session���󴴽���ִ��sessionCreated(HttpSessionEvent se)����
       *se�����¼����� 
       * @param se
       */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//1.ͨ��HttpSessionEvent�¼�Դ����ȡsession
		HttpSession session=se.getSession();
		session.setMaxInactiveInterval(10);
		//2.ͨ��HttpSession��ȡ������
		ServletContext sc=session.getServletContext();
		//3.ͨ��ServletContext�����ݲ��һ�ȡ��������
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
		 * ʲôʱ����������٣�
		 * sessionid����֮������
		 */
		System.out.println("������������");
		
		
		
	}

}
