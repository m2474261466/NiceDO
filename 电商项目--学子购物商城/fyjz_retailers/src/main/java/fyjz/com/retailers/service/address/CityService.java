package fyjz.com.retailers.service.address;

import java.util.List;

import fyjz.com.retailers.entity.City;

/**
 * ��ҵ���ӿ�
 * @author Lenovo
 *
 */
public interface CityService {
	/** ��ȡ������ */
	List<City> getCityListService(String provinceCode);
}
