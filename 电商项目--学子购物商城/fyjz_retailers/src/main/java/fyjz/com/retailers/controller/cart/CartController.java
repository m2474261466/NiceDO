package fyjz.com.retailers.controller.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fyjz.com.retailers.commons.HandlerException;
import fyjz.com.retailers.commons.JsonResult;
import fyjz.com.retailers.entity.Cart;
import fyjz.com.retailers.entity.Goods;
import fyjz.com.retailers.entity.User;
import fyjz.com.retailers.service.cart.CartService;

/**
 * 购物车控制层
 * @author Lenovo
 *
 */
@Controller
@RequestMapping("cart")
public class CartController extends HandlerException{
	@Autowired
	private CartService service;
	
	/** 添加商品到购物车 */
	@RequestMapping("addGoodData.do")
	@ResponseBody
	public JsonResult<Integer> addGoodData(HttpSession session,Cart cart){
		// 获取用户id
		User user = (User)session.getAttribute("user");
		// 如果user是null（也就是没有登录），则抛出异常
		if(user == null){
			throw new RuntimeException("sessionId过期~");
		}		
		int uid = user.getId();
		cart.setUserId(uid);
		int n = service.addCartService(cart);
		return new JsonResult<Integer>(n);
	}
	
	/** 购物车详情页 */
	@RequestMapping("toCartHTML.do")
	public String toCartHTML(Cart cart,ModelMap model,HttpSession session){
		// 获取用户id
		User user = (User)session.getAttribute("user");
		// 如果user是null（也就是没有登录），则抛出异常
		if(user == null){
			throw new RuntimeException("sessionId过期~");
		}
		int uid = user.getId();
		cart.setUserId(uid);
		List<Cart> cartList = service.findCartByUserIdService(uid);
		model.addAttribute("cartList", cartList);
		session.setAttribute("cartItems", cartList);
		return "cart";
	}
	
	/** 根据购物车id删除购物车商品 */
	@RequestMapping("deleteCart.do")
	public String toDeleteCart(int itemId,ModelMap model){
		service.deleteCartByIdService(itemId);
		return "redirect:toCartHTML.do";
	}
	
	/** 批量删除购物车商品 */
	@RequestMapping("deleteCartItemsId.do")
	public String deleteCartItemsId(String itemIds){
		service.deleteCartItemsService(itemIds);
		return "redirect:toCartHTML.do";
	}

	/** 确认信息 */
	@RequestMapping("toConfirmHTML.do")
	public String toConfirmHTML(Cart cart,ModelMap model,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		List<Cart> list = (List<Cart>)session.getAttribute("cartItems");
		map.put("list", list);
		model.addAttribute("map",map);
		return "orderConfirm";
	}
	
	/** 商品收货页面 */
	@RequestMapping("orderHTML.do")
	public String orders(HttpSession session,ModelMap model){
		service.updateCartItemsNumservice(session);
		List<Cart> list = (List<Cart>)session.getAttribute("cartItems");
		model.addAttribute("list", list);
		return "orders";
	}
	@RequestMapping("careHTML.do")
	public  String careHTML(){
		return "favorites";
	}
	
}
