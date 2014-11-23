package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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
		List<Product> products = new ArrayList<Product>();
		try{
			products = productDao.Read();
		}catch(Exception e){
		}
		return products;
	}
	
	public List<Product> ReadByChanel(String chanelId){
		return productDao.ReadByChanel(chanelId);
	}
	
	public Product Read(String id){
		return productDao.Read(id);
	}
	
	public Integer Delete(Product product){
		return productDao.Delete(product);
	}
}
