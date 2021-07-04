package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;


public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	 //获取资源路径
    	String uri=req.getRequestURI();
    	if(uri.endsWith("/toRegister.do")){
    		System.out.println("注册业务");
    		HttpServlet servlet=new RigsterServlet();
    		servlet.service(req, res);
    	}else if(uri.endsWith("/toLogin.do")){
    		System.out.println("登录业务");
    		login(req,res);
    	}else if(uri.endsWith("/find.do")){
    		find(req,res);
    		System.out.println("查找业务");
    	}else if(uri.endsWith("/updateById.do")){
    		updateById(req,res);
    		System.out.println("根据id查找业务");
    	}else if(uri.endsWith("/toUpdate.do")){
    		toUpdate(req,res);
    		System.out.println("修改业务");
    	}else if(uri.endsWith("/toDelete.do")){
    	     delete(req,res);
    	     System.out.println("删除业务");
    	}
    }

	private void delete(HttpServletRequest req, HttpServletResponse res) {
		try {
    		//获取请求参数id
        	String str=req.getParameter("id");
        	if(str==null||str==""){
        		throw new RuntimeException("用户id不存在");
        		}
        	int id=Integer.parseInt(str);
        	UserDao dao=new UserDaoImpl();
        	dao.deleteUserById(id);
        	//重定向到listUser.jsp
        	res.sendRedirect(req.getContextPath()+"/find.do");
		} catch (Exception e) {
			String message=e.getMessage();
			System.out.println(message);
    	
        }
		
	}

	private void toUpdate(HttpServletRequest req, HttpServletResponse res) throws IOException {
		 
		res.setContentType("text/html;charset=utf-8");
    	PrintWriter pw=res.getWriter();
    	
    	
    	try {
    		//设置请求参数的编码格式
        	req.setCharacterEncoding("utf-8");
        	//获取用户参数
        	int id=Integer.parseInt(req.getParameter("id"));
        	String userName=req.getParameter("uname");
        	String userEmail=req.getParameter("email");
        	String userPhone=req.getParameter("phone");
        	String userPwd=req.getParameter("updatePwd");
        	String userConfirm=req.getParameter("confrimPwd");
        	
        	if(userName==null||userName.trim().isEmpty()){
        		throw new RuntimeException("用户名不能为空!");
        	}
        	if(userPwd==null||userPwd.trim().isEmpty()){
        		throw new RuntimeException("密码不能为空!");
        	}
        	//加密后的密码和确认密码
        	String md5Pwd=DigestUtils.md5Hex(userPwd+"西安");
        	String md5PwdConfirm=DigestUtils.md5Hex(userConfirm+"西安");
        	if(!md5Pwd.equals(md5PwdConfirm)){//判断修改密码和确认密码是否一致
        		throw new RuntimeException("密码不一致");
        		
        	}
        	//调用dao层
        	UserDao dao=new UserDaoImpl();
        	User user=new User(id,userName,md5Pwd,userEmail,userPhone);
        	dao.updateUser(user);
        	
        	//重定向find
        	res.sendRedirect(req.getContextPath()+"/find.do");
		} catch (Exception e) {
			String message=e.getMessage();
			if(message.equals("用户名不能为空")){
				pw.print(message);
			}else if(message.equals("密码不能为空")){
				pw.print(message);
			}else if(message.equals("密码不一致")){
				pw.print(message);
			}else{
				pw.print(message);
			}
			
			
		}
	}

	private void updateById(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			//获取session对象
	     	  User user=(User)req.getSession().getAttribute("user");
	     	  if(user==null){//没有登录,则重定向到登录页面
	     		  res.sendRedirect(req.getContextPath()+"/login.jsp");
	     		  return;
	     	  }
     	   //获取用户的id
        	int id=Integer.parseInt(req.getParameter("id"));
        	//System.out.println(id);
        	//通过用户id查询用户数据
        	UserDao dao=new UserDaoImpl();
        	user=dao.findUserById(id);
        	//绑定user数据
        	req.setAttribute("user", user);
        	//获取转发器并转发
        	req.getRequestDispatcher("updateUser.jsp").forward(req, res);
		} catch (Exception e) {
			req.setAttribute("message", e.getMessage());
			req.getRequestDispatcher("updateUser.jsp").forward(req, res);
		}
		
	}

	private void find(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw= null;
     	try {
     	
     		
     		//判断该用户是否登录，若没有登录则重定向到登录页面
     		HttpSession session=req.getSession();
     		User user=(User)session.getAttribute("user");
     		if(user==null){//没有登录重定向到登录页面
     			res.sendRedirect(req.getContextPath()+"/login.jsp");
     			return;
     		}
     		System.out.println("嘎嘎");
     		//设置响应类型和字符集
             res.setContentType("text/html;charset=utf-8");
             //获取输出流
            pw=res.getWriter();
             //调用Dao层数据
             UserDao dao=new UserDaoImpl();
             List<User> list=dao.findAllUserData();
             //绑定数据list
             req.setAttribute("list", list);
             //获取转发器
             RequestDispatcher rd=req.getRequestDispatcher("listUsers.jsp");
             //转发
             rd.forward(req, res);
            /* res.sendRedirect("listUser.jsp");*/
			} catch (Exception e) {
				String message=e.getMessage();
				req.setAttribute("meg", message);
		        req.setAttribute("message", message);
		        req.getRequestDispatcher("login.jsp").forward(req, res);
			}
     	
		
	}

	private void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
    		//设置请求字符集
      	  req.setCharacterEncoding("utf-8");
      	  //设置响应的字符集和响应类型
      	res.setContentType("text/html;charset=utf-8");
      	//获取用户提交数据
      	String userName=req.getParameter("uname");
      	String userPwd=req.getParameter("pwd");
      	if(userName==null||userName.trim().isEmpty()){
    		throw new RuntimeException("用户名不能为空!");
    	}
    	if(userPwd==null||userPwd.trim().isEmpty()){
    		throw new RuntimeException("密码不能为空!");
    	}
    	
      	//判断用户是否登录成功
      	UserDao dao=new UserDaoImpl();
      	String str="西安";
      	String md5Pwd=DigestUtils.md5Hex(userPwd+str);
      	User user=dao.userLogin(userName, md5Pwd);
      	//System.out.println("测试数据"+user);
      	if(user.getUserName()!=null&&user.getUserPwd()!=null){//登录成功
      		//绑定用户数据
      		HttpSession session=req.getSession();
      		session.setAttribute("user", user);
      		
      		      		//转发到用户查询页面
      //	req.getRequestDispatcher("").forward(req, res);
      		//重定向到查询用户数据页面
      		res.sendRedirect(req.getContextPath()+"/find.do");
          	}else{
          		throw new RuntimeException("用户名或密码错误");
          	}
		} catch (Exception e) {
			String message=e.getMessage();
			
			if(message.equals("用户名不能为空")){
        	    req.setAttribute("mes_name", message);
        	   }else if(message.equals("密码不能为空")){
        	    req.setAttribute("mes_pwd", message);
        	   }else{
           	    req.setAttribute("message", message);
           	   }  
           	   
           	   // 获取转发器并转发
           	   req.getRequestDispatcher("login.jsp").forward(req, res);
           	   }
		
	}

	private void register(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
        	
            //设置字符集   
        	req.setCharacterEncoding("utf-8");
            //获取用户数据并将用户数据封装到user   
        	res.setContentType("text/html;charset=utf-8");
        	
        	String userEmail=req.getParameter("email");
        	String userName=req.getParameter("uname");
        	String userPhone=req.getParameter("phone");
        	String userPwd=req.getParameter("pwd");
        	if(userName==null||userName.trim().isEmpty()){
        		throw new RuntimeException("用户名不能为空!");
        	}
        	if(userPwd==null||userPwd.trim().isEmpty()){
        		throw new RuntimeException("密码不能为空!");
        	}
        	
        	  //调用DAO层
            UserDao us=new UserDaoImpl();
        	//判断用户名是否被占用
             int count=us.selectUserByName(userName);
        	 if(count>=1){
        		 throw new RuntimeException("用户名被占用");
        	 }
        	 if(userName==null||userName.trim().isEmpty()){
         		throw new RuntimeException("密码不能为空!");
         	}
        	 //对用户密码进行MD5加密
        	 String str="西安";
        	 String md5Pwd=DigestUtils.md5Hex(userPwd+str);
             
        	 
        	 //封装用户的数据到对象中
        	   User user=new User();
               user.setUserEmail(userEmail);
               user.setUserName(userName);
               user.setUserPhone(userPhone);
               user.setUserPwd(md5Pwd);
               System.out.println(user);
              
               int n=us.registerUser(user);
              if(n==1){
            	  //注册成功，重定向到登录页面
            	  res.sendRedirect(req.getContextPath()+"/login.jsp");
              }
           } catch (Exception e) {
        	   String message = e.getMessage();   
        	   if(message.equals("用户名不能为空")||message.equals("用户名被占用")){
        	    req.setAttribute("mes_name", message);
        	   }else if(message.equals("密码不能为空")){
        	    req.setAttribute("mes_pwd", message);
        	   }else{
        	    req.setAttribute("message", message);
        	   }  
        	   
        	   // 获取转发器并转发
        	   req.getRequestDispatcher("addUser.jsp").forward(req, res);
        	   }
		
	}

}
