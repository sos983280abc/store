package cn.tedu.store.entity;

import java.util.Date;
/**
 * 订单实体类
 * @author soft01
 *
 */
public class Order extends BaseEntity{

	private static final long serialVersionUID = -6033964771914005691L;
	private Integer oid;//'订单id',
	private Integer uid;//'用户id',
	private String recvName;//'收货人姓名',
	private String recvPhone;//'收货人电话',
	private String recvProvince;//'收货地址-省',
	private String recvCity;//'收货地址-市',
	private String recvArea;//'收货地址-区',
	private String recvAddress;//'收货地址-详细地址',
	private Long totalPrice;//'总价',
	private Integer status;//'状态：0-位置父，1-以支付，2-以取消，3-以关闭',
	private Date orderTime;//'下单时间',
	private Integer payType;//'支付方式:0-银联，1-支付宝，2-微信...',
	private Date payTime;//'支付时间',
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getRecvName() {
		return recvName;
	}
	public void setRecvName(String recvName) {
		this.recvName = recvName;
	}
	public String getRecvPhone() {
		return recvPhone;
	}
	public void setRecvPhone(String recvPhone) {
		this.recvPhone = recvPhone;
	}
	public String getRecvProvince() {
		return recvProvince;
	}
	public void setRecvProvince(String recvProvince) {
		this.recvProvince = recvProvince;
	}
	public String getRecvCity() {
		return recvCity;
	}
	public void setRecvCity(String recvCity) {
		this.recvCity = recvCity;
	}
	public String getRecvArea() {
		return recvArea;
	}
	public void setRecvArea(String recvArea) {
		this.recvArea = recvArea;
	}
	public String getRecvAddress() {
		return recvAddress;
	}
	public void setRecvAddress(String recvAddress) {
		this.recvAddress = recvAddress;
	}
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", uid=" + uid + ", recvName=" + recvName + ", recvPhone=" + recvPhone
				+ ", recvProvince=" + recvProvince + ", recvCity=" + recvCity + ", recvArea=" + recvArea
				+ ", recvAddress=" + recvAddress + ", totalPrice=" + totalPrice + ", status=" + status + ", orderTime="
				+ orderTime + ", payType=" + payType + ", payTime=" + payTime + ", getCreatedUser()=" + getCreatedUser()
				+ ", getCreatedTime()=" + getCreatedTime() + ", getModifiedUser()=" + getModifiedUser()
				+ ", getModifiedTime()=" + getModifiedTime() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
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
		Order other = (Order) obj;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		return true;
	}
	
	
}
