package cn.sz.lwt.pojo;

import java.io.Serializable;

public class Manager implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String  uname;
	private String  upassword;
	private String  urealName;
	private String  usex;
	private Integer uage;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUrealName() {
		return urealName;
	}
	public void setUrealName(String urealName) {
		this.urealName = urealName;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public Integer getUage() {
		return uage;
	}
	public void setUage(Integer uage) {
		this.uage = uage;
	}
	
}
