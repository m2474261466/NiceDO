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
 * ��Ʒҵ���ʵ����
 * @author Lenovo
 *
 */
@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsMapper mapper;
	
	/** ������Ʒ�ķ���ID��ȡ�����Ʒ */
	public  Map<String,Object> findGoodsByCategoryId(Long cid, PageObject page) {
		 Map<String,Object> map = new HashMap<String, Object>();
		// ��ȡ��ǰҳ��
		int pageCurrent = page.getPageCurrent();
		// ��ȡ��¼��
		int rowCount = mapper.findGoodsNumByCategoryId(cid);
		page.setRowCount(rowCount);	
		// ��ȡ��ҳ��
		int pageCount = page.getPageCount();
		page.setPageCount(pageCount);
		// ��ҳ����ʼλ��
		int start = page.getStartIndex();
		// ÿҳ��ʾ������
		int pageSize = page.getPageSize();
		// ���ݷ���id��ѯ������Ʒ
		List<Goods> goods = mapper.findGoodsByCategoryId(cid, start, pageSize);
		map.put("goods", goods);
		map.put("pageCurrent", pageCurrent);
		map.put("pageCount", pageCount);
		
		// ��ѯ�ļ���Ʒ��Ӧ��������Ʒ
		String goodsName = mapper.findCategoryNameByGoodsCategoryId(cid);
		map.put("cateName",goodsName);
		return map;
	}

	 /** ��Ʒ����ҳ */
	public Goods findGoodsByIdService(String id) {		
		return mapper.selectByPrimaryKey(id);
	}
	
	

}
