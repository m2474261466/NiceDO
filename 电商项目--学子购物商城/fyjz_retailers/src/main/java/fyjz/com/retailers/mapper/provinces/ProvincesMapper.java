package fyjz.com.retailers.mapper.provinces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fyjz.com.retailers.entity.Provinces;
/**
 * ʡ��ӳ����
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

    /** ��ȡ����ʡ�� */
	List<Provinces> getProvinceListMapper();

	String findProvinceNameByCode(@Param("procode")String recvProvincecode);
}