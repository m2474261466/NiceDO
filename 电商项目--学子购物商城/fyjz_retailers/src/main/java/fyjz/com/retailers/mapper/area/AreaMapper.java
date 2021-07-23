package fyjz.com.retailers.mapper.area;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fyjz.com.retailers.entity.Area;
/**
 * ��/��ӳ����
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

    /** ��ȡ��/�� */
	List<Area> getAreaListMapper(String cityCode);

	String findAreaNameByCode(@Param("areaCode")String recvAreacode);
}