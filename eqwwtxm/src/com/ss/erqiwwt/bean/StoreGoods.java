package com.ss.erqiwwt.bean;

import java.io.Serializable;

/**
 * 商品信息对象
 * @author
 */
public class StoreGoods implements Serializable{
	private static final long serialVersionUID = -6108930903226204189L;

	private Integer gid;  
    private String gname;  //商品名称
    private Integer sid;  //所属店铺
    private double price;  //商品原价
    private String pic;  //商品图片
    private double aprice;  //活动价
    private String startDate;  //开始时间
    private String endDate;  //结束时间
    private String mark;  //商品简介
    private String descr;  //订单详细
    private Integer status;  //商品状态
     
	public StoreGoods() {
		super();
	}

	public StoreGoods(Integer gid, String gname, Integer sid, double price, String pic, double aprice, String startDate,
			String endDate, String mark, String descr, Integer status) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.sid = sid;
		this.price = price;
		this.pic = pic;
		this.aprice = aprice;
		this.startDate = startDate;
		this.endDate = endDate;
		this.mark = mark;
		this.descr = descr;
		this.status = status;
	}

	@Override
	public String toString() {
		return "StoreGoods [gid=" + gid + ", gname=" + gname + ", sid=" + sid + ", price=" + price + ", pic=" + pic
				+ ", aprice=" + aprice + ", startDate=" + startDate + ", endDate=" + endDate + ", mark=" + mark
				+ ", descr=" + descr + ", status=" + status + "]";
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public double getAprice() {
		return aprice;
	}

	public void setAprice(double aprice) {
		this.aprice = aprice;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Integer getstatus() {
		return status;
	}

	public void setstatus(Integer status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(aprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((gid == null) ? 0 : gid.hashCode());
		result = prime * result + ((gname == null) ? 0 : gname.hashCode());
		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
		result = prime * result + ((pic == null) ? 0 : pic.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		StoreGoods other = (StoreGoods) obj;
		if (Double.doubleToLongBits(aprice) != Double.doubleToLongBits(other.aprice))
			return false;
		if (descr == null) {
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (gid == null) {
			if (other.gid != null)
				return false;
		} else if (!gid.equals(other.gid))
			return false;
		if (gname == null) {
			if (other.gname != null)
				return false;
		} else if (!gname.equals(other.gname))
			return false;
		if (mark == null) {
			if (other.mark != null)
				return false;
		} else if (!mark.equals(other.mark))
			return false;
		if (pic == null) {
			if (other.pic != null)
				return false;
		} else if (!pic.equals(other.pic))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
}
