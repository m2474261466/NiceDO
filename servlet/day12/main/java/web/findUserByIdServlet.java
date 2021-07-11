package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;
/**
 * �����û�id��ѯ�û�����
 * @author 24742
 *
 */
public class findUserByIdServlet extends HttpServlet {
        protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
           try {
        	   //��ȡ�û���id
           	int id=Integer.parseInt(req.getParameter("id"));
           	//System.out.println(id);
           	//ͨ���û�id��ѯ�û�����
           	UserDao dao=new UserDaoImpl();
           	User user=dao.findUserById(id);
           	//��user����
           	req.setAttribute("user", user);
           	//��ȡת������ת��
           	req.getRequestDispatcher("updateUser.jsp").forward(req, res);
		} catch (Exception e) {
			req.setAttribute("message", e.getMessage());
			req.getRequestDispatcher("updateUser.jsp").forward(req, res);
		}
    }    
}
