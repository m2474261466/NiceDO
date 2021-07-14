package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 如果要写一个标签类需要我们实现SimpleTagSupport
 * @author 24742
 *
 */
public class MyDateTag extends SimpleTagSupport {
	private String pattern;
	//写标签类必须要写set方法
	public void setPattern(String pattern) {
		//测试
		System.out.println("110,sets");
		this.pattern = pattern;
	}
	@Override
	public void doTag() throws JspException, IOException {
		//获取当前日期
	Date date=new Date();
	//日期转换格式
	SimpleDateFormat sdf=new SimpleDateFormat(pattern);
	String d=sdf.format(date);
	//获取jsp上下文( 父类提供的getJspContext() )
	JspContext jc=getJspContext();
	//获取jsp上下文的输出流
	JspWriter out=jc.getOut();
	//输出改内容
	out.print(d);	
	
	}
	

}
