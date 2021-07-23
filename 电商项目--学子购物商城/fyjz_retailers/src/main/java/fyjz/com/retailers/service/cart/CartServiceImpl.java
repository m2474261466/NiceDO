package fyjz.com.retailers.service.cart;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fyjz.com.retailers.entity.Cart;
import fyjz.com.retailers.mapper.cart.CartMapper;
import fyjz.com.retailers.mapper.goods.GoodsMapper;

/**
 * ���ﳵҵ���ʵ����
 * @author Lenovo
 *
 */
@Service("cartService")
public class CartServiceImpl implements CartService {
	// ע��
	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	
	/** ��ӹ��ﳵ */
	public int addCartService(Cart cart) {
		// ��ȡ��Ʒid
		int id = cart.getGoodsId();
		// ������Ʒid��ѯ�������
		int goodNum = goodsMapper.findGoodsNumById(id);
		// ��ӵ���Ʒ�����Ϳ������У��
		if(goodNum < cart.getNum()){// С�ڵĻ��׳��쳣
			throw new RuntimeException("��治�㣡");
		}
		// ��֮��������ӵ����ﳵ��
		return cartMapper.insertSelective(cart);
	}

	/** ���ﳵ����ҳ */
	@Override
	public List<Cart> findCartByUserIdService(int id) {
		return cartMapper.findCartByUserIdMapper(id);
	}

	/** ���ݹ��ﳵidɾ�����ﳵ��Ʒ */
	@Override
	public void deleteCartByIdService(int itemId) {
		cartMapper.deleteByPrimaryKey(itemId);
	}

	/** ����ɾ�����ﳵ��Ʒ */
	@Override
	public void deleteCartItemsService(String itemIds) { 
		// �ָ��ַ�����Ϊ����
		String[] str = itemIds.split(",");
		cartMapper.deleteCartItemsMapper(str);
	}
	
	/** ������Ʒid�޸Ŀ���� */
	public void updateCartItemsNumservice(HttpSession session){
		List<Cart> list = (List<Cart>)session.getAttribute("cartItems");
		for(int i = 0;i<list.size();i++){
			int goodId = list.get(i).getGoodsId();
			int num = list.get(i).getNum();// ���ﳵ�еĹ�������
			goodsMapper.updateCartItemNumByIdMapper(goodId,num);					
		}
	}


}
