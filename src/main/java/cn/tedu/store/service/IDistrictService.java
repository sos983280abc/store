package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.District;
/**
 * 省市区显示业务接口
 * @author soft01
 *
 */
public interface IDistrictService {

	/**
	 * 根据父类得到省市区
	 * @param parent 父类的id
	 * @return 返回查询省市区结果
	 */
	List<District> getByParent(String parent);
	
	/**
	 * 根据code编号查询name
	 * @param code code编号
	 * @return 返回district
	 */
	District getByCode(String code);
}
