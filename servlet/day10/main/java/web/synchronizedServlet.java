package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet�̰߳�ȫ����(������)
 * 1.Ϊʲô˵Servlet�����̰߳�ȫ����?
 *   a.����ֻ�ᴴ��һ��Servletʵ��
 *   b.�����յ�һ������,�ͻ�����һ���߳�,������߳�������Servletʵ������������,
 *   �����Ļ����п��ܻ��ж���߳�ͬʱ����servletʵ��
 * 2.��ν��Servlet�̰߳�ȫ���⣿
 * ʹ�� synchronizedͬ�������п��ܲ����̰߳�ȫ����Ĵ���������������ע�⣬����֮���Ӱ������
 */
public class synchronizedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      //��Ҫ�ڿ������̰߳�ȫ����Ĵ������������磺�û�������Ʒ
    	synchronized(this){
    		//�û�������Ʒҵ��
    	}
    	
    }

}
