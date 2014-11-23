package dao;

import java.util.List;

import model.Product;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class ProductDao {

	public ProductDao() {
		// TODO Auto-generated constructor stub
	}
	
	private MongoTemplate mongoTemplate;

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}  
	
	public Integer Create(Product product) {
		try{
			getMongoTemplate().insert(product);
		}catch(Exception e){
			return 0;
		}
		 return 1;
	}

	public Integer Update(Product product) {
		 getMongoTemplate().save(product);
		 return 0;
	}

	public List<Product> Read() {
		return getMongoTemplate().find(new Query(), Product.class); 
	}
	
	public Product Read(String id){
		return this.mongoTemplate.findById(id, Product.class);
	}

	public List<Product> ReadByChanel(String chanelId){
		return this.mongoTemplate.find(new Query(Criteria.where("chanelId").is(chanelId)), Product.class);
	}
	
	public Integer Delete(Product product) {
		return getMongoTemplate().remove(product).getN();
	}
}
