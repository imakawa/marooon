package dao;

import java.util.List;

import model.GroupInfo;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

public class GroupDao {

	public GroupDao() {
		// TODO Auto-generated constructor stub
	}
	
	private MongoTemplate mongoTemplate;

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}  
	
	public Integer Create(GroupInfo group) {
		try{
			getMongoTemplate().insert(group);
		}catch(Exception e){
			return 0;
		}
		 return 1;
	}

	public Integer Update(GroupInfo group) {
		 getMongoTemplate().save(group);
		 return 0;
	}

	public List<GroupInfo> Read() {
		return getMongoTemplate().find(new Query(), GroupInfo.class); 
	}

	public Integer Delete(GroupInfo group) {
		return getMongoTemplate().remove(group).getN();
	}

}
