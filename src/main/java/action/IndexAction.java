package action;

import java.util.List;

import model.Chanel;
import service.ChanelService;
import util.ChanelCompare;

public class IndexAction {
	
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
/*		Chanel chanel = new Chanel();
		chanel.setReq(0);
		chanel.setName("首页");
		chanel.setAction("index");
		chanelService.Create(chanel);*/
		chanels = chanelService.Read();
		return "Success";
	}
}
