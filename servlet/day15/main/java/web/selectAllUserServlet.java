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
 * 根据分页查询用户数据(默认是第一页)
 */
public class selectAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	try {
    		//设置响应类和字符集
       	 res.setContentType("text/html;utf-8");
       	 Map<String,Object> map=new HashMap<String,Object>();
       	 UserDao dao=new UserDaoImpl();
       	 //当前页数
       	 int page=1;//默认等录成功后显示第一页 
       	 //3.总页数
       	 /*
       	  * 总页数需要那些数据？
       	  * 数据库查询的总量/每页显示的数量==0？数据库查询的总量/每页显示的熟量:数据库查询的总量/每页显示的熟量+1
       	  */
       	 int size=3;//每页显示的条数
       	 //绑定数据，方便给上一页和下一页使用
       	 req.getSession().setAttribute("size", size);
       	 //查询用户的总数量
       	 int countRow=dao.selectUserAll();
       	 
       	 //求总页数
       	 int pageAll=countRow%size==0? countRow/size:(countRow/size)+1;
    	 //绑定数据，方便给上一页和下一页使用
       	 req.getSession().setAttribute("pageAll", pageAll);
    	 //根据调用dao层查分页询所有用户数据
       	//起始位置
       	 int start=0;
       	 List<User> list=dao.findAllUserData(start,size);
       	 map.put("list", list);
       	 map.put("page", page);
       	 map.put("pageAll", pageAll);
       	 
       	 req.getSession().setAttribute("map", map);
       	 //重定向
       	 res.sendRedirect(req.getContextPath()+"/listUsers.jsp");
       	 
		} catch (Exception e) {
			throw new RuntimeException("系统维护");
		}
    }
    

}
