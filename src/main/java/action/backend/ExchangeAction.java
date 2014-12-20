package action.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;

import model.Exchange;
import service.ExchangeService;

public class ExchangeAction {

	public ExchangeAction() {}

	private ExchangeService exchangeService;
	public ExchangeService getExchangeService() {return exchangeService;}
	public void setExchangeService(ExchangeService exchangeService) {this.exchangeService = exchangeService;}
/*	private List<Exchange> exchanges;	
	public List<Exchange> getExchanges() {return exchanges;}
	public void setExchanges(List<Exchange> exchanges) {this.exchanges = exchanges;}
	
	private String inputRate;
	public String getInputRate() {
		return inputRate;
	}
	public void setInputRate(String inputRate) {
		this.inputRate = inputRate;
	}

	private String currentRate;
	public String getCurrentRate() {return currentRate;}
	public void setCurrentRate(String currentRate) {this.currentRate = currentRate;}
	
	public String Read() {
		currentRate = this.GetCurrentRate();
		return "Success";
	}
	
	public String Create() {
		try{
			
			System.out.println("sssssss");
			Exchange exchangeDo=new Exchange();
			
			Float rate =Float.parseFloat(inputRate);
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
	}*/
	
	public void ReadAllJson() {
		try {
			List<Exchange> exchanges = exchangeService.Read();

			ActionContext context = ActionContext.getContext();
			HttpServletResponse response = (HttpServletResponse) context.get(StrutsStatics.HTTP_RESPONSE);
			response.setContentType("application/json;charset=utf-8");
			response.setCharacterEncoding("utf-8");

			PrintWriter pw = response.getWriter();
			String str = JSONArray.fromObject(exchanges).toString();
			pw.write(str);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void CreateExchange() {
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			String inputRate = request.getParameter("inputRate");

			Exchange exchangeDo = new Exchange();
			Float rate = Float.parseFloat(inputRate);
			exchangeDo.setRate(rate);
			
			Date dt = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			exchangeDo.setUpdateDate(df.format(dt));
			
			exchangeService.Create(exchangeDo);
		}catch(Exception e){
			e.printStackTrace();
		}	  
	}
}
