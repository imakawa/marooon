package dao;

import java.util.List;

import model.PopularProduct;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class PopularProductDao {

	public PopularProductDao() {
		// TODO Auto-generated constructor stub
	}

	private MongoTemplate mongoTemplate;

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}  
	
	public Integer Create(PopularProduct popularProduct) {
		try{
			getMongoTemplate().insert(popularProduct);
		}catch(Exception e){
			return 0;
		}
		 return 1;
	}

	public Integer Update(PopularProduct popularProduct) {
		 getMongoTemplate().save(popularProduct);
		 return 0;
	}

	public List<PopularProduct> Read() {
		return getMongoTemplate().find(new Query(), PopularProduct.class); 
	}

	public List<PopularProduct> ReadIndex() {
		return getMongoTemplate().find(new Query(Criteria.where("indexProduct").is("1")), PopularProduct.class); 
	}

	public List<PopularProduct> ReadHot() {
		return getMongoTemplate().find(new Query(Criteria.where("hotProduct").is("1")), PopularProduct.class);
	}
	
	public Integer Delete(PopularProduct popularProduct) {
		return getMongoTemplate().remove(popularProduct).getN();
	}
}
