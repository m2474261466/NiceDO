package fyjz.com.retailers.mapper.goods;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fyjz.com.retailers.entity.Goods;

public interface GoodsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Goods record);

    int insertSelective(Goods record);

    /** ��Ʒ����ҳ */
    Goods selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    
    /** ������Ʒ�ķ���ID��ȡ�����Ʒ */
    List<Goods> findGoodsByCategoryId(@Param("cid")Long cid,@Param("start")Integer start,@Param("pageSize")Integer pageSize);
    
    /** ���ݷ���idȥ��ѯ��Ʒ�������� */
    Integer findGoodsNumByCategoryId(Long cid);
    
    /** ������Ʒ�ķ���id���ҷ�������� */
    String findCategoryNameByGoodsCategoryId(Long cid);

    /** ������Ʒid��ѯ������� */
	int findGoodsNumById(int id);

	/** ������Ʒid�޸Ŀ���� */
	void updateCartItemNumByIdMapper(@Param("id")int goodId, @Param("n")int num);
    
}