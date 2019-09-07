package cn.sz.lwt.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.lwt.dao.ManagerMapper;
import cn.sz.lwt.pojo.Manager;
import cn.sz.lwt.service.ManagerService;
@Service
public class ManagerServiceImpl implements ManagerService{
	@Autowired
	private ManagerMapper dao;
	//登入
	public Manager login(Map<String,String> map){
		Manager manager = dao.login(map);
		return manager;
	}
	//注册
	public void register(Manager manager) {
		dao.register(manager);
	}
}
