package action;

import java.util.List;

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
			System.out.println("Index");
			return "Success";	
		}catch(Exception e){
			return "Failure";
		}
	}
}
