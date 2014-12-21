package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;

import model.*;
import service.*;

public class IndexAction {
	
	private ChanelService chanelService;
	private List<Chanel> chanels;
	
	private PopularProductService popularProductService;
	private List<PopularProduct> indexProducts;
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

	public List<PopularProduct> getIndexProducts() {
		return indexProducts;
	}

	public void setIndexProducts(List<PopularProduct> indexProducts) {
		this.indexProducts = indexProducts;
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
			indexProducts= popularProductService.ReadIndex();
			hotProducts= popularProductService.ReadHot();
			String ipadd=ServletActionContext.getRequest().getRemoteAddr();
			System.out.println("Index:"+ipadd);
			return "Success";	
		}catch(Exception e){
			return "Failure";
		}
	}
	
	public void ReadIndexProducts() {
		try {
			List<PopularProduct> indexProducts= popularProductService.ReadIndex();

			ActionContext context = ActionContext.getContext();
			HttpServletResponse response = (HttpServletResponse) context.get(StrutsStatics.HTTP_RESPONSE);
			response.setContentType("application/json;charset=utf-8");
			response.setCharacterEncoding("utf-8");

			PrintWriter pw = response.getWriter();
			String str = JSONArray.fromObject(indexProducts).toString();
			pw.write(str);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ReadHotProducts() {
		try {
			List<PopularProduct> hotProducts= popularProductService.ReadHot();

			ActionContext context = ActionContext.getContext();
			HttpServletResponse response = (HttpServletResponse) context.get(StrutsStatics.HTTP_RESPONSE);
			response.setContentType("application/json;charset=utf-8");
			response.setCharacterEncoding("utf-8");

			PrintWriter pw = response.getWriter();
			String str = JSONArray.fromObject(hotProducts).toString();
			pw.write(str);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
