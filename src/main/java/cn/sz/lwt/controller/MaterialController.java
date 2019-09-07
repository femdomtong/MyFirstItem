package cn.sz.lwt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sz.lwt.pojo.Manufacturer;
import cn.sz.lwt.pojo.Material;
import cn.sz.lwt.service.ManufacturerService;
import cn.sz.lwt.service.MaterialService;

@Controller
@RequestMapping("/mc")
public class MaterialController {
	@Autowired
	private MaterialService materialServiceImpl;
	@Autowired
	private  ManufacturerService manufacturerServiceImpl;
	//传统分页
	@RequestMapping("showMaterial")
	public String showMaterial(Model model,
			@RequestParam(defaultValue="1")Integer cp,
			@RequestParam(defaultValue="2")Integer ps,
			@RequestParam(defaultValue="matName")String columnName,
			String term,
			Integer losal,
			Integer hisal,
			String manname){
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("offset", (cp-1)*ps);
		map.put("pigeSize", ps);
		map.put("columnName", columnName);
		map.put("term", term);
		map.put("losal", losal);
		map.put("hisal", hisal);
			if(""==manname||null==manname) {
				map.put("mannameId", null);
			}else {
				Manufacturer manufacturer = manufacturerServiceImpl.qureyManufacturerByName(manname);
				if(manufacturer == null) {
					map.put("mannameId", null);
				}else {
					map.put("mannameId", manufacturer.getManid());
				}
			}
		List<Material> materialList = materialServiceImpl.showMaterial(map);
		List<Manufacturer> allManufacturer = manufacturerServiceImpl.queryAllManufacturer();
		
		Integer totalCount  = materialServiceImpl.queryTotal(map);//总数据量
		int totalPages = totalCount%ps==0?totalCount/ps:totalCount/ps+1;//总页数
        model.addAttribute("materialList", materialList);
        model.addAttribute("cp", cp);
        model.addAttribute("ps", ps);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("allManufacturer", allManufacturer);
        model.addAttribute("term", term);
        model.addAttribute("losal", losal);
        model.addAttribute("hisal", hisal);
        model.addAttribute("manname", manname);
        return "show";
	}
	//pagehelper分页
	@RequestMapping("queryPagehelper")
	public String queryPagehelper(Model model,
			@RequestParam(defaultValue="1")Integer cp,
			@RequestParam(defaultValue="2")Integer ps,
			@RequestParam(defaultValue="matName")String columnName,
			String term,
			Integer losal,
			Integer hisal,
			String manname){
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("columnName", columnName);
		map.put("term", term);
		map.put("losal", losal);
		map.put("hisal", hisal);
		if(""==manname||null==manname) {
			map.put("mannameId", null);
		}else {
			Manufacturer manufacturer = manufacturerServiceImpl.qureyManufacturerByName(manname);
			if(manufacturer == null) {
				map.put("mannameId", null);
			}else {
				map.put("mannameId", manufacturer.getManid());
			}
		}
		//PageHelper必须放在materialList之上,map之下,否则分页无效,这是一个大坑!
		PageHelper.startPage(cp, ps);
		List<Material> materialList = materialServiceImpl.queryPagehelper(map);
		PageInfo<Material> page = new PageInfo<Material>(materialList);
		List<Manufacturer> allManufacturer = manufacturerServiceImpl.queryAllManufacturer();
		model.addAttribute("page", page);
		model.addAttribute("allManufacturer", allManufacturer);
	    model.addAttribute("term", term);
	    model.addAttribute("losal", losal);
	    model.addAttribute("hisal", hisal);
	    model.addAttribute("manname", manname);
		return "showPagehelper";
	}
	
	//批量删除
	@RequestMapping("deleteMaterials")
	public String deleteMaterials(Integer[] matIds,Model model) {
		materialServiceImpl.deleteMaterials(matIds);
		model.addAttribute("deleteInfo", "删除成功!");
		return "forward:/mc/queryPagehelper";
	}
	//修改前查询
	@RequestMapping("queryMaterialById")
	public String queryMaterialById(Integer id,Model model) {
		Material material = materialServiceImpl.queryMaterialById(id);
		List<Manufacturer> allManufacturer = manufacturerServiceImpl.queryAllManufacturer();
		
		model.addAttribute("material", material);
		model.addAttribute("allManufacturer", allManufacturer);
		return "update";
	}
	//修改
	@RequestMapping("updateMaterial")
	public String updateMaterial(Material material,String aftManName,String befManName,Model model) {
		materialServiceImpl.updateMaterial(material);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("befName", befManName);
		map.put("aftName", aftManName);
		manufacturerServiceImpl.updateManName(map);
		model.addAttribute("updateInfo", "修改成功!");
		return "forward:/mc/queryPagehelper";
	}
}
