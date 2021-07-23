package fyjz.com.retailers.controller.address;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fyjz.com.retailers.commons.HandlerException;
/**
 * �ջ���ַ���Ʋ�
 * @author Lenovo
 *
 */
import fyjz.com.retailers.commons.JsonResult;
import fyjz.com.retailers.entity.Address;
import fyjz.com.retailers.entity.Area;
import fyjz.com.retailers.entity.City;
import fyjz.com.retailers.entity.Provinces;
import fyjz.com.retailers.entity.User;
import fyjz.com.retailers.service.address.AddressService;
import fyjz.com.retailers.service.address.AreaService;
import fyjz.com.retailers.service.address.CityService;
import fyjz.com.retailers.service.address.ProvincesService;
@Controller
@RequestMapping("address")
public class AddressController  extends HandlerException{
	@Autowired
	private ProvincesService provinceService;
	@Autowired
	private CityService cityService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private AddressService addressService;
	
	
	// �ջ���ַҳ��
	@RequestMapping("toAddressHTML.do")
	public String toAddressHTML(){
		return "addressAdmin";
	}
	
	// ��ȡʡ��
	@RequestMapping("getProvinceList.do")
	@ResponseBody
	public JsonResult<List<Provinces>> getProvinceList(){
		List<Provinces> list = provinceService.getProvinceListService();
		return new JsonResult<List<Provinces>>(list);
	}
	
	// ��ȡ��
	@RequestMapping("getCityList.do")
	@ResponseBody
	public JsonResult<List<City>> getCityList(String provinceCode){
		List<City> list = cityService.getCityListService(provinceCode);
		return new JsonResult<List<City>>(list);
	}
	
	// ��ȡ��/��
	@RequestMapping("getAreaList.do")
	@ResponseBody
	public JsonResult<List<Area>> getAreaList(String cityCode){
		List<Area> list = areaService.getAreaListService(cityCode);
		return new JsonResult<List<Area>>(list);
	}
	
	//����û��ջ���ַ
	@RequestMapping("toAddGainAddress.do")
	@ResponseBody
	public JsonResult<Integer> toAddGainAddress(Address address,HttpSession session){
		User user=(User)session.getAttribute("user");
		int uid=user.getId();
		address.setUid(uid);
		int n=addressService.addGainAddressService(address);
		return new JsonResult<Integer>(n);
	}
	
	/*
	 *��ʾ�û������ջ���Ϣ 
	 */
	@RequestMapping("toGetAllAddress.do")
	@ResponseBody
	public JsonResult<List<Address>>  toGetAllAddress(HttpSession session){
		User user=(User)session.getAttribute("user");
		int uid=user.getId();
		List<Address> list=addressService.getAllAddressService(uid);
	    return new JsonResult<List<Address>>(list);
	}
	
	/**�����û�id��ѯ�û���Ϣ*/
	@RequestMapping("toFindAddressById.do")
	@ResponseBody
	public JsonResult<Address> toFindAddressById(int id){
		Address address=addressService.selectAddressByIdService(id);
		return new JsonResult<Address>(address);
	}
	
	@RequestMapping("toUpdateAddress.do")
	@ResponseBody
	public JsonResult<Integer> toUpdateAddress(Address address){
		  int n=addressService.updateUserAddressById(address);
		  return new JsonResult<Integer>(n);
	}
	
	@RequestMapping("toDeleteAddressById.do")
	@ResponseBody
	public JsonResult<Integer> toDeleteAddressById(int id){
		int n=addressService.deleteUserAddressById(id);
		return new JsonResult<Integer>(n);
	}
	
	
	@RequestMapping("toChangeIsDefaultAddress.do")
	@ResponseBody
	public JsonResult<Integer> toChangeIsDefaultAddress(int id){
		  int n=addressService.toChangeIsDefaultAddress(id);
		  return new JsonResult<Integer>(n);
	}
	
	
	
}	
