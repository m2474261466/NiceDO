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
 * 商品控制层
 * @author Lenovo
 *
 */
@Controller
@RequestMapping("good")
public class GoodController  extends HandlerException{
	// 将业务层注入进来
	@Autowired
	private GoodsService service;
	@Autowired
	private GoodsMapper mapper;
	
	/** 四级商品页面 */
	@RequestMapping("searchHTML.do")
	public String searchHtml(HttpSession session,String id,ModelMap model){
		// 三级商品id
		Long cid = Long.valueOf(id);
		// 用session绑定id
		session.setAttribute("cid", cid);
		// 获取四级分类商品	
		PageObject page = new PageObject();
		Map<String,Object> map = service.findGoodsByCategoryId(cid, page);
		model.addAttribute("map", map);		
		return "search";
	}
	
	/** 下一页功能 */
	@RequestMapping("nextpage.do")
	public String nextpage(ModelMap model,HttpSession session,PageObject page){
		// 获取三级商品id
		Long cid = (Long)session.getAttribute("cid");
		// 获取当前页数
		int pageCurrent = page.getPageCurrent();
		// 获取记录数
		int rowCount = mapper.findGoodsNumByCategoryId(cid);
		page.setRowCount(rowCount);	
		// 获取总页数
		int pageCount = page.getPageCount();	
		// 如果当前页数是总页数，把页数还是设置为当前页数
		if(pageCurrent == pageCount){
			pageCurrent = pageCount;
		}else{// 反之，页数自增
			pageCurrent++;
		}
		// 并将当前页数更新
		page.setPageCurrent(pageCurrent);
		Map<String,Object> map = service.findGoodsByCategoryId(cid, page);
		model.addAttribute("map", map);
		return "search";
	}
	
	/** 上一页功能 */
	@RequestMapping("toppage.do")
	public String toppage(ModelMap model,HttpSession session,PageObject page){
		// 获取三级商品id
		Long cid = (Long)session.getAttribute("cid");
		// 获取当前页数
		int pageCurrent = page.getPageCurrent();
		// 获取记录数
		int rowCount = mapper.findGoodsNumByCategoryId(cid);
		page.setRowCount(rowCount);	
		// 如果当前页数是1，把页数还是设置为第1页
		if(pageCurrent == 1){
			pageCurrent = 1;
		}else{// 反之，页数自减
			pageCurrent--;
		}
		// 并将当前页数更新
		page.setPageCurrent(pageCurrent);
		Map<String,Object> map = service.findGoodsByCategoryId(cid, page);
		model.addAttribute("map", map);
		return "search";
	}
	
	/** 根据页数获取对应的页面 */
	@RequestMapping("getpage.do")
	public String getpage(ModelMap model,HttpSession session,PageObject page){
		// 获取三级商品id
		Long cid = (Long)session.getAttribute("cid");
		Map<String,Object> map = service.findGoodsByCategoryId(cid, page);
		model.addAttribute("map", map);
		return "search";
	}
	
	/** 商品详情页 */
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
