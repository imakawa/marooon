package action;

import java.util.List;
import java.util.Map;

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
}
