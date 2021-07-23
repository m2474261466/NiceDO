package testCart;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fyjz.com.retailers.entity.Cart;
import fyjz.com.retailers.mapper.cart.CartMapper;
import fyjz.com.retailers.service.cart.CartService;

public class CartTest {
	ApplicationContext act;
	CartMapper mapper;
	CartService service;
	@Test
	@Before
	public void init(){
		act = new ClassPathXmlApplicationContext("spring-dao.xml","spring-web.xml");
		mapper = act.getBean("cartMapper",CartMapper.class);
		service = act.getBean("cartService",CartService.class);
	}
	
	/*
	 * ���Ը����ﳵ�������
	 */
	@Test
	public void insertCart(){
		Cart c = new Cart();
		c.setGoodsId(000000731);
		c.setUserId(66);
		c.setGoodsImage("CurleyG");
		c.setNum(731);
		c.setGoodsTitle("����");
		int n = mapper.insertSelective(c);
		System.out.println(n);
	}
	
	/*
	 * ���Ը����ﳵ�������(ҵ���)
	 */
	@Test
	public void insertCartService(){
		Cart c = new Cart();
		c.setGoodsId(10000001);
		c.setUserId(19980731);
		c.setGoodsImage("Curley G");
		c.setNum(731);
		c.setGoodsTitle("ϣ����������");
		int n = service.addCartService(c);
		System.out.println(n);
	}
	
	/*
	 * ���Թ��ﳵ����ҳ
	 */
	@Test
	public void TestFindCartByUserIdMapper(){
		List<Cart> list = mapper.findCartByUserIdMapper(3);
		System.out.println(list);
	}
	
	/*
	 *  ���Թ��ﳵ����ҳҵ���
	 */
	@Test
	public void TestFindCartByUserIdService(){
		List<Cart> list = service.findCartByUserIdService(3);
		System.out.println(list);
	}
	
	/*
	 * ��������ɾ�����ﳵ��Ʒ 
	 */
	@Test
	public void testDeleteCartItemsMapper(){
		String[] str = {"6","7","8"};
		mapper.deleteCartItemsMapper(str);
	}
	
	
	
	
}
