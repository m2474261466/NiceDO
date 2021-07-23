package fyjz.com.retailers.mapper.goodsCategory;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import fyjz.com.retailers.entity.GoodsCategory;

public interface GoodsCategoryMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(GoodsCategory record);

    int insertSelective(GoodsCategory record);

    GoodsCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsCategory record);

    int updateByPrimaryKey(GoodsCategory record);
    
    /** ���ݸ���ID��ѯ��Ʒ���� */
    List<GoodsCategory> findGoodsCategoryByParentID(@Param("pid")Long pid,@Param("start")Integer start,@Param("pageSize")Integer pageSize);
    
}