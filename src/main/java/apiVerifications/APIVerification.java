package apiVerifications;

import static org.testng.Assert.assertTrue;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import utils.ExtentReportListener;

public class APIVerification extends ExtentReportListener {

	public static void responseCodeValidation(Response response, int statusCode) {

		try {
			Assert.assertEquals(statusCode, response.getStatusCode());
			test.log(LogStatus.PASS,"Successfully validated status code, status code is :: " + response.getStatusCode());
			System.out.println("Successfully validated status code, status code is ::"+response.getStatusCode() );
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			test.log(LogStatus.FAIL,
					"Expected status code is :: " + statusCode + " , insted of getting :: " + response.getStatusCode());
		
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}

	public static void responseKeyValidationfromArray(Response response, String key) {
		try {
			JSONArray array = new JSONArray(response.getBody().asString());
			for(int i=0; i<array.length();i++) {
				JSONObject obj = array.getJSONObject(i);
				test.log(LogStatus.PASS, "Valideted values are  " + obj.get(key));
                System.out.println("Valideted values are  "+obj.get(key));
				
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}
	
	public static void getKeyValueAndPrintFromJsonObject(Response response,String outerKey,String key) {
		
		JSONObject obj_first = new JSONObject(response.getBody().asString());
		JSONObject obj=obj_first.getJSONObject(outerKey);
	    Assert.assertNotNull(obj.get(key));
		System.out.println(obj.get(key));
		
	}
	public static void responseKeyValidationFromJsonObject(Response response, String key) {
		try {
			JSONObject json = new JSONObject(response.getBody().asString());
			if(json.has(key) && json.get(key)!= null) {
				test.log(LogStatus.PASS, "Sucessfully validated value of " + key + " It is " + json.get(key));
				  System.out.println("Valideted value of  "+ json.get(key));
			}else {
				test.log(LogStatus.FAIL,"Key is not available");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}
	
	
	public static void responseTimeValidation(Response response) {
		try {
			long time=response.time();
			test.log(LogStatus.INFO, "Api response time is :: " + time);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}

}
