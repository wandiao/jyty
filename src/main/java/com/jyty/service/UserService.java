package com.jyty.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jyty.dao.DaoSupport;
import com.jyty.entity.User;
import com.jyty.util.ReqData;

@Service("userService")
public class UserService {
	@Resource(name = "daoSupport")
	private DaoSupport dao; 

	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User getUserByNameAndPwd(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return(User) dao.findForObject("UserMapper.getUserInfo", user);
	}
	
	/**
	 * 判断用户名是否存在
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public int  userIsExist(String username) throws Exception {
		return (Integer) dao.findForObject("UserMapper.userIsExist", username);
	}
	
	public Object updateLastLogin(ReqData rData) throws Exception {
		return dao.update("UserMapper.updateLastLogin", rData);
	}

}
