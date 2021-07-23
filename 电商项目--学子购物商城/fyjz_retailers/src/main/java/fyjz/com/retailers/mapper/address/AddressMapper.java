package fyjz.com.retailers.mapper.address;

import java.util.List;

import fyjz.com.retailers.entity.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

	List<Address> getAllAddressMapper(int uid);

	Address selectAddressByIdMapper(int id);

	int toChangeIsDefaultAddress(int id);

	int toChangeAllIsDefaultAddress(int uid);



	
}