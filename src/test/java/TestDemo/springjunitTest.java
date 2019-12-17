package TestDemo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/applicationContext-dao.xml"})
public class springjunitTest {
	
	@Autowired
	private TbBrandMapper brandMapper;
	
	
	/*@Test
	public void testadd() {
		TbBrand brand=new TbBrand();
		brand.setId((long) 31);
		brand.setName("华为5");
		brand.setFirstChar("H");
		brand.setBic("https://img12.360buyimg.com/n1/s450x450_jfs/t1/33675/32/14244/48569/5d0c8fd3Eb4b1b543/35010a834b806ec6.jpg");
		
		
		int num = brandMapper.insert(brand);
		
		//System.out.println(brandMapper);
		System.out.println("增加成功========"+"Id:"+brand.getId()+"姓名:"+
		brand.getName()+"首字母:"+brand.getFirstChar()+"图片地址:"+brand.getBic());
	}
	
	@Test
	public void testfindAll() {
		
		TbBrandExample example=new TbBrandExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike("%S%");
		List<TbBrand> list = brandMapper.selectByExample(example);
		System.out.println(list);
	}
	*/
	
	@Test
	public void testupdate() {
		
		TbBrand brand=new TbBrand();
		brand.setId((long) 27);
		brand.setName("苹果7");
		brand.setFirstChar("P");
		brand.setBic("https://img12.360buyimg.com/n1/s450x450_jfs/t1/33675/32/14244/48569/5d0c8fd3Eb4b1b543/35010a834b806ec6.jpg");
		
		brandMapper.updateByPrimaryKey(brand);
		System.out.println("修改成功========"+"Id:"+brand.getId()+"姓名:"+
				brand.getName()+"首字母:"+brand.getFirstChar()+"图片地址:"+brand.getBic());
	}
	
	
	/*@Test
	public void testdelete() {
		
		TbBrand brand=new TbBrand();
		brandMapper.deleteByPrimaryKey((long) 31);
		System.out.println("删除成功========"+"Id:"+brand.getId()+"姓名:"+
				brand.getName()+"首字母:"+brand.getFirstChar()+"图片地址:"+brand.getBic());
	}*/
	
	
	
	

}
