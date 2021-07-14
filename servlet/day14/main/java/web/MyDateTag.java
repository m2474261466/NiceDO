package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * ���Ҫдһ����ǩ����Ҫ����ʵ��SimpleTagSupport
 * @author 24742
 *
 */
public class MyDateTag extends SimpleTagSupport {
	private String pattern;
	//д��ǩ�����Ҫдset����
	public void setPattern(String pattern) {
		//����
		System.out.println("110,sets");
		this.pattern = pattern;
	}
	@Override
	public void doTag() throws JspException, IOException {
		//��ȡ��ǰ����
	Date date=new Date();
	//����ת����ʽ
	SimpleDateFormat sdf=new SimpleDateFormat(pattern);
	String d=sdf.format(date);
	//��ȡjsp������( �����ṩ��getJspContext() )
	JspContext jc=getJspContext();
	//��ȡjsp�����ĵ������
	JspWriter out=jc.getOut();
	//���������
	out.print(d);	
	
	}
	

}
