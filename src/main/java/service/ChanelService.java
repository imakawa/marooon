package service;

import java.util.ArrayList;
import java.util.List;

import util.ChanelCompare;
import model.Chanel;
import dao.ChanelDao;

public class ChanelService {

	private ChanelDao chanelDao;
	
	public ChanelDao getChanelDao() {
		return chanelDao;
	}

	public void setChanelDao(ChanelDao chanelDao) {
		this.chanelDao = chanelDao;
	}

	public Integer Create(Chanel chanel){
		return chanelDao.Create(chanel);
	}
	
	public Integer Update(Chanel chanel){
		return chanelDao.Update(chanel);
	}
	
	public List<Chanel> Read(){
		List<Chanel> chanels = new ArrayList<Chanel>();
		try{
			chanels = chanelDao.Read();
			chanels.sort(new ChanelCompare());
		}catch(Exception e){
		}
		return chanels;
	}
	
	public Integer Delete(Chanel chanel){
		return chanelDao.Delete(chanel);
	}
	
}
