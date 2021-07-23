package fyjz.com.retailers.service.address;

import java.util.List;

import fyjz.com.retailers.entity.Area;

/**
 * 区/县业务层接口
 * @author Lenovo
 *
 */
public interface AreaService {
	/** 获取区/县 */
	List<Area> getAreaListService(String cityCode);
}	
