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
		
		Map<String,Object> map = ActionContext.getContext().getParameters();
		String productId = ((String[])map.get("productId"))[0];
		product = productService.Read(productId);
		product.setImagesJson(getImagesJson(product));
        product.setShipping(getShipping(product.getShippingCode()));
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
	
	private ShippingService shippingService;
	
	public ShippingService getShippingService() {
		return shippingService;
	}

	public void setShippingService(ShippingService shippingService) {
		this.shippingService = shippingService;
	}

	private Shipping getShipping(String shippingId){
		return this.shippingService.Read(shippingId);
	}
	
	private String getImagesJson(Product product){
		List<String> imageInfos = product.getImages();
		
		if(imageInfos==null ||imageInfos.toArray().length==0){
			return "";
		}
		
		StringBuffer sb=new StringBuffer();
		sb.append("{\"prod_1\":{");
		sb.append("\"main\":{\"orig\":\"");
		sb.append("productImages/");
		sb.append(imageInfos.get(0));
		sb.append("\",\"main\":\"");
		sb.append("productImages/");
		sb.append(imageInfos.get(0));
		sb.append("\",\"thumb\":\"");
		sb.append("productImages/");
		sb.append(imageInfos.get(0));
		sb.append("\",\"label\":\"\"},");

		sb.append("\"gallery\":{");
		for (int i = 0; i < imageInfos.toArray().length; i++) {
			String image=imageInfos.get(i);
			
			sb.append("\"item_");
			sb.append(i);
			sb.append("\":{\"orig\":\"");
			sb.append("productImages/");
			sb.append(image);
			sb.append("\",\"main\":\"");
			sb.append("productImages/");
			sb.append(image);
			sb.append("\",\"thumb\":\"");
			sb.append("productImages/");
			sb.append(image);
			
			if(i==imageInfos.toArray().length-1){
				sb.append("\",\"label\":\"\"}},\"type\":\"simple\",\"video\":false}}");
			}else{
				sb.append("\",\"label\":\"\"},");	
			}	
		}
		return sb.toString();
	}

}
