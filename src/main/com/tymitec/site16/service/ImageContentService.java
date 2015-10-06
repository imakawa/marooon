package site16.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import site16.dao.ImageContentDao;
import site16.po.ImageContent;

public class ImageContentService {
	
	@Autowired
	private ImageContentDao imageContentDao;
	
	public void Insert(ImageContent image){
		imageContentDao.Create(image);
	}
	
	public List<ImageContent> ReadPage(int pageNum, int pageSize){
		return imageContentDao.ReadPage(pageNum, pageSize);
	}
}
