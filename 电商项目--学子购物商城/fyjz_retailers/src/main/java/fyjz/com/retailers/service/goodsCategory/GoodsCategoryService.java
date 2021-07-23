package fyjz.com.retailers.service.goodsCategory;

import java.util.Map;

/**
 * 业务层接口
 * @author Lenovo
 *
 */
public interface GoodsCategoryService {
	/** 根据分类的父ID查询相关商品 */
	Map<String,Object> findgoodsCategoryByParentId(Long pid,Integer start,Integer pageSize);
	
	
}
