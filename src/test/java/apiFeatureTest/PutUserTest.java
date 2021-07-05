package apiFeatureTest;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiBuilders.PutAPIBuilder;
import apiConfigs.ApiPath;
import apiConfigs.HeaderConfigs;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PutUserTest extends BaseTest {
	HeaderConfigs header = new HeaderConfigs();
	PutAPIBuilder builder = new PutAPIBuilder();
	
	@Test
	public void updateUser() {
		test.log(LogStatus.INFO, "My updateUser test is starting.....");
	Response response = RestAssured.given().when().headers(header.defaultHeaders()).body(
			builder.putRequestBody("demonames","demojobs"))
			.when().put(ApiPath.apiPath.UPDATE_POST);
	
	APIVerification.responseKeyValidationFromJsonObject(response, "updatedAt");
	APIVerification.responseCodeValidation(response, 200);
    APIVerification.responseTimeValidation(response);
    test.log(LogStatus.INFO, "My updateUser test is ending.....");
}
}
