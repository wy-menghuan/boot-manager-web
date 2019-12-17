package com.pinyougou.manager.controller;


import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
@Api(tags="商品模块接口",description="我的商品模块接口",hidden=true)
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	
	@RequestMapping("/findAll")
	@ApiOperation(value="查询所有商品",httpMethod="GET",notes="查询所有我的商品")
	public List<TbBrand> findAll(){
		return brandService.findAll();
	}
	
	
	
	@RequestMapping("/findPage")
	public PageResult findPage(int page,int size) {
		
		return brandService.findPage(page, size); 
	}
	
	@RequestMapping("/add")
	public Result add(@RequestBody TbBrand brand) {
		
		try {
			brandService.add(brand);
			return new Result(true,"增加成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(false,"增加失败");
		}
		
	}
	@RequestMapping("/findOne")
	@ApiOperation(value="根据id查询商品",httpMethod="GET",notes="根据id查询我的商品")
	public TbBrand findOne(Long id) {
		return brandService.findOne(id);
	}
	
	
	/*@RequestMapping("/upload")
	public Result uploadCode(MultipartFile file)  {
		try {
			//获取图片的全路径名
			String originalFilename = file.getOriginalFilename();
			System.out.println("图片名"+originalFilename);
			
		    String fileName=UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
			file.transferTo(new File("E:\\image\\"+fileName));
			
			return new Result(true,fileName);
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(false,"上传失败");
			//return null;
		}
		
	
	}*/
	
	
	

	@RequestMapping("/update")
	public Result update(@RequestBody TbBrand brand) {
		try {
			
			brandService.update(brand);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(false,"修改失败");
		}
		
	  }
	
	
	@RequestMapping("/delete")
	public Result delete(Long [] ids) {
		try {
			brandService.delete(ids);
			return new Result(true,"删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(false,"删除失败");
		}
	}
	
	
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand brand,int page,int size) {
		return brandService.findPage(brand, page, size);
	}
	
	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList(){
		return brandService.selectOptionList();
	}
}
