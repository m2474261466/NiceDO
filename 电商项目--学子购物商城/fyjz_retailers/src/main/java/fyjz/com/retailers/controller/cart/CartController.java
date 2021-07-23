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
 * ���ﳵ���Ʋ�
 * @author Lenovo
 *
 */
@Controller
@RequestMapping("cart")
public class CartController extends HandlerException{
	@Autowired
	private CartService service;
	
	/** �����Ʒ�����ﳵ */
	@RequestMapping("addGoodData.do")
	@ResponseBody
	public JsonResult<Integer> addGoodData(HttpSession session,Cart cart){
		// ��ȡ�û�id
		User user = (User)session.getAttribute("user");
		// ���user��null��Ҳ����û�е�¼�������׳��쳣
		if(user == null){
			throw new RuntimeException("sessionId����~");
		}		
		int uid = user.getId();
		cart.setUserId(uid);
		int n = service.addCartService(cart);
		return new JsonResult<Integer>(n);
	}
	
	/** ���ﳵ����ҳ */
	@RequestMapping("toCartHTML.do")
	public String toCartHTML(Cart cart,ModelMap model,HttpSession session){
		// ��ȡ�û�id
		User user = (User)session.getAttribute("user");
		// ���user��null��Ҳ����û�е�¼�������׳��쳣
		if(user == null){
			throw new RuntimeException("sessionId����~");
		}
		int uid = user.getId();
		cart.setUserId(uid);
		List<Cart> cartList = service.findCartByUserIdService(uid);
		model.addAttribute("cartList", cartList);
		session.setAttribute("cartItems", cartList);
		return "cart";
	}
	
	/** ���ݹ��ﳵidɾ�����ﳵ��Ʒ */
	@RequestMapping("deleteCart.do")
	public String toDeleteCart(int itemId,ModelMap model){
		service.deleteCartByIdService(itemId);
		return "redirect:toCartHTML.do";
	}
	
	/** ����ɾ�����ﳵ��Ʒ */
	@RequestMapping("deleteCartItemsId.do")
	public String deleteCartItemsId(String itemIds){
		service.deleteCartItemsService(itemIds);
		return "redirect:toCartHTML.do";
	}

	/** ȷ����Ϣ */
	@RequestMapping("toConfirmHTML.do")
	public String toConfirmHTML(Cart cart,ModelMap model,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		List<Cart> list = (List<Cart>)session.getAttribute("cartItems");
		map.put("list", list);
		model.addAttribute("map",map);
		return "orderConfirm";
	}
	
	/** ��Ʒ�ջ�ҳ�� */
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
