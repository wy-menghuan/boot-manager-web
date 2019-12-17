package com.pinyougou.sellergoods.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pinyougou.pojo.TbSeller;
import com.pinyougou.pojo.TbUser;
import com.pinyougou.sellergoods.service.SellerService;
import com.pinyougou.sellergoods.service.UserService;

/**
 * 
 * 认证类
 * @author wy
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
		System.out.println("经过了UserDetailsServiceImpl");
		//构建角色列表
		List<GrantedAuthority> grantAuths=new ArrayList();
		grantAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		
		//得到商家对象
		TbUser user = userService.findOne(username);
		
		if(user!=null) {
			if(user.getStatus().equals("1")){
				System.out.println(username+":"+user.getPassword());
				//BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
				//String password = encode.encode(user.getPassword());
				//System.out.println(username+":"+password);
                return new User(username,user.getPassword(),grantAuths);
			}else {
				return null;
			}
		}else {
			return null;
		}
		
		/*if(user!=null) {
			return new User(username,user.getPassword(),grantAuths);
		}else {
			return null;
		}*/
		
	}






	





	

}
