package service;

import java.util.List;

import model.Chanel;
import dao.ChanelDao;

public class ChanelService {

	private ChanelDao chanelDao;
	
	public ChanelDao getUserDao() {
		return chanelDao;
	}

	public void setUserDao(ChanelDao chanelDao) {
		this.chanelDao = chanelDao;
	}

	public Integer Create(Chanel chanel){
		return chanelDao.Create(chanel);
	}
	
	public Integer Update(Chanel chanel){
		return chanelDao.Update(chanel);
	}
	
	public List<Chanel> Read(){
		return chanelDao.Read();
	}
	
	public Integer Delete(Chanel chanel){
		return chanelDao.Delete(chanel);
	}
}
