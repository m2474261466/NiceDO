package web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

/**
 *��ʾ��ǰҳ��������
 */
public class nowPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	 try {
           	 Map<String,Object> map=new HashMap<String,Object>();
           	 //1.��ȡ��ǰҳ��
           	 int page=Integer.parseInt(req.getParameter("page"));
           	 int pageAll=(Integer)req.getSession().getAttribute("pageAll");
           	
           	 //ÿҳ��ʾ������
           	 int size=(Integer)req.getSession().getAttribute("size");
           	 //֪����ǰҳ�����������ʼҳ��
           	int start=(page-1)*size;
           	//2.����dao
           	UserDao dao=new UserDaoImpl();
           	List<User> list=dao.findAllUserData(start, size);
           	//��ȡ��ҳ��
           	
           	map.put("list", list);
           	map.put("page",page);
           	map.put("pageAll", pageAll);
           	req.getSession().setAttribute("map", map);
           	res.sendRedirect(req.getContextPath()+"/listUsers.jsp");
    		} catch (Exception e) {
    			// TODO: handle exception
    		}
    }
     

}
