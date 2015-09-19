package com.tymitec.site16.Interceptor;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AddressInterceptor extends AbstractInterceptor {

	public AddressInterceptor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		String actionName = invocation.getAction().getClass().toString();
		
		if (actionName.contains("IndexAction")){
			ActionContext context = ActionContext.getContext();
			HttpServletResponse response = (HttpServletResponse) context.get(StrutsStatics.HTTP_RESPONSE);
			String ipadd=ServletActionContext.getRequest().getRemoteAddr();
			System.out.println("Index:"+ipadd);
			response.sendRedirect("shop"); 
		}
		return null;
	}

}
