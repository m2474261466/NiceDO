package fyjz.com.retailers.mapper.cart;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fyjz.com.retailers.entity.Cart;
/**
 * ���ﳵӳ����
 * @author Lenovo
 *
 */
public interface CartMapper {
	/** ���ݹ��ﳵidɾ�����ﳵ��Ʒ */
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);
    
    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    /** ���ﳵ����ҳ */
	List<Cart> findCartByUserIdMapper(Integer id);
	
	/** ����ɾ�����ﳵ��Ʒ */
	void deleteCartItemsMapper(@Param("str")String[] str);
	
	
	
}