package fyjz.com.retailers.mapper.city;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fyjz.com.retailers.entity.City;
/**
 * ��ӳ����
 * @author Lenovo
 *
 */
public interface CityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);

    /** ��ȡ������ */
	List<City> getCityListMapper(@Param("provinceCode")String provinceCode);

	String findCityNameByCode(@Param("cityCode")String recvCitycode);
}