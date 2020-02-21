package com.accp.pojo;

public class Reimbursedetail {
    private Integer id;

    private String mainid;

    private Double subtotal;

    private String desc;

    private String picturename;

    private String picturepath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMainid() {
        return mainid;
    }

    public void setMainid(String mainid) {
        this.mainid = mainid;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getPicturename() {
        return picturename;
    }

    public void setPicturename(String picturename) {
        this.picturename = picturename == null ? null : picturename.trim();
    }

    public String getPicturepath() {
        return picturepath;
    }

    public void setPicturepath(String picturepath) {
        this.picturepath = picturepath == null ? null : picturepath.trim();
    }
    
    public Reimbursedetail() {
		// TODO Auto-generated constructor stub
	}

	public Reimbursedetail( String mainid, Double subtotal, String desc, String picturename,
			String picturepath) {
		super();
		this.mainid = mainid;
		this.subtotal = subtotal;
		this.desc = desc;
		this.picturename = picturename;
		this.picturepath = picturepath;
	}
    
    
}