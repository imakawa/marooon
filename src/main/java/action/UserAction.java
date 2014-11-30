package action;


import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import model.Chanel;
import model.UserInfo;
import service.ChanelService;
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
		userInfo.setUsername(username);
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

	/*-------------------------------------------------*/
	
	private ChanelService chanelService;
	private List<Chanel> chanels;
	
	public ChanelService getChanelService() {
		return chanelService;
	}

	public void setChanelService(ChanelService chanelService) {
		this.chanelService = chanelService;
	}

	public List<Chanel> getChanels() {
		return chanels;
	}

	public void setChanels(List<Chanel> chanels) {
		this.chanels = chanels;
	}

	public String Login(){
		chanels = chanelService.Read();
		List<UserInfo> userInfoList = this.userService.Read();
		for(UserInfo user : userInfoList){
			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
				Map<String, Object> session = ActionContext.getContext().getSession();
				session.put("loginuser",user);
				System.out.println("Login:"+user.getUsername());
				return "Success";
			}
		}
		return "Failure";
	}
	
	public String Logout(){
		chanels = chanelService.Read();
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("loginuser");
		return "Success";
	}
}