package dao;

import java.util.List;
import model.Exchange;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

public class ExchangeDao {

	public ExchangeDao() {
		// TODO Auto-generated constructor stub
	}
	
	private MongoTemplate mongoTemplate;
	public MongoTemplate getMongoTemplate() {return mongoTemplate;}
	public void setMongoTemplate(MongoTemplate mongoTemplate) {this.mongoTemplate = mongoTemplate;}  
	
	public Integer Create(Exchange exchange) {
		try{
			getMongoTemplate().insert(exchange);
		}catch(Exception e){
			return 0;
		}
		 return 1;
	}
	
	public Integer Update(Exchange exchange) {
		 getMongoTemplate().save(exchange);
		 return 0;
	}

	public List<Exchange> Read() {
		return getMongoTemplate().find(new Query(), Exchange.class); 
	}
	
	public Exchange Read(String id){
		return getMongoTemplate().findById(id, Exchange.class);
	}
	
	public Integer Delete(Exchange exchange) {
		return getMongoTemplate().remove(exchange).getN();
	}

}
