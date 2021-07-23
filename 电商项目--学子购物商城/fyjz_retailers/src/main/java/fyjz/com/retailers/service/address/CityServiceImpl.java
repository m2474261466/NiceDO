package fyjz.com.retailers.service.address;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fyjz.com.retailers.entity.City;
import fyjz.com.retailers.mapper.city.CityMapper;

@Service
public class CityServiceImpl implements CityService {
	@Autowired
	private CityMapper cityMapper;
	
	/** 获取所有市 */
	@Override
	public List<City> getCityListService(String provinceCode) {
		return cityMapper.getCityListMapper(provinceCode);
	}

}
