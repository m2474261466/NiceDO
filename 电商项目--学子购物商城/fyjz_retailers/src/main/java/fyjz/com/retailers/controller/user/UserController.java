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
 * ���Ʋ�
 * @author Lenovo
 *
 */
@Controller
@RequestMapping("user")
public class UserController extends HandlerException{
	// ��ҵ���ע����� 
	@Autowired
	private UserService service;
	// ����Ʒҵ���ע�����
	@Autowired
	private GoodsCategoryService categoryService;

	/** ע��ҳ�� */
	@RequestMapping("toRegisterHTML.do")
	public String toRegisterHTML(){
		return "register";
	}
		
	/** У������ */
	@RequestMapping("tocheckName.do")
	@ResponseBody
	public JsonResult<Integer>  tocheckName(String name){
		int n = service.findNumByName(name);
		return new JsonResult<Integer>(n);
	}
	
	/** �û�ע�� */
	@RequestMapping("toRegister.do")
	@ResponseBody
	public JsonResult<Boolean> toRegister(User user){
		boolean b = service.addUserService(user);
		return new JsonResult<Boolean>(b);
	}
	
	/** ��¼ҳ�� */
	@RequestMapping("toLoginHTML.do")
	public String toLoginHTML(){
		return "login";
	}
	
	public byte[] createImage(String code) throws IOException{
		// ����BufferedImage
		BufferedImage img = new BufferedImage(100,40,BufferedImage.TYPE_3BYTE_BGR);
		// ��������
		Graphics2D g = img.createGraphics();
		// ���������ɫ
		Random random = new Random();
		// ����1����������������ɫ
//		Color c = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)); 
		// ����2��ʮ�����Ʊ�ʾ�������ɫ
		Color c = new Color(random.nextInt(0xFFFFFF));		
		// ���������������ɫ
		g.setColor(c);
		// ����������(���û��ʻ��ķ�Χ),���ͼƬ����
		g.fillRect(0, 0, 100, 40);
		// �ڿ�������500����ĵ㣨�����ǲ�ͬ��ɫ��
		for(int i = 0;i<500;i++){
			img.setRGB(random.nextInt(100), random.nextInt(40), random.nextInt(0xFFFFFF));
		}
		// ���ɸ�����
		for(int i = 0;i<10;i++){
			// ���������ɫ
			g.setColor(new Color(random.nextInt(0xFFFFFF)));
			// ��������ߵĿ�ʼ��ͽ��������귶Χ
			int x1 = random.nextInt(100);// �ߵ����x����
			int y1 = random.nextInt(40);// �ߵ����y����
			int x2 = random.nextInt(100);// �ߵ��յ�x����
			int y2 = random.nextInt(40);// �ߵ��յ�y����
			g.drawLine(x1, y1, x2, y2);
		}
		// ���������С��Font.SANS_SERIF��һ��ͨ�����壻Font.PLAIN����׼
		Font font = new Font(Font.SANS_SERIF,Font.PLAIN,26);
		g.setFont(font);
		// ����ƽ������ݻ���
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// ���ø����߼Ӵ�Ч��
		g.setStroke(new BasicStroke(10.0f));
		// ���������ɫ
		g.setColor(new Color(random.nextInt(0xFFFFFF)));
		g.drawString(code, 10, 30);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(img, "png", out);
		byte[] bytes = out.toByteArray();
		
		return bytes;
	}
	
	/** ������֤�� 
	 * @throws IOException */
	@RequestMapping(value="code.do",produces="image/png")
	@ResponseBody
	public byte[] code(HttpSession session) throws IOException{
		String code = getCode(4);
		// ��code
		session.setAttribute("code", code);
		byte[] imgByte = createImage(code);
		return imgByte;
	}
	
	// ���ɲ��ظ�������
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
	
	/** �û���¼ */
	@RequestMapping("toLogin.do")
	@ResponseBody
	public JsonResult<User> toLogin(String lname,String lwd,String code,HttpSession session){
		// ��ȡcode
		String c = (String)session.getAttribute("code");
		// У����֤��,equalsIgnoreCase���Դ�Сд
		if(!c.equalsIgnoreCase(code)){
			throw new RuntimeException("��֤�����");
		}
		User user = (User)service.findUserByNameAndPwdService(lname,lwd);
		// ���û�����
		session.setAttribute("user", user);
		return new JsonResult<User>(user);
	}
	
	/** ��ҳ�� */
	/*
	 * ModelMap������Ҫ���ڴ��ݿ��Ʒ�ʽ�������ݵ����ҳ��
	 * ������request�����setAttribute����������
	 */
	@RequestMapping("toIndexHTML.do")
	public String toIndexHTML(HttpSession session,ModelMap model){
		// ��ȡuser����
		User user = (User)session.getAttribute("user");
		model.addAttribute("name", user); 
		
		// ��ȡ������Ʒ
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
      * MultipartFile��ø����ļ��ϣ�������ļ�������JQuery.form.js����Լ�
      * SpringMVC���,��Ҫʵ���첽�ļ��ϴ���ͬʱ����װ����;
      */
     public JsonResult<String> toUpload(MultipartFile file,HttpSession session) throws IllegalStateException, IOException{
  	   //��ȡ��ʵ·��
  	   String path=session.getServletContext().getRealPath("");
  	   //��ȡ��ʵ����
  	  String filename=file.getOriginalFilename();
  	  //��ǰʱ��
  	  Date date=new Date();
  	  //���������yyyy/MM/dd�Ļ��ڷ�����������·���ĸ�ʽ����/upload/image/2020/6/20/xx.txt��
  	  //��yyyy-MM-dd������һ���ļ������ֵķ�ʽ�����磺/upload/image/2020-6-20/xx.txt
  	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
  	  String strData=sdf.format(date);
  	  //����32λ�����ɢ����
  	  String d=UUID.randomUUID().toString();
  	  System.out.println(d);
  	  //�������ݿ��е��ļ���ַ   �����൱�ڴ���������Ŀ¼һ��uploadһ��image
  	  String url="/upload/image/"+strData+"/"+d+filename;
  	  //session��url
  	  session.setAttribute("url", url);
  	  //File(��ʵ·��,����������ĵ�ַ)
  	  File f=new File(path,url);
  	  if(!f.exists()){//�ж�file�ļ��Ƿ���ڣ��������uuidʱ���ļ�����һ�������ظ��������uuid���򲻿����ظ�
  		  f.mkdirs();
  	  }
  	  //����ͼƬ�ϴ�
  	  file.transferTo(f);
  	  System.out.println("�ϴ��ɹ�");
  	   return new JsonResult<String>(url);
     }	   
	
	 @RequestMapping("toUpdate.do")
	   public String toUpdate(User user){
		   service.updateUser(user);
		   return "redirect:toPersonage.do";
	   }
	

	 
	 
}
