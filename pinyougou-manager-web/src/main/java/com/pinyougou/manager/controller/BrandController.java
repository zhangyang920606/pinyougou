package com.pinyougou.manager.controller;

import java.util.List;
import java.util.Map;


import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojp.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	
	@Reference
	private BrandService brandService;


	@RequestMapping("/findAll.do")
	public List<TbBrand> findAll(){
		return brandService.findAll();
	}


	@RequestMapping("/findPage.do")
	public PageResult findPage(int page,int size){
		return brandService.findPage(page, size);
	}


	@RequestMapping("/add.do")
	public Result add(@RequestBody TbBrand brand){
		try {
			brandService.add(brand);
			return new Result(true,"新增成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"新增失败");
		}

	}

	@RequestMapping("/findOne.do")
	public TbBrand findOne(Long id){
		return brandService.findOne(id);
	}


	@RequestMapping("/update.do")
	public Result update(@RequestBody TbBrand brand){
		try {
			brandService.update(brand);
			return new Result(true,"修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"修改失败");
		}

	}



	@RequestMapping("/delete.do")
	public Result delete(Long[] ids){
		try {
			brandService.delete(ids);
			return new Result(true,"删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"删除失败");
		}

	}

	@RequestMapping("/search.do")
	public PageResult search(@RequestBody TbBrand brand,int page,int size){
			return  brandService.findPage(brand,page,size);
	}

	@RequestMapping("/selectOptionList.do")
	public List<Map> selectOptionList(){
		return brandService.selectOptionList();
	}

}
