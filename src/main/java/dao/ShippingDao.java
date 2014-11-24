package dao;

import java.util.List;

import model.Shipping;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

public class ShippingDao {

	public ShippingDao() {
		// TODO Auto-generated constructor stub
	}

	private MongoTemplate mongoTemplate;

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}  
	
	public Integer Create(Shipping shipping) {
		try{
			getMongoTemplate().insert(shipping);
		}catch(Exception e){
			return 0;
		}
		 return 1;
	}

	public Integer Update(Shipping shipping) {
		 getMongoTemplate().save(shipping);
		 return 0;
	}

	public List<Shipping> Read() {
		return getMongoTemplate().find(new Query(), Shipping.class); 
	}
	
	public Shipping Read(String id){
		return this.mongoTemplate.findById(id, Shipping.class);
	}
	
	public Integer Delete(Shipping shipping) {
		return getMongoTemplate().remove(shipping).getN();
	}
}
