package fyjz.com.retailers.service.address;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fyjz.com.retailers.entity.Area;
import fyjz.com.retailers.mapper.area.AreaMapper;

/**
 * 
 * @author Lenovo
 *
 */
@Service
public class AreaServiceImpl implements AreaService{
	@Autowired
	private AreaMapper areaMapper;
	
	/** 获取区/县 */
	@Override
	public List<Area> getAreaListService(String cityCode) {
		return areaMapper.getAreaListMapper(cityCode);
	}
}
