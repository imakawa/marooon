package Interceptor;

import javax.servlet.http.HttpServletResponse;

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
		System.out.println(invocation.getAction().toString());
		System.out.println(invocation.getAction().getClass().toString());
		String actionName = invocation.getAction().getClass().toString();
		
		if (actionName.contains("IndexAction")){
			ActionContext context = ActionContext.getContext();
			HttpServletResponse response = (HttpServletResponse) context.get(StrutsStatics.HTTP_RESPONSE);
			response.sendRedirect("shop"); 
		}
		return null;
	}

}
