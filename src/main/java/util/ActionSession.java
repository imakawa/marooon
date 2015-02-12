package util;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;

public class ActionSession {

	public static String CUR_USER = "CURRENT_LOGIN_USER_INFO";
	
	static Map<String, Object> session = null;
	
	private static Map<String, Object> getSession(){
		if(session != null) return session;
		
		session = ActionContext.getContext().getSession();
		return session;
	}
	
	public static void insert(String key,Object value){
		getSession().put(key, value);
	}
	
	public static boolean isInclude(String key){
		return getSession().containsKey(key);
	}
	
}