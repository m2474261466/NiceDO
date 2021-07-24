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
 *显示当前页数的数据
 */
public class nowPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	 try {
           	 Map<String,Object> map=new HashMap<String,Object>();
           	 //1.获取当前页数
           	 int page=Integer.parseInt(req.getParameter("page"));
           	 int pageAll=(Integer)req.getSession().getAttribute("pageAll");
           	
           	 //每页显示的条数
           	 int size=(Integer)req.getSession().getAttribute("size");
           	 //知道当前页数如何设置起始页数
           	int start=(page-1)*size;
           	//2.调用dao
           	UserDao dao=new UserDaoImpl();
           	List<User> list=dao.findAllUserData(start, size);
           	//获取总页数
           	
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
