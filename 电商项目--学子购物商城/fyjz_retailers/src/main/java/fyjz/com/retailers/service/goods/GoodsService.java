package fyjz.com.retailers.service.goods;

import java.util.Map;
import fyjz.com.retailers.commons.PageObject;
import fyjz.com.retailers.entity.Goods;
/**
 * 业务层接口（商品）
 * @author Lenovo
 *
 */
public interface GoodsService {
	/** 根据商品的分类ID获取相关商品 */
    Map<String,Object> findGoodsByCategoryId(Long cid,PageObject page);

    /** 商品详情页 */
	Goods findGoodsByIdService(String id);
    
}
