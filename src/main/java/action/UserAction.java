package action;


import java.util.List;

import model.UserInfo;
import service.UserService;

public class UserAction {
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	private String username;
	private String password;
	
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	private List<UserInfo> userInfos;
	
	public List<UserInfo> getUserInfos() {
		return userInfos;
	}


	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}


	public String Create() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(username);
		userInfo.setPassword(password);
		userService.Create(userInfo);
		Read();
		return "Success";
	}
	
	public String Update() {
		UserInfo userInfo = new UserInfo();
		userService.Update(userInfo);
		return "Success";
	}	

	public String Read() {
		userInfos = userService.Read();
		
		return "Success";
	}

	public String Delete() {
		UserInfo userInfo = new UserInfo();
		userService.Delete(userInfo);
		return "Success";
	}
}