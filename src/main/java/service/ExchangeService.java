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
		List<Exchange> exchanges = new ArrayList<Exchange>();
		try{
			exchanges = exchangeDao.Read();
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return exchanges;
	}
	
	public Exchange ReadCurrentRate(){
		List<Exchange> exchanges = new ArrayList<Exchange>();
		try{
			exchanges = exchangeDao.Read();
			
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return exchanges.get(exchanges.size()-1);
	}
	
	public Integer Delete(Exchange exchange){
		return exchangeDao.Delete(exchange);
	}
}