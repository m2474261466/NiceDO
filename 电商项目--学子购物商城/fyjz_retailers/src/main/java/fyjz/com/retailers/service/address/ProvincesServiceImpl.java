package fyjz.com.retailers.service.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fyjz.com.retailers.entity.Provinces;
import fyjz.com.retailers.mapper.provinces.ProvincesMapper;
/**
 * 
 * @author Lenovo
 *
 */
@Service
public class ProvincesServiceImpl implements ProvincesService {
	@Autowired
	private ProvincesMapper provincesMapper;
	
	/** 获取所有省份 */
	@Override
	public List<Provinces> getProvinceListService() {		
		return provincesMapper.getProvinceListMapper();
	}

}
