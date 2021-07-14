package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	Employe emp=new Employe();
    	Address address=new Address("����","������");
    	emp.setAge(10000);
    	emp.setEname("������");
    	emp.setSalay(1000000);
    	emp.setEmpon(12);
    	emp.setaddress(address);
    	req.setAttribute("emp",emp);
    	//ת��
    	req.getRequestDispatcher("DemoEL02.jsp").forward(req,res);
    }
}
