package fyjz.com.retailers.service.address;

import java.util.List;

import fyjz.com.retailers.entity.Area;

/**
 * ��/��ҵ���ӿ�
 * @author Lenovo
 *
 */
public interface AreaService {
	/** ��ȡ��/�� */
	List<Area> getAreaListService(String cityCode);
}	
