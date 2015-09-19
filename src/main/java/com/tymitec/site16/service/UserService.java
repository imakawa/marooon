package com.tymitec.site16.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.tymitec.site16.dao.UserDao;
import com.tymitec.site16.model.UserInfo;

public class UserService {

	@Autowired
	private UserDao userDao;

	public Integer Create(UserInfo userInfo) {
		return userDao.Create(userInfo);
	}

	public Integer Update(UserInfo userInfo) {
		return userDao.Update(userInfo);
	}

	public List<UserInfo> Read() {
		return userDao.Read();
	}

	public String getInfoo(String content) {
		return "asss";
	}

	public Integer Delete(UserInfo userInfo) {
		return userDao.Delete(userInfo);
	}

	public String getInfo(String content) {
		return "ReturnValue:" + content;
	}
}
