package fyjz.com.retailers.service.cart;

import java.util.List;

import javax.servlet.http.HttpSession;

import fyjz.com.retailers.entity.Cart;

/**
 * ���ﳵҵ���ӿ�
 * @author Lenovo
 *
 */
public interface CartService {
	/** ��ӹ��ﳵ */
	int addCartService(Cart cart);
	
	/** ���ﳵ����ҳ */
	List<Cart> findCartByUserIdService(int id);

	/** ���ݹ��ﳵidɾ�����ﳵ��Ʒ */
	void deleteCartByIdService(int itemId); 
	
	/** ����ɾ�����ﳵ��Ʒ */
	void deleteCartItemsService(String itemIds);
	
	/** ������Ʒid�޸Ŀ���� */
	 void updateCartItemsNumservice(HttpSession session);
	
}
