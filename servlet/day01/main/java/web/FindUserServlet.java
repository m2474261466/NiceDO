package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

public class FindUserServlet extends HttpServlet {
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        	 PrintWriter pw= null;
        	try {
        		//������Ӧ���ͺ��ַ���
                res.setContentType("text/html;charset=utf-8");
                //��ȡ�����
               pw=res.getWriter();
                //����Dao������
                UserDao dao=new UserDaoImpl();
                List<User> list=dao.findAllUserData();
                pw.println("<table width=60% cellpadding=0 border=2>");
                pw.println("<tr><th>ID</th><th>�û���</th><th>����</th><th>�绰</th><th>����</th></tr>");
                for(User u:list){
             	   pw.println("<tr>"
             	   		+ "<td>"+u.getId()+"</td>"
             	   		+ "<td>"+u.getUserName()+"</td>"
             	   		+ "<td>"+u.getUserEmail()+"</td>"
             	   		+"<td>"+u.getUserPhone()+"</td>"
             	   		+"<td>ɾ��</td>"
             	   		+ "</tr>");
                }
                pw.print("</table>");
             
			} catch (Exception e) {
				String message=e.getMessage();
				pw.print(message);
			}
        	
        }
}
