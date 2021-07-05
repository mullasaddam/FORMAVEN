package apiFeatureTest;


import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiConfigs.ApiPath;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleUserTest extends BaseTest {
	
	@Test
	public void getSingleUser() {
		test.log(LogStatus.INFO, "My getSingleUser test is starting.....");
		Response response =RestAssured
		.given().when().get(ApiPath.apiPath.GET_SINGLE_POST);
		APIVerification.getKeyValueAndPrintFromJsonObject(response,"data","email");
		APIVerification.responseCodeValidation(response, 200);
		test.log(LogStatus.INFO, "My getSingleUser test is ending.....");
		}	

}
