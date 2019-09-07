package cn.sz.lwt.service;

import java.util.List;
import java.util.Map;

import cn.sz.lwt.pojo.Manufacturer;

public interface ManufacturerService {
	public List<Manufacturer> queryAllManufacturer();
	public void updateManName(Map<String,Object> map);
	public Manufacturer qureyManufacturerByName(String manName);
}
