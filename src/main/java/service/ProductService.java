package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import model.CommentInfo;
import model.PriceInfo;
import model.Product;
import dao.ProductDao;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import util.ProductCompare;

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
		
		/*Product productdo =parseProduct(product.getName(),product.getChanelId());*/
		
		return productDao.Create(product);
		/*return productDao.Create(parseProduct(product.getName(),product.getChanelId()));*/
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
		List<Product> products = productDao.ReadByChanel(chanelId);
		
		Collections.sort(products, new ProductCompare());
		return products;
	}
	
	public List<Product> ReadByKeyword(String keyword){
		List<Product> products =productDao.ReadByKeyword(keyword);

		Collections.sort(products, new ProductCompare());
		return products;
	}
	
	public Product Read(String id){
		return productDao.Read(id);
	}
	
	public Integer Delete(Product product){
		return productDao.Delete(product);
	}
	
	private Product parseProduct(String url,String chanelId){
		Product product = new Product();
		product.setChanelId(chanelId);
		
		try {
			Document doc = Jsoup.connect(url).get();
			
			Element eName = doc.getElementById("products_maintitle");
		 	product.setName(eName.html());
		 	
		 	Element ePrice = doc.getElementById("js_scl_unitPrice");
		 	PriceInfo price = new PriceInfo();
		 	price.setPrice1(ePrice.html());
		 	product.setPrice(price);
		 	System.out.println(ePrice.html());
		 	
		 	Element eDes1 = doc.getElementById("pinfo_productSummury");
		 	CommentInfo commentInfo = new CommentInfo();
		 	commentInfo.setChInfo(eDes1.html());
		 	product.setDescripe1(commentInfo);
		 	System.out.println(product.getDescripe1().getChInfo());
		 	
		 	
		 	Element eDes2 = doc.getElementById("productSet1Box");
		 	CommentInfo commentInfo2 = new CommentInfo();
		 	commentInfo2.setChInfo(eDes2.toString());
		 	product.setDescripe2(commentInfo2);
		 	System.out.println(eDes2.html());
		 	
		 	Elements eDes3 = doc.getElementsByClass("specBox");
		 	CommentInfo commentInfo3 = new CommentInfo();
		 	commentInfo3.setChInfo(eDes3.first().toString());
		 	product.setDescripe3(commentInfo3);

		 	System.out.println(eDes3.html());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*Elements newsHeadlines = doc.select("#mp-itn b a");*/
		/*System.out.println(doc.title());*/
		
		/*Element e = doc.getElementById("js_scl_unitPrice");
		System.out.println(e.toString()+" u ef  "+e.html());
		<strong class="red fs16 alignM" id="js_scl_unitPrice">￥2,370</strong> u ef  ￥2,370*/
		
		
		return product;
	}
	
}
