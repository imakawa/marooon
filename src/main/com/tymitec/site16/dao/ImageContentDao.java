package site16.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.*;
//import org.springframework.data.mongodb.core.query.*;
import site16.po.ImageContent;

/**
 * イメージ情報Dao
 * 
 * @author bretwang
 * @since 2015/10/29
 * @version 1.0
 */
public class ImageContentDao {
	
//	@Autowired
//	private MongoTemplate mongoTemplate;
//	
//	//イメージはDBに追加する
//	public Integer Create(ImageContent image) {
//		mongoTemplate.insert(image);
//		return 0;
//	}
//	
//	/**
//	 * イメージはDBから読み込む 
//	 * @param pageNum
//	 * @param pageSize
//	 * @return
//	 */
//	public List<ImageContent> ReadPage(int pageNum, int pageSize) {
//		System.out.println("123");
//		if(pageNum == 1){
//			return mongoTemplate.find(new Query().limit(pageSize), ImageContent.class);
//		}else{
//			return mongoTemplate.find(new Query().skip((pageNum - 1) * pageSize).limit(pageSize), ImageContent.class);	
//		}
//	}
//	
//	/**
//	 * 获取总行数（分页用）
//	 * @return 总行数
//	 */
//	public Long getCount(){
//		return mongoTemplate.count(new Query(), ImageContent.class);
//	}
}
