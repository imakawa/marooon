/**
 * 
 */
package com.tymitec.site16.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.StrutsStatics;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;

import com.tymitec.site16.service.UserService;
import com.tymitec.site16.model.UserInfo;

/**
 * @author bretwang
 *
 */
public class AccountAction {

	@Autowired
	private UserService userService;

	public void CreateAccount() {
		try {
			List<UserInfo> users = userService.Read();

			ActionContext context = ActionContext.getContext();
			HttpServletResponse response = (HttpServletResponse) context
					.get(StrutsStatics.HTTP_RESPONSE);
			response.setContentType("application/json;charset=utf-8");
			response.setCharacterEncoding("utf-8");

			PrintWriter pw = response.getWriter();
			String str = JSONArray.fromObject(users).toString();
			pw.write(str);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
