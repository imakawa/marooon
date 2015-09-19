package site16.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import site16.po.Account;

/**
 * @author bret@tymitec.com
 * @version beta
 * @since 2015/09/20
 *
 */
public class AccountDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	public Integer Create(Account account) {
		account.setAddress("this is a address");
		mongoTemplate.insert(account);
		return 0;
	}

	public Integer Update(Account account) {
		/*
		 * getMongoTemplate().updateFirst(new
		 * Query(Criteria.where("id").is(userInfo.id)), new Update().inc("age",
		 * 3));
		 */
		return 0;
	}

	public List<Account> Read() {
		return mongoTemplate.find(new Query(), Account.class);
	}

	public Integer Delete(Account account) {
		mongoTemplate.remove(account);
		return 0;
	}
}
