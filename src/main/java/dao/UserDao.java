package dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.*;

import model.UserInfo;

public class UserDao {

	  private MongoTemplate mongoTemplate;  
	  
	/*private DBCollection GetDBCollection() {
		try {
			MongoClient mongoClient = new MongoClient("192.168.0.14");
			DB db = mongoClient.getDB("admin");
			boolean authenticate = db.authenticate("root","123456".toCharArray());

			if (authenticate) {
				DBCollection coll = db.getCollection("InjectionIndicate");
				
				 * DBObject myDoc = coll.findOne(); System.out.println(myDoc);
				 

				return coll;
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer Create(UserInfo userInfo) {
		DBCollection coll = this.GetDBCollection();

		BasicDBObject doc = new BasicDBObject("username", userInfo.getUserName())
				                      .append("password", userInfo.getPassword());
		WriteResult wr = coll.insert(doc);
		return 0;
	}

	public Integer Update(UserInfo userInfo) {
		return 0;
	}

	public List<UserInfo> Read() {
		ArrayList<UserInfo> userInfos = new ArrayList<UserInfo>();
		
		DBCollection coll = this.GetDBCollection();
		DBCursor cursor = coll.find();
		try {
		   while(cursor.hasNext()) {
		       UserInfo userInfo = new UserInfo();
			   DBObject obj = cursor.next();
			   if(obj.containsKey("username")){
			       String userName = (String) obj.get("username");
			       String password = (String) obj.get("password");
			       userInfo.setUserName(userName);
			       userInfo.setPassword(password);
			       userInfos.add(userInfo);
			   }
				   
		   }
		} finally {
		   cursor.close();
		}
		return userInfos;
	}

	public Integer Delete(UserInfo userInfo) {
		return 0;
	}*/
	  
		public MongoTemplate getMongoTemplate() {
			return mongoTemplate;
		}

		public void setMongoTemplate(MongoTemplate mongoTemplate) {
			this.mongoTemplate = mongoTemplate;
		}
		
		public Integer Create(UserInfo userInfo) {
			userInfo.setAddress("this is a address");
			getMongoTemplate().insert(userInfo);
			 return 0;
		}

		public Integer Update(UserInfo userInfo) {
			/*getMongoTemplate().updateFirst(new Query(Criteria.where("id").is(userInfo.id)), new Update().inc("age", 3));*/
			return 0;
		}

		public List<UserInfo> Read() {
			return getMongoTemplate().find(new Query(), UserInfo.class); 
		}

		public Integer Delete(UserInfo userInfo) {
			getMongoTemplate().remove(userInfo);
			return 0;
		}
}