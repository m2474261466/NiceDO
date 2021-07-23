package fyjz.com.retailers.service.address;

import java.util.List;

import fyjz.com.retailers.entity.City;

/**
 * 市业务层接口
 * @author Lenovo
 *
 */
public interface CityService {
	/** 获取所有市 */
	List<City> getCityListService(String provinceCode);
}
