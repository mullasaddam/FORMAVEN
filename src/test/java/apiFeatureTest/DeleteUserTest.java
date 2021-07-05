package apiFeatureTest;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiConfigs.ApiPath;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteUserTest extends BaseTest {
	
	
	
	@Test
	public void deleteUser() {
		test.log(LogStatus.INFO, "My deleteUser test is starting.....");
		Response response =RestAssured
		.given().when().delete(ApiPath.apiPath.DELETE_SINGLE_POST);
		APIVerification.responseCodeValidation(response, 204);
		System.out.println(response.getBody().asString());
		
		test.log(LogStatus.INFO, "My deleteUser test is ending.....");
		}

}
