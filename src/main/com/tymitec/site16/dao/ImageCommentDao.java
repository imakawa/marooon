package site16.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;*/

import site16.po.ImageComment;

/**
 * イメージコメント情報Dao
 * 
 * @author bretwang
 * @since 2015/10/29
 * @version 1.0
 */
public class ImageCommentDao {
	/*
	@Autowired
	private MongoTemplate mongoTemplate;

	public ImageComment GetImageComment(String imageId){
		List<ImageComment> comments  = mongoTemplate.find(new Query(Criteria.where("imgId").is(imageId)), ImageComment.class);
		
		if(comments.isEmpty()){
			ImageComment comment =  new ImageComment();
			comment.setImgId(imageId);
			return comment;
		}else{
			return comments.get(0);	
		}
	}
	
	*//**
	 * TODO　更新はDelete、Insertに変更する
	 * @param imageId
	 *//*
	public void up(String imageId){
		ImageComment comment = GetImageComment(imageId);
		comment.setUp(comment.getUp() + 1);
		
		mongoTemplate.remove(new Query(Criteria.where("imgId").is(imageId)), ImageComment.class);
		mongoTemplate.insert(comment);
		
	}
	
	*//**
	 * TODO　更新はDelete、Insertに変更する
	 * @param imageId
	 *//*
	public void down(String imageId){
		ImageComment comment = GetImageComment(imageId);
		comment.setDown(comment.getDown() + 1);
		
		mongoTemplate.remove(new Query(Criteria.where("imgId").is(imageId)), ImageComment.class);
		mongoTemplate.insert(comment);
	}*/
	
}
