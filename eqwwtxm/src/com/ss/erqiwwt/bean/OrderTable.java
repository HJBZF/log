package com.ss.erqiwwt.bean;

import java.io.Serializable;

/**
 * 订单对象
 * @author
 */
public class OrderTable implements Serializable{
	private static final long serialVersionUID = -4034315728397386062L;

	private String oid;
	private String usid;  //用户编号
    private Integer gid;  //商品编号
    private String odate;  //下单时间
    private double total;  //订单金额
    private String udate;  //使用时间
    private Integer pnum;  //购买数量
    private Integer status;  //0.已取消  1.已添加  2.已下单  3.已支付  4.已使用
    
	public OrderTable() {
		super();
	}

	public OrderTable(String oid, String usid, Integer gid, String odate, double total, String udate, Integer pnum,
			Integer status) {
		super();
		this.oid = oid;
		this.usid = usid;
		this.gid = gid;
		this.odate = odate;
		this.total = total;
		this.udate = udate;
		this.pnum = pnum;
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderTable [oid=" + oid + ", usid=" + usid + ", gid=" + gid + ", odate=" + odate + ", total=" + total
				+ ", udate=" + udate + ", pnum=" + pnum + ", status=" + status + "]";
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getUsid() {
		return usid;
	}

	public void setUsid(String usid) {
		this.usid = usid;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getUdate() {
		return udate;
	}

	public void setUdate(String udate) {
		this.udate = udate;
	}

	public Integer getPnum() {
		return pnum;
	}

	public void setPnum(Integer pnum) {
		this.pnum = pnum;
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
		result = prime * result + ((gid == null) ? 0 : gid.hashCode());
		result = prime * result + ((odate == null) ? 0 : odate.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + ((pnum == null) ? 0 : pnum.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((udate == null) ? 0 : udate.hashCode());
		result = prime * result + ((usid == null) ? 0 : usid.hashCode());
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
		OrderTable other = (OrderTable) obj;
		if (gid == null) {
			if (other.gid != null)
				return false;
		} else if (!gid.equals(other.gid))
			return false;
		if (odate == null) {
			if (other.odate != null)
				return false;
		} else if (!odate.equals(other.odate))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (pnum == null) {
			if (other.pnum != null)
				return false;
		} else if (!pnum.equals(other.pnum))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		if (udate == null) {
			if (other.udate != null)
				return false;
		} else if (!udate.equals(other.udate))
			return false;
		if (usid == null) {
			if (other.usid != null)
				return false;
		} else if (!usid.equals(other.usid))
			return false;
		return true;
	}
}
