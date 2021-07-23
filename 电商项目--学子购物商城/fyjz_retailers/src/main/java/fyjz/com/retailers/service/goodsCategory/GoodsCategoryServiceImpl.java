package fyjz.com.retailers.service.goodsCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fyjz.com.retailers.entity.Goods;
import fyjz.com.retailers.entity.GoodsCategory;
import fyjz.com.retailers.mapper.goods.GoodsMapper;
import fyjz.com.retailers.mapper.goodsCategory.GoodsCategoryMapper;
/**
 * ҵ���ʵ����
 * @author Lenovo
 *
 */
@Service("categoryService")
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

	@Autowired
	public GoodsCategoryMapper mapper;
	@Autowired
	public GoodsMapper goodsMapper;
	
	/** ���ݷ���ĸ�ID��ѯ�����Ʒ */
	public Map<String, Object> findgoodsCategoryByParentId(Long pid, Integer start, Integer pageSize) {
		Map<String,Object> map = new HashMap<String, Object>();
		
		// ��ȡ������Ʒ����
		List<GoodsCategory> list2  = mapper.findGoodsCategoryByParentID(pid, start, pageSize);
		// ��ȡ������Ʒ����(listǶ��list)
		List<List<GoodsCategory>> list3  = new ArrayList<List<GoodsCategory>>();
		for(int i = 0;i<list2.size();i++){
			// list2.get(i).getId()��ʾ���������id��Ҳ������������ĸ�id
			List<GoodsCategory> l = mapper.findGoodsCategoryByParentID(list2.get(i).getId(), null, null);
			list3.add(l);
		}
		// ��������Ʒ��������Ʒ������map������
		map.put("list2", list2);
		map.put("list3", list3);
		
		List<Goods> goods = goodsMapper.findGoodsByCategoryId(163L, 0, 3);
		map.put("goods", goods);
		
		List<Goods> goods2 = goodsMapper.findGoodsByCategoryId(238L, 0, 3);
		map.put("goods2", goods2);
		return map;
	}

}
