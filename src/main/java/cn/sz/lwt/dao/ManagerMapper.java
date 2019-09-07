package cn.sz.lwt.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.sz.lwt.pojo.Manager;
@Mapper
public interface ManagerMapper {
	//登入
	public Manager login(Map<String,String> map);
	//注册
	public void register(Manager manager);
}
