package service;

import java.util.ArrayList;
import java.util.List;

import model.Product;
import dao.ProductDao;

public class ProductService {

	public ProductService() {
		// TODO Auto-generated constructor stub
	}

	private ProductDao productDao;
	
	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}


	public Integer Create(Product product){
		return productDao.Create(product);
	}
	
	public Integer Update(Product product){
		return productDao.Update(product);
	}
	
	public List<Product> Read(){
		List<Product> chanels = new ArrayList<Product>();
		try{
			chanels = productDao.Read();
		}catch(Exception e){
		}
		return chanels;
	}
	
	public Product Read(String id){
		return productDao.Read(id);
	}
	
	public Integer Delete(Product product){
		return productDao.Delete(product);
	}
}
