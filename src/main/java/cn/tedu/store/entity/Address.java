package cn.tedu.store.entity;

public class Address extends BaseEntity{

	private static final long serialVersionUID = -7971492678962498679L;

	private Integer aid;
	private Integer uid;//归属的用户id
	private String name;//收货人
	private String provinceName;//省的名称
	private String provinceCode;//省的代号
	private String cityName;//市的名称
	private String cityCode;//市的代号
	private String areaName;//区的名称
	private String areaCode;//区的代号
	private String zip;//邮政编码
	private String address;//详细地址
	private String phone;//手机
	private String tel;//固话
	private String tag;//地址类型/标签
	private Integer isDefault;//是否默认：0-不默认 1-默认
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Integer getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", uid=" + uid + ", name=" + name + ", provinceName=" + provinceName
				+ ", provinceCode=" + provinceCode + ", cityName=" + cityName + ", cityCode=" + cityCode + ", areaName="
				+ areaName + ", areaCode=" + areaCode + ", zip=" + zip + ", address=" + address + ", phone=" + phone
				+ ", tel=" + tel + ", tag=" + tag + ", isDefault=" + isDefault + ", getCreatedUser()="
				+ getCreatedUser() + ", getCreatedTime()=" + getCreatedTime() + ", getModifiedUser()="
				+ getModifiedUser() + ", getModifiedTime()=" + getModifiedTime() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aid == null) ? 0 : aid.hashCode());
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
		Address other = (Address) obj;
		if (aid == null) {
			if (other.aid != null)
				return false;
		} else if (!aid.equals(other.aid))
			return false;
		return true;
	}
	
	
}
