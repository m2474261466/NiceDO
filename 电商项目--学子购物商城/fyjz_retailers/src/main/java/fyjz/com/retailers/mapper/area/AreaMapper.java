package fyjz.com.retailers.mapper.area;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fyjz.com.retailers.entity.Area;
/**
 * 区/县映射器
 * @author Lenovo
 *
 */
public interface AreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);

    /** 获取区/县 */
	List<Area> getAreaListMapper(String cityCode);

	String findAreaNameByCode(@Param("areaCode")String recvAreacode);
}