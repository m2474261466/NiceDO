package fyjz.com.retailers.controller.goods;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import fyjz.com.retailers.commons.HandlerException;
import fyjz.com.retailers.commons.PageObject;
import fyjz.com.retailers.entity.Goods;
import fyjz.com.retailers.mapper.goods.GoodsMapper;
import fyjz.com.retailers.service.goods.GoodsService;

/**
 * ��Ʒ���Ʋ�
 * @author Lenovo
 *
 */
@Controller
@RequestMapping("good")
public class GoodController  extends HandlerException{
	// ��ҵ���ע�����
	@Autowired
	private GoodsService service;
	@Autowired
	private GoodsMapper mapper;
	
	/** �ļ���Ʒҳ�� */
	@RequestMapping("searchHTML.do")
	public String searchHtml(HttpSession session,String id,ModelMap model){
		// ������Ʒid
		Long cid = Long.valueOf(id);
		// ��session��id
		session.setAttribute("cid", cid);
		// ��ȡ�ļ�������Ʒ	
		PageObject page = new PageObject();
		Map<String,Object> map = service.findGoodsByCategoryId(cid, page);
		model.addAttribute("map", map);		
		return "search";
	}
	
	/** ��һҳ���� */
	@RequestMapping("nextpage.do")
	public String nextpage(ModelMap model,HttpSession session,PageObject page){
		// ��ȡ������Ʒid
		Long cid = (Long)session.getAttribute("cid");
		// ��ȡ��ǰҳ��
		int pageCurrent = page.getPageCurrent();
		// ��ȡ��¼��
		int rowCount = mapper.findGoodsNumByCategoryId(cid);
		page.setRowCount(rowCount);	
		// ��ȡ��ҳ��
		int pageCount = page.getPageCount();	
		// �����ǰҳ������ҳ������ҳ����������Ϊ��ǰҳ��
		if(pageCurrent == pageCount){
			pageCurrent = pageCount;
		}else{// ��֮��ҳ������
			pageCurrent++;
		}
		// ������ǰҳ������
		page.setPageCurrent(pageCurrent);
		Map<String,Object> map = service.findGoodsByCategoryId(cid, page);
		model.addAttribute("map", map);
		return "search";
	}
	
	/** ��һҳ���� */
	@RequestMapping("toppage.do")
	public String toppage(ModelMap model,HttpSession session,PageObject page){
		// ��ȡ������Ʒid
		Long cid = (Long)session.getAttribute("cid");
		// ��ȡ��ǰҳ��
		int pageCurrent = page.getPageCurrent();
		// ��ȡ��¼��
		int rowCount = mapper.findGoodsNumByCategoryId(cid);
		page.setRowCount(rowCount);	
		// �����ǰҳ����1����ҳ����������Ϊ��1ҳ
		if(pageCurrent == 1){
			pageCurrent = 1;
		}else{// ��֮��ҳ���Լ�
			pageCurrent--;
		}
		// ������ǰҳ������
		page.setPageCurrent(pageCurrent);
		Map<String,Object> map = service.findGoodsByCategoryId(cid, page);
		model.addAttribute("map", map);
		return "search";
	}
	
	/** ����ҳ����ȡ��Ӧ��ҳ�� */
	@RequestMapping("getpage.do")
	public String getpage(ModelMap model,HttpSession session,PageObject page){
		// ��ȡ������Ʒid
		Long cid = (Long)session.getAttribute("cid");
		Map<String,Object> map = service.findGoodsByCategoryId(cid, page);
		model.addAttribute("map", map);
		return "search";
	}
	
	/** ��Ʒ����ҳ */
	@RequestMapping("detailsHTML.do")
	public String detailsHTML(String id,ModelMap model){
		Goods good = service.findGoodsByIdService(id);
		model.addAttribute("good", good);
		return "product_details";
	}
	
	
	@RequestMapping("toHelpPage.do")
	public String toHelpPage(){
		return "help";
	}
	
	
	
	
	
	
}
