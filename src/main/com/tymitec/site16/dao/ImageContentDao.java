package site16.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import site16.po.ImageContent;

public class ImageContentDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Integer Create(ImageContent image) {
		mongoTemplate.insert(image);
		return 0;
	}
	
	public List<ImageContent> ReadPage(int pageNum, int pageSize) {
		if(pageNum == 1){
			return mongoTemplate.find(new Query().limit(pageSize), ImageContent.class);
		}else{
			return mongoTemplate.find(new Query().skip((pageNum - 1) * pageSize).limit(pageSize), ImageContent.class);	
		}
	}
}
