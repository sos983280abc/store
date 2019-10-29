package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.entity.District;
/**
 * 省市区持久层接口
 * @author soft01
 *
 */
public interface DistrictMapper {

	/**
	 * 根据父类代号查找省市区
	 * @param parent 父类
	 * @return 返回地区
	 */
	List<District> findByParent(String parent);
	
	/**
	 * 根据code编号查询详情
	 * @param code code编号
	 * @return 返回district详情
	 */
	District findByCode(String code);
}
