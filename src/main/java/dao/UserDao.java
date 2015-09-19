package dao;

import java.util.List;

import model.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;


public class UserDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	public Integer Create(UserInfo userInfo) {
		userInfo.setAddress("this is a address");
		mongoTemplate.insert(userInfo);
		return 0;
	}

	public Integer Update(UserInfo userInfo) {
		/*
		 * getMongoTemplate().updateFirst(new
		 * Query(Criteria.where("id").is(userInfo.id)), new Update().inc("age",
		 * 3));
		 */
		return 0;
	}

	public List<UserInfo> Read() {
		return mongoTemplate.find(new Query(), UserInfo.class);
	}

	public Integer Delete(UserInfo userInfo) {
		mongoTemplate.remove(userInfo);
		return 0;
	}
}