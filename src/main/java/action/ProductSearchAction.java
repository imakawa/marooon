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
	
	public void ProductSearchJson(){
		try {
			Map<String,Object> map = ActionContext.getContext().getParameters();
			String keyword = ((String[])map.get("kw"))[0];
			
			List<Product> products = productService.ReadByKeyword(keyword);
			
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
