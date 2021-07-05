package apiBuilders;

import java.util.HashMap;
import java.util.Map;

public class PutAPIBuilder {
	
	public Map<String, String> putRequestBody(String name, String job){
		Map<String, String> body = new HashMap<String, String>();
		body.put("name", name);
		body.put("job", job);
		return body;
		
	}

}
