package cn.sz.lwt.service;

import java.util.Map;

import cn.sz.lwt.pojo.Manager;

public interface ManagerService {
	public Manager login(Map<String,String> map);
	public void register(Manager manager);
}
