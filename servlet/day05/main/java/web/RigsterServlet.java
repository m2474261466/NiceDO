package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

/**
  * �û�ע��ҵ��
  * @author 24742
  *
  */
public class RigsterServlet  extends  HttpServlet{
                    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
                        try {
                        	
                            //�����ַ���   
                        	req.setCharacterEncoding("utf-8");
                            //��ȡ�û����ݲ����û����ݷ�װ��user   
                        	res.setContentType("text/html;charset=utf-8");
                        	
                        	String userEmail=req.getParameter("email");
                        	String userName=req.getParameter("uname");
                        	String userPhone=req.getParameter("phone");
                        	String userPwd=req.getParameter("pwd");
                        	if(userName==null||userName.trim().isEmpty()){
                        		throw new RuntimeException("�û�������Ϊ��!");
                        	}
                        	if(userPwd==null||userPwd.trim().isEmpty()){
                        		throw new RuntimeException("���벻��Ϊ��!");
                        	}
                        	
                        	  //����DAO��
                            UserDao us=new UserDaoImpl();
                        	//�ж��û����Ƿ�ռ��
                             int count=us.selectUserByName(userName);
                        	 if(count>=1){
                        		 throw new RuntimeException("�û�����ռ��");
                        	 }
                        	 if(userName==null||userName.trim().isEmpty()){
                         		throw new RuntimeException("���벻��Ϊ��!");
                         	}
                        	 //���û��������MD5����
                        	 String str="����";
                        	 String md5Pwd=DigestUtils.md5Hex(userPwd+str);
                             
                        	 
                        	 //��װ�û������ݵ�������
                        	   User user=new User();
                               user.setUserEmail(userEmail);
                               user.setUserName(userName);
                               user.setUserPhone(userPhone);
                               user.setUserPwd(md5Pwd);
                               System.out.println(user);
                              
                               int n=us.registerUser(user);
                              if(n==1){
                            	  //ע��ɹ����ض��򵽵�¼ҳ��
                            	  res.sendRedirect("login.jsp");
                              }
                           } catch (Exception e) {
                        	   String message = e.getMessage();   
                        	   if(message.equals("�û�������Ϊ��")||message.equals("�û�����ռ��")){
                        	    req.setAttribute("mes_name", message);
                        	   }else if(message.equals("���벻��Ϊ��")){
                        	    req.setAttribute("mes_pwd", message);
                        	   }else{
                        	    req.setAttribute("message", message);
                        	   }  
                        	   
                        	   // ��ȡת������ת��
                        	   req.getRequestDispatcher("addUser.jsp").forward(req, res);
                        	   }
                        }
                    }