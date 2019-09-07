package cn.sz.lwt.pojo;

import java.io.Serializable;

public class Manufacturer implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer manid;

    private String manname;

    public Integer getManid() {
        return manid;
    }

    public void setManid(Integer manid) {
        this.manid = manid;
    }

    public String getManname() {
        return manname;
    }

	public void setManname(String manname) {
		this.manname = manname;
	}
    

}