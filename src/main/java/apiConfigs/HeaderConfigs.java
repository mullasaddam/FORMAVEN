package apiConfigs;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {
	
	
	public Map<String, String> defaultHeaders(){
		Map<String, String> defaultHeaders = new HashMap<String, String>();
		defaultHeaders.put("Content-Type", "application/json");
		return defaultHeaders;
		
	}
	
	
	public Map<String, String> headersWithCredentials(){
		Map<String, String> defaultHeaders = new HashMap<String, String>();
		defaultHeaders.put("Content-Type", "application/json");
		defaultHeaders.put("Access_Token", "tokenvalue");
		defaultHeaders.put("Access_key", "keyvalue");
		defaultHeaders.put("Tenant_user", "test");
		return defaultHeaders;
		
	}
	

	

}
