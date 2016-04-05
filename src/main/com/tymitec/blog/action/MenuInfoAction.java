/**
 * 
 */
package blog.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.apache.struts2.StrutsStatics;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionContext;
import blog.data.*;
import blog.service.*;

/**
 * @author bret@tymitec.com
 * @version beta
 * @since 2015/09/20
 *
 */
public class MenuInfoAction {

	@Autowired
	private MenuInfoService service;
//	
//	private String account;
//	
//	public String getAccount() {
//		return account;
//	}
//
//	public void setAccount(String account) {
//		this.account = account;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	private String password;
//	
	public void GetMenuName() {
		try {
			ActionContext context = ActionContext.getContext();
			HttpServletResponse response = (HttpServletResponse) context
					.get(StrutsStatics.HTTP_RESPONSE);
			response.setContentType("application/json;charset=utf-8");
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods","GET");
			response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
			response.setCharacterEncoding("utf-8");
			
			PrintWriter pw = response.getWriter();
			
//			if(this.account.equals("bretwang") && this.password.equals("123456a?")){
//				pw.write("1");	
//			}else{
//				pw.write("0");
//			}
			Menuinfo info = service.findById(1);
			
			pw.write(info.getName());
			
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	
//	public void CreateAccount() {
//		try {
//			List<Account> users = userService.Read();
//
//			ActionContext context = ActionContext.getContext();
//			HttpServletResponse response = (HttpServletResponse) context
//					.get(StrutsStatics.HTTP_RESPONSE);
//			response.setContentType("application/json;charset=utf-8");
//			response.setCharacterEncoding("utf-8");
//
//			PrintWriter pw = response.getWriter();
//			String str = JSONArray.fromObject(users).toString();
//			pw.write(str);
//			pw.flush();
//			pw.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}
