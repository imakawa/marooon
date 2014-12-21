package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;

import model.Chanel;
import model.Product;
import service.ChanelService;
import service.ProductService;
import util.ChanelCompare;

public class HandbagsAction {


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
	
	private ProductService productService;
	private List<Product> products;
	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public String PageLoad() {
		try{
			chanels = chanelService.Read();
			
			Map<String,Object> map = ActionContext.getContext().getParameters();
			String chanelId = ((String[])map.get("chanelId"))[0];
			products = productService.ReadByChanel(chanelId);
			return "Success";	
		}catch(Exception e){
			return "Failure";			
		}
	}
	
	public void ReadChannelProudcts(){
		try {
			
			Map<String,Object> map = ActionContext.getContext().getParameters();
			String chanelId = ((String[])map.get("chanelId"))[0];
			
			List<Product> products = productService.ReadByChanel(chanelId);

			ActionContext context = ActionContext.getContext();
			HttpServletResponse response = (HttpServletResponse) context.get(StrutsStatics.HTTP_RESPONSE);
			response.setContentType("application/json;charset=utf-8");
			response.setCharacterEncoding("utf-8");

			PrintWriter pw = response.getWriter();
			String str = JSONArray.fromObject(products).toString();
			pw.write(str);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
