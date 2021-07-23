package testGoods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import fyjz.com.retailers.commons.PageObject;
import fyjz.com.retailers.entity.Cart;
import fyjz.com.retailers.entity.Goods;
import fyjz.com.retailers.mapper.goods.GoodsMapper;
import fyjz.com.retailers.service.cart.CartService;
import fyjz.com.retailers.service.goods.GoodsService;

public class GoodsTest {
	ApplicationContext act;
	GoodsMapper mapper;
	GoodsService service;
	CartService cartService;
	@Test
	@Before
	public void init(){
		act = new ClassPathXmlApplicationContext("spring-dao.xml","spring-web.xml");
		mapper = act.getBean("goodsMapper",GoodsMapper.class);
		service = act.getBean("goodsServiceImpl",GoodsService.class);
		cartService = act.getBean("cartService",CartService.class);
	}
	
	/*
	 * 测试根据商品的分类ID获取相关商品
	 */
	@Test
	public void testFindGoodsByCategoryId(){
		List<Goods> list = mapper.findGoodsByCategoryId(238L, 4, 3);
		System.out.println(list);
	}
	
	/*
	 * (业务层)测试根据商品的分类ID获取相关商品
	 */
	@Test
	public void testFindGoodsByCategoryIdService(){
		PageObject page = new PageObject();
		Map<String,Object> map = service.findGoodsByCategoryId(163L, page);
		System.out.println(map.get("goods"));
//		map.get("pageCount");
//		map.get("pageCurrent");
//		System.out.println(map);
	}
	
	/*
	 * 测试根据商品id修改库存量
	 */
	@Test
	public void testUpdateCartItemNumByIdService(){
		
		List<Cart> list = new ArrayList<Cart>();
		Cart c = new Cart();
		c.setGoodsId(10000009);
		c.setNum(100);
		Cart c2 = new Cart();
		c2.setGoodsId(100000413);
		c2.setNum(100);
		Cart c3 = new Cart();
		c3.setGoodsId(10000022);
		c3.setNum(100);
		list.add(c);		
		list.add(c2);
		list.add(c3);
//		session.setAttribute("cartitems", list);
//		cartService.updateCartItemsNumservice(session);		
	}
	
}
