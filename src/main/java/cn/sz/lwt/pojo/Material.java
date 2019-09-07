package cn.sz.lwt.pojo;

import java.io.Serializable;

public class Material implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer matid;

    private String matname;

    private Double matprice;

    private Integer matnum;

    private Manufacturer manufacturer;

    public Integer getMatid() {
        return matid;
    }

    public void setMatid(Integer matid) {
        this.matid = matid;
    }

    public String getMatname() {
        return matname;
    }

    public void setMatname(String matname) {
        this.matname = matname == null ? null : matname.trim();
    }

    public Double getMatprice() {
        return matprice;
    }

    public void setMatprice(Double matprice) {
        this.matprice = matprice;
    }

    public Integer getMatnum() {
        return matnum;
    }

    public void setMatnum(Integer matnum) {
        this.matnum = matnum;
    }

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

    
}