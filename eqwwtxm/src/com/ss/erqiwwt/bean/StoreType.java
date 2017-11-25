package com.ss.erqiwwt.bean;

import java.io.Serializable;

/**
 * 店铺类型对象
 * @author
 */
public class StoreType implements Serializable{
	private static final long serialVersionUID = -2882710925230190982L;

	private Integer stid;  //店铺类型编号
    private String stname;  //店铺类型名 （自助，火锅， 牛排，烧烤，快餐）
    private String discr;  //类型描述
    private Integer status;  //类型状态
    
	public StoreType() {
		super();
	}

	public StoreType(Integer stid, String stname, String discr, Integer status) {
		super();
		this.stid = stid;
		this.stname = stname;
		this.discr = discr;
		this.status = status;
	}

	@Override
	public String toString() {
		return "StoreType [stid=" + stid + ", stname=" + stname + ", discr=" + discr + ", status=" + status + "]";
	}

	public Integer getStid() {
		return stid;
	}

	public void setStid(Integer stid) {
		this.stid = stid;
	}

	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	public String getDiscr() {
		return discr;
	}

	public void setDiscr(String discr) {
		this.discr = discr;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discr == null) ? 0 : discr.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((stid == null) ? 0 : stid.hashCode());
		result = prime * result + ((stname == null) ? 0 : stname.hashCode());
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
		StoreType other = (StoreType) obj;
		if (discr == null) {
			if (other.discr != null)
				return false;
		} else if (!discr.equals(other.discr))
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
		return true;
	}
}
