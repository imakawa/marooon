package action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import model.Chanel;
import service.ChanelService;

public class UserInfoAction {

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
	
	public String PageLoad() {
		try{
			chanels = chanelService.Read();
			Map<String, Object> session = ActionContext.getContext().getSession();
			if(session.get("loginuser")==null){
				return "Success";	
			}else{
				return "Login";
			}
				
		}catch(Exception e){
			return "Failure";
		}
	}
}
