package action;

import java.util.List;

import service.ChanelService;
import model.Chanel;

public class ChanelAction {

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

	public String Read() {
		chanels = chanelService.Read();
		return "Success";
	}
}
