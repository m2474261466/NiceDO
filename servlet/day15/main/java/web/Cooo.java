package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Cooo extends SimpleTagSupport {
    private String pattern;
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	@Override
	public void doTag() throws JspException, IOException {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		String s=sdf.format(date);
		JspContext js=getJspContext();
		JspWriter out=js.getOut();
		out.print(s);
		
	}
    
}
