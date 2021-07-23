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
	 * 测试给购物车添加数据
	 */
	@Test
	public void insertCart(){
		Cart c = new Cart();
		c.setGoodsId(000000731);
		c.setUserId(66);
		c.setGoodsImage("CurleyG");
		c.setNum(731);
		c.setGoodsTitle("测试");
		int n = mapper.insertSelective(c);
		System.out.println(n);
	}
	
	/*
	 * 测试给购物车添加数据(业务层)
	 */
	@Test
	public void insertCartService(){
		Cart c = new Cart();
		c.setGoodsId(10000001);
		c.setUserId(19980731);
		c.setGoodsImage("Curley G");
		c.setNum(731);
		c.setGoodsTitle("希林娜依·高");
		int n = service.addCartService(c);
		System.out.println(n);
	}
	
	/*
	 * 测试购物车详情页
	 */
	@Test
	public void TestFindCartByUserIdMapper(){
		List<Cart> list = mapper.findCartByUserIdMapper(3);
		System.out.println(list);
	}
	
	/*
	 *  测试购物车详情页业务层
	 */
	@Test
	public void TestFindCartByUserIdService(){
		List<Cart> list = service.findCartByUserIdService(3);
		System.out.println(list);
	}
	
	/*
	 * 测试批量删除购物车商品 
	 */
	@Test
	public void testDeleteCartItemsMapper(){
		String[] str = {"6","7","8"};
		mapper.deleteCartItemsMapper(str);
	}
	
	
	
	
}
