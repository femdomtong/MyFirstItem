package cn.sz.lwt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sz.lwt.pojo.Manager;
import cn.sz.lwt.service.ManagerService;

@Controller
@RequestMapping("/mc")
public class ManagerController {
	@Autowired
	private ManagerService managerServiceImpl;
	
	//ajax验证,返回字符串
	@ResponseBody
	@RequestMapping("validation")
	public String validation(String uname,String pwd,HttpServletRequest req) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", uname);
		map.put("pwd", pwd);
		Manager manager = managerServiceImpl.login(map);
		req.getSession().setAttribute("manager", manager);
		if(manager==null) {
			return "";
		}
		return "ok";
	}
	
		/*//ajax验证,返回对象
		@ResponseBody
		@RequestMapping("validation")
		public Manager validation(String uname,String pwd,HttpServletRequest req) {
			Map<String,String> map = new HashMap<String,String>();
			map.put("name", uname);
			map.put("pwd", pwd);
			Manager manager = managerServiceImpl.login(map);
			req.getSession().setAttribute("manager", manager);
			if(manager==null) {
				return null;
			}
			return manager;
		}*/
	//登入
	@RequestMapping("login")
	public String login(String uname,String pwd,HttpServletRequest req) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", uname);
		map.put("pwd", pwd);
		Manager manager = managerServiceImpl.login(map);
		req.getSession().setAttribute("manager", manager);
		if(manager==null) {
			return "index";
		}
		return "redirect:/mc/queryPagehelper";
	}
	//注册
	@RequestMapping("register")
	public String register(Manager manager,Model model) {
		managerServiceImpl.register(manager);
		model.addAttribute("registerInfo", "注册成功!");
		return "index";
	}
	
}
