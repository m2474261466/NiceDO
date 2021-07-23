package fyjz.com.retailers.service.cart;

import java.util.List;

import javax.servlet.http.HttpSession;

import fyjz.com.retailers.entity.Cart;

/**
 * 购物车业务层接口
 * @author Lenovo
 *
 */
public interface CartService {
	/** 添加购物车 */
	int addCartService(Cart cart);
	
	/** 购物车详情页 */
	List<Cart> findCartByUserIdService(int id);

	/** 根据购物车id删除购物车商品 */
	void deleteCartByIdService(int itemId); 
	
	/** 批量删除购物车商品 */
	void deleteCartItemsService(String itemIds);
	
	/** 根据商品id修改库存量 */
	 void updateCartItemsNumservice(HttpSession session);
	
}
