package action;

import java.util.List;

import model.Chanel;
import model.Product;
import service.*;

public class ProductSearchAction {

	private ChanelService chanelService;
	private List<Chanel> chanels;
	
	private String keyword;
	private ProductService productService;
	private List<Product> products;
	
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
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
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

	public ProductSearchAction() {
		// TODO Auto-generated constructor stub
	}

	public String ProductSearch() {
		chanels = chanelService.Read();
		
		if(!keyword.equals("") && keyword!=null){
			products = productService.ReadByKeyword(keyword);
			System.out.println(products.size());
		}
		
		return "Success";
	}
}
