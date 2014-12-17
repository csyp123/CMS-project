package com.synnex.cms.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.synnex.cms.dao.UserDao;
import com.synnex.cms.dto.SearchDto;
import com.synnex.cms.entity.User;

public class UserService {
	UserDao userDao = new UserDao();
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
/**
 * @author joeyy
 * @throws Exception
 */
/*
 * 2014/11/19
 * function register
 */
	public boolean save(User user) throws Exception {
		try {
			if (userDao.checkexist(user)!=null) {
				return false;
			}else{
			userDao.save(user);
			return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
/*
 * 2014/11/24
 * function login
 */
	public User checklogin(User user) {
		return userDao.checklogin(user);
}
/*
 * 2014/11/25
 * function change userpassword
 */
	public boolean updateUserInfo(User user) {
		return userDao.updateUserInfo(user);
	}
	/**
	 * @author walker cheng
	 * 2014/12/02
	 * get the user information by userName
	 */
	public List<SearchDto> search(String userName,Integer userType){
		return userDao.search(userName,userType);
	}
	public List<User> getUserByClubId(int clubId, Integer userId) throws Exception {
		return userDao.getUserByClubId(clubId, userId);
	}
	
	/**
	 * @author walker cheng
	 * 2014/12/11
	 * get the user information by userName
	 * @throws Exception 
	 */
	public User getUserByName(String userName) throws Exception{
		return userDao.getUserByName(userName);
	}
	/**
	 * @author walker cheng
	 * 2014/12/02
	 * get the user information by userId
	 */
	public List<SearchDto> searchUserById(Integer userId){
		return userDao.searchUserById(userId);
	}
}
