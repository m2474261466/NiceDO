package fyjz.com.retailers.mapper.provinces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fyjz.com.retailers.entity.Provinces;
/**
 * 省份映射器
 * @author Lenovo
 *
 */
public interface ProvincesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Provinces record);

    int insertSelective(Provinces record);

    Provinces selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Provinces record);

    int updateByPrimaryKey(Provinces record);

    /** 获取所有省份 */
	List<Provinces> getProvinceListMapper();

	String findProvinceNameByCode(@Param("procode")String recvProvincecode);
}