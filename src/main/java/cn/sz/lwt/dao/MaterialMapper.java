package cn.sz.lwt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.sz.lwt.pojo.Material;

@Mapper
public interface MaterialMapper {
	public List<Material> showMaterial(Map<String,Object> map);
	public void deleteMaterials(Integer[] matIds);
	public Material queryMaterialById(Integer id);
	public Integer queryTotal(Map<String,Object> map);
	public void updateMaterial(Material material);
	public List<Material> queryPagehelper(Map<String,Object> map);
}
