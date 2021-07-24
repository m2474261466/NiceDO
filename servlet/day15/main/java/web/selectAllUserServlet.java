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
 * ���ݷ�ҳ��ѯ�û�����(Ĭ���ǵ�һҳ)
 */
public class selectAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	try {
    		//������Ӧ����ַ���
       	 res.setContentType("text/html;utf-8");
       	 Map<String,Object> map=new HashMap<String,Object>();
       	 UserDao dao=new UserDaoImpl();
       	 //��ǰҳ��
       	 int page=1;//Ĭ�ϵ�¼�ɹ�����ʾ��һҳ 
       	 //3.��ҳ��
       	 /*
       	  * ��ҳ����Ҫ��Щ���ݣ�
       	  * ���ݿ��ѯ������/ÿҳ��ʾ������==0�����ݿ��ѯ������/ÿҳ��ʾ������:���ݿ��ѯ������/ÿҳ��ʾ������+1
       	  */
       	 int size=3;//ÿҳ��ʾ������
       	 //�����ݣ��������һҳ����һҳʹ��
       	 req.getSession().setAttribute("size", size);
       	 //��ѯ�û���������
       	 int countRow=dao.selectUserAll();
       	 
       	 //����ҳ��
       	 int pageAll=countRow%size==0? countRow/size:(countRow/size)+1;
    	 //�����ݣ��������һҳ����һҳʹ��
       	 req.getSession().setAttribute("pageAll", pageAll);
    	 //���ݵ���dao����ҳѯ�����û�����
       	//��ʼλ��
       	 int start=0;
       	 List<User> list=dao.findAllUserData(start,size);
       	 map.put("list", list);
       	 map.put("page", page);
       	 map.put("pageAll", pageAll);
       	 
       	 req.getSession().setAttribute("map", map);
       	 //�ض���
       	 res.sendRedirect(req.getContextPath()+"/listUsers.jsp");
       	 
		} catch (Exception e) {
			throw new RuntimeException("ϵͳά��");
		}
    }
    

}
