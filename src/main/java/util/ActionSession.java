package util;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;

public class ActionSession {

	public static String CUR_USER = "CURRENT_LOGIN_USER_INFO";
	
	static Map<String, Object> SESSION = ActionContext.getContext().getSession();
	
	public static void insert(String key,Object value){
		SESSION.put(key, value);
	}
	
	public static boolean isInclude(String key){
		return SESSION.containsKey(key);
	}
}