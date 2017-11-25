package com.ss.erqiwwt.bean;

import java.io.Serializable;

/**
 * 店铺信息对象
 * @author
 */
public class Store implements Serializable{
	private static final long serialVersionUID = -3117268244738377156L;

	private Integer sid;  //店铺编号
	private Integer stid;  //店铺类型
    private String sname;  //店铺名称
    private String pwd;  //密码
    private String pro;  //省份
    private String city;  //城市
    private String area;  //地区
    private String addr;  //详细地址
    private String license;  //营业执照
    private String runtime;  //营业时间段  10:00-22:00
    private String pic;  //店铺图片
    private String tel;  //预约电话
    private String sdate;  //注册时间
    private Integer status;  //点评状态  0.注销  1.正常  2.未审核  3.审核未通过  4.冻结
    private String reason;  //审核或冻结的情况说明
    
    private String stname;  //店铺类型名 （自助，火锅， 牛排，烧烤，快餐）
    
	
	public Store() {
		super();
	}

	public Store(Integer sid, Integer stid, String sname, String pwd, String pro, String city, String area, String addr,
			String license, String runtime, String pic, String tel, String sdate, Integer status, String reason,String stname) {
		super();
		this.sid = sid;
		this.stid = stid;
		this.sname = sname;
		this.pwd = pwd;
		this.pro = pro;
		this.city = city;
		this.area = area;
		this.addr = addr;
		this.license = license;
		this.runtime = runtime;
		this.pic = pic;
		this.tel = tel;
		this.sdate = sdate;
		this.status = status;
		this.reason = reason;
		this.stname = stname;
	}

	@Override
	public String toString() {
		return "Store [sid=" + sid + ", stid=" + stid + ", sname=" + sname + ", pwd=" + pwd + ", pro=" + pro + ", city="
				+ city + ", area=" + area + ", addr=" + addr + ", license=" + license + ", runtime=" + runtime
				+ ", pic=" + pic + ", tel=" + tel + ", sdate=" + sdate + ", status=" + status + ", reason=" + reason
				+ ", stname=" + stname+"]";
	}
	
	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getStid() {
		return stid;
	}

	public void setStid(Integer stid) {
		this.stid = stid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPro() {
		return pro;
	}

	public void setPro(String pro) {
		this.pro = pro;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((license == null) ? 0 : license.hashCode());
		result = prime * result + ((pic == null) ? 0 : pic.hashCode());
		result = prime * result + ((pro == null) ? 0 : pro.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((runtime == null) ? 0 : runtime.hashCode());
		result = prime * result + ((sdate == null) ? 0 : sdate.hashCode());
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((stid == null) ? 0 : stid.hashCode());
		result = prime * result + ((stname == null) ? 0 : stname.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Store other = (Store) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (license == null) {
			if (other.license != null)
				return false;
		} else if (!license.equals(other.license))
			return false;
		if (pic == null) {
			if (other.pic != null)
				return false;
		} else if (!pic.equals(other.pic))
			return false;
		if (pro == null) {
			if (other.pro != null)
				return false;
		} else if (!pro.equals(other.pro))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (runtime == null) {
			if (other.runtime != null)
				return false;
		} else if (!runtime.equals(other.runtime))
			return false;
		if (sdate == null) {
			if (other.sdate != null)
				return false;
		} else if (!sdate.equals(other.sdate))
			return false;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (stid == null) {
			if (other.stid != null)
				return false;
		} else if (!stid.equals(other.stid))
			return false;
		if (stname == null) {
			if (other.stname != null)
				return false;
		} else if (!stname.equals(other.stname))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}
}
