package cn.sz.lwt.service;

import java.util.List;
import java.util.Map;

import cn.sz.lwt.pojo.Manufacturer;
import cn.sz.lwt.pojo.Material;

public interface MaterialService {
	public List<Material> showMaterial(Map<String,Object> map);
	public void deleteMaterials(Integer[] matIds);
	public Material queryMaterialById(Integer id);
	public Integer queryTotal(Map<String,Object> map);
	public void updateMaterial(Material material);
	public List<Material> queryPagehelper(Map<String,Object> map);
}
