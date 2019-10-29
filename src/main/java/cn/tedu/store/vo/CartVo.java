package cn.tedu.store.vo;

import java.io.Serializable;

public class CartVo implements Serializable{

	private static final long serialVersionUID = 4834346043260893866L;
	private Integer uid;
	private Integer pid;
	private Integer cid;
	private String title;
	private String image;
	private Long price;
	private Long realPrice;
	private Integer num;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getRealPrice() {
		return realPrice;
	}
	public void setRealPrice(Long realPrice) {
		this.realPrice = realPrice;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "CartVo [uid=" + uid + ", pid=" + pid + ", cid=" + cid + ", title=" + title + ", image=" + image
				+ ", price=" + price + ", realPrice=" + realPrice + ", num=" + num + "]";
	}
	
	
}
