package fyjz.com.retailers.service.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fyjz.com.retailers.commons.PageObject;
import fyjz.com.retailers.entity.Goods;
import fyjz.com.retailers.mapper.goods.GoodsMapper;
/**
 * 商品业务层实现类
 * @author Lenovo
 *
 */
@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsMapper mapper;
	
	/** 根据商品的分类ID获取相关商品 */
	public  Map<String,Object> findGoodsByCategoryId(Long cid, PageObject page) {
		 Map<String,Object> map = new HashMap<String, Object>();
		// 获取当前页数
		int pageCurrent = page.getPageCurrent();
		// 获取记录数
		int rowCount = mapper.findGoodsNumByCategoryId(cid);
		page.setRowCount(rowCount);	
		// 获取总页数
		int pageCount = page.getPageCount();
		page.setPageCount(pageCount);
		// 分页的起始位置
		int start = page.getStartIndex();
		// 每页显示的行数
		int pageSize = page.getPageSize();
		// 根据分类id查询所有商品
		List<Goods> goods = mapper.findGoodsByCategoryId(cid, start, pageSize);
		map.put("goods", goods);
		map.put("pageCurrent", pageCurrent);
		map.put("pageCount", pageCount);
		
		// 查询四级商品对应的三级商品
		String goodsName = mapper.findCategoryNameByGoodsCategoryId(cid);
		map.put("cateName",goodsName);
		return map;
	}

	 /** 商品详情页 */
	public Goods findGoodsByIdService(String id) {		
		return mapper.selectByPrimaryKey(id);
	}
	
	

}
