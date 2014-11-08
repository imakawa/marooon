package service;

import java.util.*;

import dao.UserDao;
import model.UserInfo;

public class UserService {

	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public Integer Create(UserInfo userInfo){
		return userDao.Create(userInfo);
	}
	
	public Integer Update(UserInfo userInfo){
		return userDao.Update(userInfo);
	}
	
	public List<UserInfo> Read(){
		return userDao.Read();
	}
	
	public Integer Delete(UserInfo userInfo){
		return userDao.Delete(userInfo);
	}
}
