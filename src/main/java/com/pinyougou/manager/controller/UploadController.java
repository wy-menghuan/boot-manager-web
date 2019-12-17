package com.pinyougou.manager.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pinyougou.pojo.TbBrand;

import entity.Result;

@RestController
public class UploadController {
	
	@RequestMapping("/upload")
	public 	Result uploadCode(MultipartFile file)  {
		
		
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
		}
			
		
		
	}
	
	

}
