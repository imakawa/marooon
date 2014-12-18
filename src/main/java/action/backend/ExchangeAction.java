package action.backend;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.Exchange;
import service.ExchangeService;

public class ExchangeAction {

	public ExchangeAction() {}

	private ExchangeService exchangeService;
	private List<Exchange> exchanges;	
	public ExchangeService getExchangeService() {return exchangeService;}
	public void setExchangeService(ExchangeService exchangeService) {this.exchangeService = exchangeService;}
	public List<Exchange> getExchanges() {return exchanges;}
	public void setExchanges(List<Exchange> exchanges) {this.exchanges = exchanges;}
	
	private String exchange;
	public String getExchange() {return exchange;}
	public void setExchange(String exchange) {this.exchange = exchange;}
	
	private String currentRate;
	public String getCurrentRate() {return currentRate;}
	public void setCurrentRate(String currentRate) {this.currentRate = currentRate;}
	
	public String Read() {
		currentRate = this.GetCurrentRate();
		return "Success";
	}
	
	public String Create() {
		try{
			this.Read();
			
			Exchange exchangeDo=new Exchange();
			
			Float rate =Float.parseFloat(exchange);
			exchangeDo.setRate(rate);
			
			Date dt=new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			exchangeDo.setUpdateDate(df.format(dt));
			exchangeService.Create(exchangeDo);
			
			currentRate = this.GetCurrentRate();
			return "Success";	
		}catch(Exception e){
			return "Failure";
		}
	}
	
	private String GetCurrentRate(){
		exchanges=exchangeService.Read();
		
		return exchanges.get(exchanges.size()-1).getRate().toString();
	}
}
