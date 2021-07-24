package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override

protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
   	 res.setContentType("text/html;charset=utf-8");
   try {
  	 String userName=req.getParameter("uname");
	 String userPwd=req.getParameter("pwd");
	 if(userName==null||userName.trim().isEmpty()){
		 throw new RuntimeException("�û�������ȷ");
	 }
	 if(userPwd==null||userPwd.trim().isEmpty()){
		 throw new RuntimeException("����δ��д");
	 }
	 String str="����";
	 String MdPwd=DigestUtils.md5Hex(userPwd+str);
	 UserDao ud=new UserDaoImpl();
	 User user=ud.userLogin(userName,MdPwd);
	 if(user==null){
		 throw new RuntimeException("�û��������벻��ȷ");
	 }else{
		 HttpSession session=req.getSession();
		 res.sendRedirect("select");
	 }
	} catch (Exception e) {
		String message=e.getMessage();
		if(message.equals("�û�������ȷ")||message.equals("�û��������벻��ȷ")){
			  req.setAttribute("mes_name", message);
		}else if(message.equals("����δ��д")){
			req.setAttribute("mes_pwd", message);
		}else{
			req.setAttribute("mes", message);
		}
		 req.getRequestDispatcher("login.jsp").forward(req, res);
		
	}
}
    

}
