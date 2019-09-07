package cn.sz.lwt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.lwt.dao.ManufacturerMapper;
import cn.sz.lwt.pojo.Manufacturer;
import cn.sz.lwt.service.ManufacturerService;
@Service
public class ManufacturerServiceImpl implements ManufacturerService {
	@Autowired
	private ManufacturerMapper dao;
	
	public List<Manufacturer> queryAllManufacturer(){
		return dao.queryAllManufacturer();
	}
	public void updateManName(Map<String,Object> map) {
		dao.updateManName(map);
	}
	public Manufacturer qureyManufacturerByName(String manName) {
		return dao.qureyManufacturerByName(manName);
	}
}
