package fyjz.com.retailers.service.goods;

import java.util.Map;
import fyjz.com.retailers.commons.PageObject;
import fyjz.com.retailers.entity.Goods;
/**
 * ҵ���ӿڣ���Ʒ��
 * @author Lenovo
 *
 */
public interface GoodsService {
	/** ������Ʒ�ķ���ID��ȡ�����Ʒ */
    Map<String,Object> findGoodsByCategoryId(Long cid,PageObject page);

    /** ��Ʒ����ҳ */
	Goods findGoodsByIdService(String id);
    
}
