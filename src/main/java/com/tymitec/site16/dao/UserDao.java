package com.tymitec.site16.dao;

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