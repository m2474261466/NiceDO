package fyjz.com.retailers.mapper.cart;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fyjz.com.retailers.entity.Cart;
/**
 * 购物车映射器
 * @author Lenovo
 *
 */
public interface CartMapper {
	/** 根据购物车id删除购物车商品 */
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);
    
    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    /** 购物车详情页 */
	List<Cart> findCartByUserIdMapper(Integer id);
	
	/** 批量删除购物车商品 */
	void deleteCartItemsMapper(@Param("str")String[] str);
	
	
	
}