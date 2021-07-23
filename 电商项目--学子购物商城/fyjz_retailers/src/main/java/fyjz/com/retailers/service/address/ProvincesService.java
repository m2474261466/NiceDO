package fyjz.com.retailers.service.address;

import java.util.List;
import fyjz.com.retailers.entity.Provinces;

/**
 * 地址业务层接口
 * @author Lenovo
 *
 */
public interface ProvincesService {
	/** 获取所有省份 */
	List<Provinces> getProvinceListService();
}
