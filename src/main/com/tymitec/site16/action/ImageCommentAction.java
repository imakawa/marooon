package site16.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.StrutsStatics;
import org.springframework.beans.factory.annotation.Autowired;

import site16.po.ImageComment;
import site16.po.ImageContent;
import site16.service.ImageCommentService;
import site16.viewdata.ImageViewData;

import com.opensymphony.xwork2.ActionContext;

/**
 * TODO イメージ操作アクション実装
 * TODO　confファイル改修
 * @author bretwang
 */
public class ImageCommentAction {
	
//	@Autowired
//	private ImageCommentService imageCommentService;
//	
//	private String param;
//	
//	public String getParam() {
//		return param;
//	}
//	
//	public void setParam(String param) {
//		this.param = param;
//	}
//	
//	public void Execute(){
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
//			String[] strs = param.split("/");
//			String imageId = strs[1];
//			if(strs[0].equals("true")){
//				imageCommentService.up(imageId);
//			}else{
//				imageCommentService.down(imageId);
//			}
//			
//			ImageComment comment = imageCommentService.GetImageComment(imageId);
//			
//			String json = JSONArray.fromObject(comment).toString();
//			pw.write(json);
//			pw.flush();
//			pw.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}
