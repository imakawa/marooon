package dao;

import java.util.List;

import model.Chanel;
import model.Product;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class ChanelDao {

	private MongoTemplate mongoTemplate;

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}  
	
	public Integer Create(Chanel chanel) {
		try{
			getMongoTemplate().insert(chanel);
		}catch(Exception e){
			return 0;
		}
		 return 1;
	}

	public Integer Update(Chanel chanel) {
		/*return getMongoTemplate().updateFirst(
				new Query(Criteria.where("id").is(chanel.getId())),
				new Update().set("name", chanel.getName()), Chanel.class)
				.getN();*/
		
		 getMongoTemplate().save(chanel);
		 return 0;
	}

	public List<Chanel> Read() {
		return getMongoTemplate().find(new Query(), Chanel.class); 
	}
	
	public Chanel Read(String id){
		return getMongoTemplate().findById(id, Chanel.class);
	}
	
	public Integer Delete(Chanel chanel) {
		return getMongoTemplate().remove(chanel).getN();
	}
}
