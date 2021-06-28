package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

/**
 * �����û�id�޸��û�����
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	
    	res.setContentType("text/html;charset=utf-8");
    	PrintWriter pw=res.getWriter();
    	
    	
    	try {
    		//������������ı����ʽ
        	req.setCharacterEncoding("utf-8");
        	//��ȡ�û�����
        	int id=Integer.parseInt(req.getParameter("id"));
        	String userName=req.getParameter("uname");
        	String userEmail=req.getParameter("email");
        	String userPhone=req.getParameter("phone");
        	String userPwd=req.getParameter("updatePwd");
        	String userConfirm=req.getParameter("confrimPwd");
        	
        	if(userName==null||userName.trim().isEmpty()){
        		throw new RuntimeException("�û�������Ϊ��!");
        	}
        	if(userPwd==null||userPwd.trim().isEmpty()){
        		throw new RuntimeException("���벻��Ϊ��!");
        	}
        	//���ܺ�������ȷ������
        	String md5Pwd=DigestUtils.md5Hex(userPwd+"����");
        	String md5PwdConfirm=DigestUtils.md5Hex(userConfirm+"����");
        	if(!md5Pwd.equals(md5PwdConfirm)){//�ж��޸������ȷ�������Ƿ�һ��
        		throw new RuntimeException("���벻һ��");
        		
        	}
        	//����dao��
        	UserDao dao=new UserDaoImpl();
        	User user=new User(id,userName,md5Pwd,userEmail,userPhone);
        	dao.updateUser(user);
        	
        	//�ض���find
        	res.sendRedirect("find");
		} catch (Exception e) {
			String message=e.getMessage();
			if(message.equals("�û�������Ϊ��")){
				pw.print(message);
			}else if(message.equals("���벻��Ϊ��")){
				pw.print(message);
			}else if(message.equals("���벻һ��")){
				pw.print(message);
			}else{
				pw.print(message);
			}
			
			
		}
    		
    	
    }

}
