package service;

import java.util.ArrayList;
import java.util.List;

import model.*;
import dao.*;

public class PopularProductService {

	public PopularProductService() {
		// TODO Auto-generated constructor stub
	}
	
	private PopularProductDao popularProductDao;
	/*private ProductDao productDao;*/
	private ChanelDao chanelDao;
	
	public PopularProductDao getPopularProductDao() {
		return popularProductDao;
	}

	public void setPopularProductDao(PopularProductDao popularProductDao) {
		this.popularProductDao = popularProductDao;
	}
	
/*	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}*/

	public ChanelDao getChanelDao() {
		return chanelDao;
	}

	public void setChanelDao(ChanelDao chanelDao) {
		this.chanelDao = chanelDao;
	}
	
	private ProductService productService;
	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public Integer Create(PopularProduct popularProduct){
		return popularProductDao.Create(popularProduct);
	}
	
	public Integer Update(PopularProduct popularProduct){
		return popularProductDao.Update(popularProduct);
	}
	
	public List<PopularProduct> Read(){
		List<PopularProduct> popularProducts = new ArrayList<PopularProduct>();
		popularProducts = popularProductDao.Read();
		
		for(PopularProduct x:popularProducts){
			Product product = productService.Read(x.getProductId());
			x.setProduct(product);
			Chanel chanel = chanelDao.Read(product.getChanelId());
			x.setChanel(chanel);
		}
		
		return popularProducts;
	}

	public List<PopularProduct> ReadIndex(){
		List<PopularProduct> popularProducts = new ArrayList<PopularProduct>();
		popularProducts = popularProductDao.ReadIndex();
		
		for(PopularProduct x:popularProducts){
			System.out.println(x.getProductId());
			Product product = productService.Read(x.getProductId());
			x.setProduct(product);
			Chanel chanel = chanelDao.Read(product.getChanelId());
			x.setChanel(chanel);
		}
		
		return popularProducts;
	}
	
	public List<PopularProduct> ReadHot(){
		List<PopularProduct> popularProducts = new ArrayList<PopularProduct>();
		popularProducts = popularProductDao.ReadHot();
		
		for(PopularProduct x:popularProducts){
			Product product = productService.Read(x.getProductId());
			x.setProduct(product);
			Chanel chanel = chanelDao.Read(product.getChanelId());
			x.setChanel(chanel);
		}
		
		return popularProducts;
	}
	
	public Integer Delete(PopularProduct popularProduct){
		return popularProductDao.Delete(popularProduct);
	}
}
