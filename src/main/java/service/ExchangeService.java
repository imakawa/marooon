package service;

import java.util.ArrayList;
import java.util.List;
import model.Exchange;
import dao.ExchangeDao;

public class ExchangeService {

	private ExchangeDao exchangeDao;
	public ExchangeDao getExchangeDao() {return exchangeDao;}
	public void setExchangeDao(ExchangeDao exchangeDao) {this.exchangeDao = exchangeDao;}

	public ExchangeService() {
	}
	
	public Integer Create(Exchange exchange){
		return exchangeDao.Create(exchange);
	}
	
	public Integer Update(Exchange exchange){
		return exchangeDao.Update(exchange);
	}
	
	public List<Exchange> Read(){
		List<Exchange> chanels = new ArrayList<Exchange>();
		try{
			chanels = exchangeDao.Read();
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return chanels;
	}
	
	public Integer Delete(Exchange exchange){
		return exchangeDao.Delete(exchange);
	}
}