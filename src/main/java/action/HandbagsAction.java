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
		for (Product x : products) {   
	         x.setImagesJson(getImagesJson(x)); 
	         System.out.println(x.getImagesJson());
        }   
		return "Success";
	}
	
	private String getImagesJson(Product product){
		List<String> imageInfos = product.getImages();
		
		if(imageInfos.toArray().length==0){
			return "";
		}
		
		StringBuffer sb=new StringBuffer();
		sb.append("{\"prod_1\":{");
		sb.append("\"main\":{\"orig\":\"");
		sb.append("productImages/" + imageInfos.get(0));
		sb.append("\",\"main\":\"");
		sb.append("productImages/" + imageInfos.get(0));
		sb.append("\",\"thumb\":\"");
		sb.append("productImages/" + imageInfos.get(0));
		sb.append("\",\"label\":\"\"},");

		sb.append("\"gallery\":{");
		for (int i = 0; i < imageInfos.toArray().length; i++) {
			String image=imageInfos.get(i);
			
			sb.append("\"item_");
			sb.append(i);
			sb.append("\":{\"orig\":\"");
			sb.append("productImages/" + image);
			sb.append("\",\"main\":\"");
			sb.append("productImages/" + image);
			sb.append("\",\"thumb\":\"");
			sb.append("productImages/" + image);
			
			if(i==imageInfos.toArray().length-1){
				sb.append("\",\"label\":\"\"}},\"type\":\"simple\",\"video\":false}}");
			}else{
				sb.append("\",\"label\":\"\"},");	
			}	
		}
		return sb.toString();
	}
}
