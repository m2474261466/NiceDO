package fyjz.com.retailers.service.goodsCategory;

import java.util.Map;

/**
 * ҵ���ӿ�
 * @author Lenovo
 *
 */
public interface GoodsCategoryService {
	/** ���ݷ���ĸ�ID��ѯ�����Ʒ */
	Map<String,Object> findgoodsCategoryByParentId(Long pid,Integer start,Integer pageSize);
	
	
}
