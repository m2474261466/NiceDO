package testGoodsCategory;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fyjz.com.retailers.entity.GoodsCategory;
import fyjz.com.retailers.mapper.goodsCategory.GoodsCategoryMapper;
import fyjz.com.retailers.service.goodsCategory.GoodsCategoryService;

public class TestCategory {
	ApplicationContext act;
	GoodsCategoryMapper mapper;
	GoodsCategoryService service;
	@Test
	@Before
	public void init(){
		act = new ClassPathXmlApplicationContext("spring-dao.xml","spring-web.xml");
		mapper = act.getBean("goodsCategoryMapper",GoodsCategoryMapper.class);
		service = act.getBean("categoryService",GoodsCategoryService.class);
	}
	
	/*
	 * ���Ը��ݸ���ID��ѯ��Ʒ����
	 */
	@Test
	public void testFindDataByCategoryParentId(){
		List<GoodsCategory> list = mapper.findGoodsCategoryByParentID(161L,null, null);
		System.out.println(list);
		System.out.println(list.size());
	}
	
	/*
	 * ���Ը��ݷ���ĸ�ID��ѯ�����Ʒ
	 */
	@Test
	public void testFindgoodsCategoryByParentId(){
		Map<String,Object> map = service.findgoodsCategoryByParentId(161L, 4, 3);
		System.out.println(map.size());
		List<GoodsCategory> list = (List<GoodsCategory>)map.get("list2");
		System.out.println("������Ʒ��������" + list);
		List<List<GoodsCategory>> list2 = (List<List<GoodsCategory>>)map.get("list3");
		for(List<GoodsCategory> l : list2){// ÿ��������Ʒ���ж��ٸ�������Ʒ
			System.out.println(l.size());
		}
		
		// Lambda���ʽ
		/*map.forEach((k,v)->{
			System.out.println(k);
			System.out.println(v);
			System.out.println(map.size());
		});*/
		
		// ʹ�õ���������map����
		/*Set<String> set = map.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			String k = (String)it.next();
			Object v = map.get(k);
			System.out.println("k = " + k + "��v = " + v);
		}*/
	}
	
	
}
