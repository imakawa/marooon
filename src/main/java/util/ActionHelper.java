package util;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.apache.struts2.StrutsStatics;
import com.opensymphony.xwork2.ActionContext;

public class ActionHelper {

	private ActionContext context = null;
	
	/**
	 * コンストラクター
	 */
	public ActionHelper() {
		context = ActionContext.getContext();
	}
	
	/**
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest(){
		if(context == null) return null;
		
		return (HttpServletRequest) context.get(StrutsStatics.HTTP_REQUEST);
	}
	
	/**
	 * 
	 * @return
	 */
	public HttpServletResponse getResponse(){
		if(context == null) return null;
		HttpServletResponse response = (HttpServletResponse) context.get(StrutsStatics.HTTP_RESPONSE);
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		return response;
	}
	
	/**
	 * 
	 * @param field
	 * @return
	 */
	public String getParam(String field){
		HttpServletRequest request = this.getRequest();
		if(request == null) return "";
		return request.getParameter(field);
	}
	
	/**
	 * 
	 * @param datas
	 * @throws Exception
	 */
	public void writeJson(Object datas) throws Exception{
		HttpServletResponse response = this.getResponse();
		if(response == null) throw new Exception();
		
		PrintWriter pw = response.getWriter();
		pw.write(JSONArray.fromObject(datas).toString());
		pw.flush();
		pw.close();
	}
	
}
