package web;
/**
 * �û���¼
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import dao.UserDao;
import dao.UserDaoImpl;

public class LoginServlet extends HttpServlet {
              @Override
            protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            	try {
            		//���������ַ���
              	  req.setCharacterEncoding("utf-8");
              	  //������Ӧ���ַ�������Ӧ����
              	res.setContentType("text/html;charset=utf-8");
              	//��ȡ�û��ύ����
              	String userName=req.getParameter("uname");
              	String userPwd=req.getParameter("pwd");
              	if(userName==null||userName.trim().isEmpty()){
            		throw new RuntimeException("�û�������Ϊ��!");
            	}
            	if(userPwd==null||userPwd.trim().isEmpty()){
            		throw new RuntimeException("���벻��Ϊ��!");
            	}
            	
              	//�ж��û��Ƿ��¼�ɹ�
              	UserDao dao=new UserDaoImpl();
              	String str="����";
              	String md5Pwd=DigestUtils.md5Hex(userPwd+str);
              	int count=dao.userLogin(userName, md5Pwd);
              	if(count>0){//��¼�ɹ�
              		//ת�����û���ѯҳ��
              //	req.getRequestDispatcher("").forward(req, res);
              		//�ض��򵽲�ѯ�û�����ҳ��
              		res.sendRedirect("find");
	              	}else{
	              		throw new RuntimeException("�û������������");
	              	}
				} catch (Exception e) {
					String message=e.getMessage();
					
					if(message.equals("�û�������Ϊ��")){
                	    req.setAttribute("mes_name", message);
                	   }else if(message.equals("���벻��Ϊ��")){
                	    req.setAttribute("mes_pwd", message);
                	   }else{
                   	    req.setAttribute("message", message);
                   	   }  
                   	   
                   	   // ��ȡת������ת��
                   	   req.getRequestDispatcher("login.jsp").forward(req, res);
                   	   }
				}
            	
            }

