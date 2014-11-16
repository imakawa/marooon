package action;

import java.util.List;

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
		chanels = chanelService.Read();
		products = productService.Read();
		return "Success";
	}
}
