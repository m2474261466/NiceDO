package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servletPath extends HttpServlet {
                 @Override
                protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
                	//��ȡ��������Դ·��
                	 StringBuffer path=req.getRequestURL();
                	 System.out.println(path);
                	 //��ȡ��Դ·��
                	 String uri=req.getRequestURI();
                	 System.out.println(uri);
                	 //��ȡ��ʵ·��
                String real= req.getServletContext().getRealPath("/");
                System.err.println(real);
                String s=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
                System.out.println(s);
               /* if("/tt".equals(s)){
                	System.out.println("ttҵ��");
                }else if("/tt2".equals(s)){
                	System.out.println("tt2ҵ��");
                }*/
                if(uri.endsWith("/tt.do")){
                	System.out.println("ttҵ��");
                }else if(uri.endsWith("/tt2.do")){
                	System.out.println("tt2ҵ��");
                }
           }
}
