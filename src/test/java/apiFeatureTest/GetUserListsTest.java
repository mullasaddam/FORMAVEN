package apiFeatureTest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiConfigs.ApiPath;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUserListsTest extends BaseTest {
	
	@Test
	public void getListUsers() {
		test.log(LogStatus.INFO, "My getListUsers test is starting.....");
		Response response =RestAssured
		.given().when().get(ApiPath.apiPath.GET_LIST_OF_POSTS);
	    APIVerification.responseCodeValidation(response, 200);
		System.out.println(response.getBody().asString());
		JSONObject personData = new JSONObject(response.getBody().asString());
	    int resultCount = personData.optInt("result_count");
	    System.out.println("Result Count: "+Integer.toString(resultCount));

	    JSONArray dataArray = personData.optJSONArray("data");
	    for( int i = 0; i < dataArray.length(); i++)
	    {
	        JSONObject img= dataArray.getJSONObject(i);
	        String email = img.optString("email");
	      
	        System.out.println(" Email: "+ email);
		
		}
	    test.log(LogStatus.INFO, "My getDeleteUser test is ending.....");
	}	
	}


