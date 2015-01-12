package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;

import model.*;
import service.*;

public class DetailsAction {

	private ChanelService chanelService;
	private List<Chanel> chanels;

	private PopularProductService popularProductService;
	private List<PopularProduct> hotProducts;
	
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
	
	public PopularProductService getPopularProductService() {
		return popularProductService;
	}

	public void setPopularProductService(PopularProductService popularProductService) {
		this.popularProductService = popularProductService;
	}

	public List<PopularProduct> getHotProducts() {
		return hotProducts;
	}

	public void setHotProducts(List<PopularProduct> hotProducts) {
		this.hotProducts = hotProducts;
	}

	public String PageLoad() {
		try{
			chanels = chanelService.Read();
			
			Map<String,Object> map = ActionContext.getContext().getParameters();
			String productId = ((String[])map.get("productId"))[0];
			product = productService.Read(productId);
			product.setImagesJson(getImagesJson(product));
	        product.setShipping(getShipping(product.getShippingCode()));
	        
	        hotProducts = popularProductService.ReadHot();
	        System.out.println("Details:"+product.getCode());
			return "Success";	
		}catch(Exception e){
			return "Failure";	
		}
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
	
	public void ReadProductJson(){
		try {
			Map<String,Object> map = ActionContext.getContext().getParameters();
			String productId = ((String[])map.get("productId"))[0];
			
			Product product = productService.Read(productId);
			
			ActionContext context = ActionContext.getContext();
			HttpServletResponse response = (HttpServletResponse) context.get(StrutsStatics.HTTP_RESPONSE);
			response.setContentType("application/json;charset=utf-8");
			response.setCharacterEncoding("utf-8");

			PrintWriter pw = response.getWriter();
			String str = JSONArray.fromObject(product).toString();
			pw.write(str);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
