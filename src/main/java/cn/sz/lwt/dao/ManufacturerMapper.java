package cn.sz.lwt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.sz.lwt.pojo.Manufacturer;
@Mapper
public interface ManufacturerMapper {
	public Manufacturer queryManufacturerById(Integer manid);
	public List<Manufacturer> queryAllManufacturer();
	
	public void updateManName(Map<String,Object> map);
	public Manufacturer qureyManufacturerByName(String manName);
}
