package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import model.Product;
import net.sf.json.JSONArray;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;

import service.ProductService;

public class ProductAction {

	public ProductAction() {
		// TODO Auto-generated constructor stub
	}

	private ProductService productService;
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	
	public void GetAllProducts(){
		try {
			/*Map<String,Object> map = ActionContext.getContext().getParameters();
			String keyword = ((String[])map.get("kw"))[0];
			
			List<Product> products = productService.ReadByKeyword(keyword);
			*/
			
			List<Product> products = productService.Read();
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
