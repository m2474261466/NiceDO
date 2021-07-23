package fyjz.com.retailers.mapper.goods;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fyjz.com.retailers.entity.Goods;

public interface GoodsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Goods record);

    int insertSelective(Goods record);

    /** 商品详情页 */
    Goods selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    
    /** 根据商品的分类ID获取相关商品 */
    List<Goods> findGoodsByCategoryId(@Param("cid")Long cid,@Param("start")Integer start,@Param("pageSize")Integer pageSize);
    
    /** 根据分类id去查询商品的总数量 */
    Integer findGoodsNumByCategoryId(Long cid);
    
    /** 根据商品的分类id查找分类的名字 */
    String findCategoryNameByGoodsCategoryId(Long cid);

    /** 根据商品id查询库存数量 */
	int findGoodsNumById(int id);

	/** 根据商品id修改库存量 */
	void updateCartItemNumByIdMapper(@Param("id")int goodId, @Param("n")int num);
    
}