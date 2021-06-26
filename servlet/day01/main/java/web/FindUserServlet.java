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
        		//设置响应类型和字符集
                res.setContentType("text/html;charset=utf-8");
                //获取输出流
               pw=res.getWriter();
                //调用Dao层数据
                UserDao dao=new UserDaoImpl();
                List<User> list=dao.findAllUserData();
                pw.println("<table width=60% cellpadding=0 border=2>");
                pw.println("<tr><th>ID</th><th>用户名</th><th>邮箱</th><th>电话</th><th>操作</th></tr>");
                for(User u:list){
             	   pw.println("<tr>"
             	   		+ "<td>"+u.getId()+"</td>"
             	   		+ "<td>"+u.getUserName()+"</td>"
             	   		+ "<td>"+u.getUserEmail()+"</td>"
             	   		+"<td>"+u.getUserPhone()+"</td>"
             	   		+"<td>删除</td>"
             	   		+ "</tr>");
                }
                pw.print("</table>");
             
			} catch (Exception e) {
				String message=e.getMessage();
				pw.print(message);
			}
        	
        }
}
