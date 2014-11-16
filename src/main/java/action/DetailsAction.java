package action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import model.*;
import service.*;

public class DetailsAction {

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
	
	public String PageLoad() {
		chanels = chanelService.Read();
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> map = ActionContext.getContext().getParameters();
		System.out.println(((String[])map.get("productId"))[0]);
		String productId = ((String[])map.get("productId"))[0];
		product = productService.Read(productId);
		
		return "Success";
	}
	
	private ProductService productService;
	private Product product;
	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String CreateProduct(){
		Product product = new Product();
		product.setName("ProductName");
		
		PriceInfo priceInfo = new PriceInfo();
		priceInfo.setPrice1("1001");
		priceInfo.setPrice2("1002");
		priceInfo.setPrice3("1003");
		product.setPrice(priceInfo);
		
		product.setShippingCode("shippingCode111");
		product.setWeightInfo("200g");
		product.setIsInStock("1");
		
		CommentInfo comment1 = new CommentInfo();
		comment1.setChInfo("cnInfo1");
		comment1.setJpInfo("jpInfo1");
		product.setDescripe1(comment1);
		
		CommentInfo comment2 = new CommentInfo();
		comment2.setChInfo("cnInfo2");
		comment2.setJpInfo("jpInfo2");
		product.setDescripe2(comment2);
		
		CommentInfo comment3 = new CommentInfo();
		comment3.setChInfo("cnInfo3");
		comment3.setJpInfo("jpInfo3");
		product.setDescripe3(comment3);
		
		CommentInfo comment4 = new CommentInfo();
		comment4.setChInfo("cnInfo4");
		comment4.setJpInfo("jpInfo4");
		product.setDescripe4(comment4);
		
		productService.Create(product);
		return "Success";
	}
	

}
