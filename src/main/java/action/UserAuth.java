/**
 * 
 */
package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.StrutsStatics;

import service.UserService;
import util.ActionHelper;
import util.ActionSession;
import util.RequestStatus;
import util.ActionStatus;
import model.PopularProduct;
import model.UserInfo;

import com.opensymphony.xwork2.ActionContext;

/**
 * @author wangpeng
 *
 */
public class UserAuth {

	/**
	 * 
	 */
	public UserAuth() {
	}
	
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void UserLoginAuth() {
		try {
			ActionStatus status = new ActionStatus();
			ActionHelper actionHelper = new ActionHelper();
			
			String username = actionHelper.getParam("username");
			String password = actionHelper.getParam("password");
			
			List<UserInfo> userInfoList = this.userService.Read();
			for(UserInfo user : userInfoList){
				if(user.getUsername().equals(username) && 
				   user.getPassword().equals(password)) {
					
					ActionSession.insert(ActionSession.CUR_USER, user);
					status.setStatus(RequestStatus.SUCCESS+"");
					
					break;
				}
			}
			
			if(status.getStatus().equals("")){
				status.setStatus(RequestStatus.FAILURE+"");
			}
			
			actionHelper.writeJson(status);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void isHaveUserLogin() {
		try {
			ActionStatus status = new ActionStatus();
			ActionHelper actionHelper = new ActionHelper();
			
			Boolean bool = ActionSession.isInclude(ActionSession.CUR_USER);
			if(bool){
				status.setStatus(RequestStatus.SUCCESS+"");
			}else{
				status.setStatus(RequestStatus.FAILURE+"");
			}
			
			actionHelper.writeJson(status);
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void ClearSession(){
		try {			
			ActionSession.clear();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
