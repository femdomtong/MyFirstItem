package cn.sz.lwt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.lwt.dao.MaterialMapper;
import cn.sz.lwt.pojo.Material;
import cn.sz.lwt.service.MaterialService;
@Service
public class MaterialServiceImpl implements MaterialService {
	@Autowired
	private MaterialMapper dao;
	
	public List<Material> showMaterial(Map<String,Object> map){
		List<Material> materialList = dao.showMaterial(map);
		return materialList;
	}
	//批量删除
	public void deleteMaterials(Integer[] matIds) {
		dao.deleteMaterials(matIds);
	}
	// 修改前查询 
	public Material queryMaterialById(Integer id) {
		return dao.queryMaterialById(id);
	}
	
	public Integer queryTotal(Map<String,Object> map) {
		return dao.queryTotal(map);
	}
	
	public void updateMaterial(Material material) {
		dao.updateMaterial(material);
	}
	//pagehelper分页
	public List<Material> queryPagehelper(Map<String,Object> map){
		return dao.queryPagehelper(map);
	}
}
