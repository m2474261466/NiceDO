package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
                //������list
                req.setAttribute("list", list);
                //��ȡת����
                RequestDispatcher rd=req.getRequestDispatcher("listUsers.jsp");
                //ת��
                rd.forward(req, res);
               /* res.sendRedirect("listUser.jsp");*/
			} catch (Exception e) {
				String message=e.getMessage();
				req.setAttribute("meg", message);
		        req.setAttribute("message", message);
		        req.getRequestDispatcher("login.jsp").forward(req, res);
			}
        	
        }
}
