package fyjz.com.retailers.service.address;

import java.util.List;

import javax.servlet.http.HttpSession;

import fyjz.com.retailers.entity.Address;

public interface AddressService {
      /**����û��ջ���ַ*/
	int addGainAddressService(Address address);

	List<Address> getAllAddressService(int uid);

	Address selectAddressByIdService(int id);

	int updateUserAddressById(Address address);

	int deleteUserAddressById(int id);
	
	int toChangeIsDefaultAddress(int id);
}
