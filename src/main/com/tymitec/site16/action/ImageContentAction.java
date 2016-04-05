package site16.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.StrutsStatics;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;

import site16.service.ImageContentService;
import site16.service.ImageCommentService;
import site16.po.ImageContent;
import site16.po.ImageComment;
import site16.viewdata.ImageViewData;

/**
 * イメージAPI
 * @author bretwang
 * @since 2015/10/29
 * @version 1.0
 */
public class ImageContentAction {
	
//	@Autowired
//	private ImageContentService imageContentService;
//	
//	@Autowired
//	private ImageCommentService imageCommentService;
//	
//	//PageNum
//	private String p;
//		
//	public String getP() {
//		return p;
//	}
//
//	public void setP(String p) {
//		this.p = p;
//	}
//
//	/**public void InsertImageContents() {
//		for(int i = 2001; i < 3001; i++){
//			ImageContent image = new ImageContent();
//			image.setPath("res/region02/20150912_02001_1000");
//			image.setFileName("0" + i +".jpg");
//			image.setOrder(i+"");
//			imageContentService.Insert(image);
//		}
//	}*/
//	
//	public void ReadPage(){
//		ActionContext context = ActionContext.getContext();
//		HttpServletResponse response = (HttpServletResponse) context
//				.get(StrutsStatics.HTTP_RESPONSE);
//		response.setContentType("application/json;charset=utf-8");
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		response.setHeader("Access-Control-Allow-Methods","GET");
//		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
//		response.setCharacterEncoding("utf-8");
//		
//		try {
//			PrintWriter pw = response.getWriter();	
//			//TODO イメージコメントの情報を追加する
//			List<ImageContent> contents = imageContentService.ReadPage(Integer.parseInt(p), 16);
//			
//			List<ImageViewData> imageViewDatas = new ArrayList<ImageViewData>();
//			for(ImageContent content : contents){
//				ImageComment comment = imageCommentService.GetImageComment(content.getId());
//				imageViewDatas.add(new ImageViewData(content,comment));
//			}
//			
//			String json = JSONArray.fromObject(imageViewDatas).toString();
//			pw.write(json);
//			pw.flush();
//			pw.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void GetCount(){		
//		ActionContext context = ActionContext.getContext();
//		HttpServletResponse response = (HttpServletResponse) context
//				.get(StrutsStatics.HTTP_RESPONSE);
//		response.setContentType("application/json;charset=utf-8");
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		response.setHeader("Access-Control-Allow-Methods","GET");
//		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
//		response.setCharacterEncoding("utf-8");
//		
//		try {
//			PrintWriter pw = response.getWriter();	
//			
//			pw.write(imageContentService.getCount()+"");
//			pw.flush();
//			pw.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}
