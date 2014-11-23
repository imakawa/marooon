package action;

import java.util.List;

import model.Chanel;
import service.ChanelService;

public class UserServiceAction {

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
			return "Success";	
		}catch(Exception e){
			return "Failure";
		}
	}
}
