package cn.tedu.store.controller.ex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.controller.BaseController;
import cn.tedu.store.entity.District;
import cn.tedu.store.service.IDistrictService;
import cn.tedu.store.util.JsonResult;

@RestController
@RequestMapping("districts")
public class DistrictController extends BaseController{

	@Autowired
	private IDistrictService districtservice;
	
	@GetMapping("/")
	public JsonResult<List<District>> getByParent(String parent){
		//调用业务层对象执行查询
		List<District> data = districtservice.getByParent(parent);
		//响应成功，集查询结果
		return new JsonResult<List<District>>(SUCCESS, data);
	}
}
