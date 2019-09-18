package cn.sz.lwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/pc")
public class PageController {
	@RequestMapping("goPage")
	public String goPage() {
		return "register";
	}
	@RequestMapping("goShow")
	public String goShow() {
		return "redirect:/mc/queryPagehelper";
	}
	@RequestMapping("goWeather")
	public String goWeather() {
		return "weatherInfo";
	}
}
