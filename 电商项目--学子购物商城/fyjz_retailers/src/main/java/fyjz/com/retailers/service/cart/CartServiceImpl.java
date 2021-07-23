package fyjz.com.retailers.service.cart;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fyjz.com.retailers.entity.Cart;
import fyjz.com.retailers.mapper.cart.CartMapper;
import fyjz.com.retailers.mapper.goods.GoodsMapper;

/**
 * 购物车业务层实现类
 * @author Lenovo
 *
 */
@Service("cartService")
public class CartServiceImpl implements CartService {
	// 注入
	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	
	/** 添加购物车 */
	public int addCartService(Cart cart) {
		// 获取商品id
		int id = cart.getGoodsId();
		// 根据商品id查询库存数量
		int goodNum = goodsMapper.findGoodsNumById(id);
		// 添加的商品数量和库存数量校验
		if(goodNum < cart.getNum()){// 小于的话抛出异常
			throw new RuntimeException("库存不足！");
		}
		// 反之，将其添加到购物车中
		return cartMapper.insertSelective(cart);
	}

	/** 购物车详情页 */
	@Override
	public List<Cart> findCartByUserIdService(int id) {
		return cartMapper.findCartByUserIdMapper(id);
	}

	/** 根据购物车id删除购物车商品 */
	@Override
	public void deleteCartByIdService(int itemId) {
		cartMapper.deleteByPrimaryKey(itemId);
	}

	/** 批量删除购物车商品 */
	@Override
	public void deleteCartItemsService(String itemIds) { 
		// 分割字符串变为数组
		String[] str = itemIds.split(",");
		cartMapper.deleteCartItemsMapper(str);
	}
	
	/** 根据商品id修改库存量 */
	public void updateCartItemsNumservice(HttpSession session){
		List<Cart> list = (List<Cart>)session.getAttribute("cartItems");
		for(int i = 0;i<list.size();i++){
			int goodId = list.get(i).getGoodsId();
			int num = list.get(i).getNum();// 购物车中的购买数量
			goodsMapper.updateCartItemNumByIdMapper(goodId,num);					
		}
	}


}
