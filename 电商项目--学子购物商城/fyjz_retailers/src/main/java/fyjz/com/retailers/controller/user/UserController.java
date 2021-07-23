package fyjz.com.retailers.controller.user;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sun.swing.internal.plaf.basic.resources.basic;
import fyjz.com.retailers.commons.HandlerException;
import fyjz.com.retailers.commons.JsonResult;
import fyjz.com.retailers.entity.GoodsCategory;
import fyjz.com.retailers.entity.User;
import fyjz.com.retailers.service.goodsCategory.GoodsCategoryService;
import fyjz.com.retailers.service.user.UserService;
/**
 * 控制层
 * @author Lenovo
 *
 */
@Controller
@RequestMapping("user")
public class UserController extends HandlerException{
	// 将业务层注入进来 
	@Autowired
	private UserService service;
	// 将商品业务层注入进来
	@Autowired
	private GoodsCategoryService categoryService;

	/** 注册页面 */
	@RequestMapping("toRegisterHTML.do")
	public String toRegisterHTML(){
		return "register";
	}
		
	/** 校验名字 */
	@RequestMapping("tocheckName.do")
	@ResponseBody
	public JsonResult<Integer>  tocheckName(String name){
		int n = service.findNumByName(name);
		return new JsonResult<Integer>(n);
	}
	
	/** 用户注册 */
	@RequestMapping("toRegister.do")
	@ResponseBody
	public JsonResult<Boolean> toRegister(User user){
		boolean b = service.addUserService(user);
		return new JsonResult<Boolean>(b);
	}
	
	/** 登录页面 */
	@RequestMapping("toLoginHTML.do")
	public String toLoginHTML(){
		return "login";
	}
	
	public byte[] createImage(String code) throws IOException{
		// 创建BufferedImage
		BufferedImage img = new BufferedImage(100,40,BufferedImage.TYPE_3BYTE_BGR);
		// 创建画笔
		Graphics2D g = img.createGraphics();
		// 生成随机颜色
		Random random = new Random();
		// 方法1：随机数生成随机颜色
//		Color c = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)); 
		// 方法2：十六进制表示的随机颜色
		Color c = new Color(random.nextInt(0xFFFFFF));		
		// 给画笔设置随机颜色
		g.setColor(c);
		// 填充矩形区域(设置画笔画的范围),填充图片背景
		g.fillRect(0, 0, 100, 40);
		// 在框中生成500随机的点（并且是不同颜色）
		for(int i = 0;i<500;i++){
			img.setRGB(random.nextInt(100), random.nextInt(40), random.nextInt(0xFFFFFF));
		}
		// 生成干扰线
		for(int i = 0;i<10;i++){
			// 设置随机颜色
			g.setColor(new Color(random.nextInt(0xFFFFFF)));
			// 设置随机线的开始点和结束点坐标范围
			int x1 = random.nextInt(100);// 线的起点x坐标
			int y1 = random.nextInt(40);// 线的起点y坐标
			int x2 = random.nextInt(100);// 线的终点x坐标
			int y2 = random.nextInt(40);// 线的终点y坐标
			g.drawLine(x1, y1, x2, y2);
		}
		// 设置字体大小，Font.SANS_SERIF：一种通用字体；Font.PLAIN：标准
		Font font = new Font(Font.SANS_SERIF,Font.PLAIN,26);
		g.setFont(font);
		// 设置平滑抗锯齿绘制
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// 设置干扰线加粗效果
		g.setStroke(new BasicStroke(10.0f));
		// 设置随机颜色
		g.setColor(new Color(random.nextInt(0xFFFFFF)));
		g.drawString(code, 10, 30);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(img, "png", out);
		byte[] bytes = out.toByteArray();
		
		return bytes;
	}
	
	/** 生成验证码 
	 * @throws IOException */
	@RequestMapping(value="code.do",produces="image/png")
	@ResponseBody
	public byte[] code(HttpSession session) throws IOException{
		String code = getCode(4);
		// 绑定code
		session.setAttribute("code", code);
		byte[] imgByte = createImage(code);
		return imgByte;
	}
	
	// 生成不重复的数字
	public String getCode(int code){
		char[] arr = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
							'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
							'0','1','2','3','4','5','6','7','8','9'};
		boolean[] flag = new boolean[arr.length];
		char[] newArr = new char[4];
		for (int i = 0; i < newArr.length; i++) {
			int index;
			do{
				index = (int)(Math.random()*arr.length);
			}while(flag[index] == true);
			flag[index] = true;
			newArr[i] = arr[index];
		}
		return new String(newArr);
	}
	
	/** 用户登录 */
	@RequestMapping("toLogin.do")
	@ResponseBody
	public JsonResult<User> toLogin(String lname,String lwd,String code,HttpSession session){
		// 获取code
		String c = (String)session.getAttribute("code");
		// 校验验证码,equalsIgnoreCase忽略大小写
		if(!c.equalsIgnoreCase(code)){
			throw new RuntimeException("验证码错误！");
		}
		User user = (User)service.findUserByNameAndPwdService(lname,lwd);
		// 绑定用户数据
		session.setAttribute("user", user);
		return new JsonResult<User>(user);
	}
	
	/** 主页面 */
	/*
	 * ModelMap对象主要用于传递控制方式处理数据到结果页面
	 * 类似于request对象的setAttribute方法的作用
	 */
	@RequestMapping("toIndexHTML.do")
	public String toIndexHTML(HttpSession session,ModelMap model){
		// 获取user数据
		User user = (User)session.getAttribute("user");
		model.addAttribute("name", user); 
		
		// 获取分类商品
		Map<String,Object> map = categoryService.findgoodsCategoryByParentId(161L, 0, 3);
		model.addAttribute("map", map);
		
		Map<String,Object> map2 = categoryService.findgoodsCategoryByParentId(161L, 4, 3);
		model.addAttribute("map2", map2);
			 
		return "index";
	}
	@RequestMapping("toPersonage.do")
	public String toPersonage(){
		return "personage";
	}
	@RequestMapping("toPersonal_password.do")
	public String toPersonal_password(){
		return "personal_password";
	}
	 @RequestMapping("toUpload.do")
     @ResponseBody
     /*
      * MultipartFile获得附件的集合，它里面的技术含有JQuery.form.js框架以及
      * SpringMVC框架,主要实现异步文件上传的同时还封装对象;
      */
     public JsonResult<String> toUpload(MultipartFile file,HttpSession session) throws IllegalStateException, IOException{
  	   //获取真实路径
  	   String path=session.getServletContext().getRealPath("");
  	   //获取真实名字
  	  String filename=file.getOriginalFilename();
  	  //当前时间
  	  Date date=new Date();
  	  //这里如果是yyyy/MM/dd的话在服务器里是以路径的格式，如/upload/image/2020/6/20/xx.txt，
  	  //而yyyy-MM-dd则是以一个文件夹名字的方式出现如：/upload/image/2020-6-20/xx.txt
  	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
  	  String strData=sdf.format(date);
  	  //生成32位的随机散列码
  	  String d=UUID.randomUUID().toString();
  	  System.out.println(d);
  	  //存入数据库中的文件地址   这里相当于创建了两个目录一个upload一个image
  	  String url="/upload/image/"+strData+"/"+d+filename;
  	  //session绑定url
  	  session.setAttribute("url", url);
  	  //File(真实路径,存入服务器的地址)
  	  File f=new File(path,url);
  	  if(!f.exists()){//判断file文件是否存在，当添加了uuid时，文件名不一样可以重复，不添加uuid，则不可以重复
  		  f.mkdirs();
  	  }
  	  //进行图片上传
  	  file.transferTo(f);
  	  System.out.println("上传成功");
  	   return new JsonResult<String>(url);
     }	   
	
	 @RequestMapping("toUpdate.do")
	   public String toUpdate(User user){
		   service.updateUser(user);
		   return "redirect:toPersonage.do";
	   }
	

	 
	 
}
