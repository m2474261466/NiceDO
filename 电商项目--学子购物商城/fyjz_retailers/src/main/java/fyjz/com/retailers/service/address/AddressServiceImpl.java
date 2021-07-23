package fyjz.com.retailers.service.address;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fyjz.com.retailers.entity.Address;
import fyjz.com.retailers.entity.User;
import fyjz.com.retailers.mapper.address.AddressMapper;
import fyjz.com.retailers.mapper.area.AreaMapper;
import fyjz.com.retailers.mapper.city.CityMapper;
import fyjz.com.retailers.mapper.provinces.ProvincesMapper;
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private ProvincesMapper provinceMapper;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private AreaMapper areaMapper;
	@Override
	public int addGainAddressService(Address address) {
	           //根据省的编号查询省的编号
		       String provinceName=provinceMapper.findProvinceNameByCode(address.getRecvProvincecode());
		       //根据市的编号查询市的编号
		       String cityName=cityMapper.findCityNameByCode(address.getRecvCitycode());
		       //根据区的编号查询区的编号
		       String areaName=areaMapper.findAreaNameByCode(address.getRecvAreacode());
		       //获取详细地址
		       String ress=address.getRecvAddress();
		       address.setRecvDistrict(provinceName+","+cityName+","+areaName+","+ress);
		       address.setCreateTime(new Date());
			   address.setModifiedTime(new Date());
		       return addressMapper.insertSelective(address);
	}
	@Override
	public List<Address> getAllAddressService(int uid) {
		   List<Address> list=addressMapper.getAllAddressMapper(uid);
		return list;
	}
	@Override
	public Address selectAddressByIdService(int id) {
		Address address=addressMapper.selectAddressByIdMapper(id);
		return address;
	}
	@Override
	public int updateUserAddressById(Address address) {
		address.setModifiedTime(new Date());
		int n=addressMapper.updateByPrimaryKeySelective(address);
		return n;
	}
	@Override
	public int deleteUserAddressById(int id) {
		int n=addressMapper.deleteByPrimaryKey(id);
		return n;
	}
	
	@Transactional
	public int toChangeIsDefaultAddress(int id) {
		Address address=addressMapper.selectAddressByIdMapper(id);
		int uid=address.getUid();
		addressMapper.toChangeAllIsDefaultAddress(uid);
		int n=addressMapper.toChangeIsDefaultAddress(id);
		return n;
	}
	

}
