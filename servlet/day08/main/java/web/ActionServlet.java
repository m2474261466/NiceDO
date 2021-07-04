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
    	 //��ȡ��Դ·��
    	String uri=req.getRequestURI();
    	if(uri.endsWith("/toRegister.do")){
    		System.out.println("ע��ҵ��");
    		HttpServlet servlet=new RigsterServlet();
    		servlet.service(req, res);
    	}else if(uri.endsWith("/toLogin.do")){
    		System.out.println("��¼ҵ��");
    		login(req,res);
    	}else if(uri.endsWith("/find.do")){
    		find(req,res);
    		System.out.println("����ҵ��");
    	}else if(uri.endsWith("/updateById.do")){
    		updateById(req,res);
    		System.out.println("����id����ҵ��");
    	}else if(uri.endsWith("/toUpdate.do")){
    		toUpdate(req,res);
    		System.out.println("�޸�ҵ��");
    	}else if(uri.endsWith("/toDelete.do")){
    	     delete(req,res);
    	     System.out.println("ɾ��ҵ��");
    	}
    }

	private void delete(HttpServletRequest req, HttpServletResponse res) {
		try {
    		//��ȡ�������id
        	String str=req.getParameter("id");
        	if(str==null||str==""){
        		throw new RuntimeException("�û�id������");
        		}
        	int id=Integer.parseInt(str);
        	UserDao dao=new UserDaoImpl();
        	dao.deleteUserById(id);
        	//�ض���listUser.jsp
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
        	res.sendRedirect(req.getContextPath()+"/find.do");
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

	private void updateById(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			//��ȡsession����
	     	  User user=(User)req.getSession().getAttribute("user");
	     	  if(user==null){//û�е�¼,���ض��򵽵�¼ҳ��
	     		  res.sendRedirect(req.getContextPath()+"/login.jsp");
	     		  return;
	     	  }
     	   //��ȡ�û���id
        	int id=Integer.parseInt(req.getParameter("id"));
        	//System.out.println(id);
        	//ͨ���û�id��ѯ�û�����
        	UserDao dao=new UserDaoImpl();
        	user=dao.findUserById(id);
        	//��user����
        	req.setAttribute("user", user);
        	//��ȡת������ת��
        	req.getRequestDispatcher("updateUser.jsp").forward(req, res);
		} catch (Exception e) {
			req.setAttribute("message", e.getMessage());
			req.getRequestDispatcher("updateUser.jsp").forward(req, res);
		}
		
	}

	private void find(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw= null;
     	try {
     	
     		
     		//�жϸ��û��Ƿ��¼����û�е�¼���ض��򵽵�¼ҳ��
     		HttpSession session=req.getSession();
     		User user=(User)session.getAttribute("user");
     		if(user==null){//û�е�¼�ض��򵽵�¼ҳ��
     			res.sendRedirect(req.getContextPath()+"/login.jsp");
     			return;
     		}
     		System.out.println("�¸�");
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

	private void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
      	User user=dao.userLogin(userName, md5Pwd);
      	//System.out.println("��������"+user);
      	if(user.getUserName()!=null&&user.getUserPwd()!=null){//��¼�ɹ�
      		//���û�����
      		HttpSession session=req.getSession();
      		session.setAttribute("user", user);
      		
      		      		//ת�����û���ѯҳ��
      //	req.getRequestDispatcher("").forward(req, res);
      		//�ض��򵽲�ѯ�û�����ҳ��
      		res.sendRedirect(req.getContextPath()+"/find.do");
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

	private void register(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
            	  res.sendRedirect(req.getContextPath()+"/login.jsp");
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
