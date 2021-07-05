package apiFeatureTest;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiBuilders.PostAPIBuilder;
import apiConfigs.ApiPath;
import apiConfigs.HeaderConfigs;
import apiVerifications.APIVerification;
import baseTest.BaseTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.JavaUtilis;

public class PostUsersTest extends BaseTest {
	
	HeaderConfigs header = new HeaderConfigs();
	PostAPIBuilder builder = new PostAPIBuilder();
	
	@Test
	public void createUser() {
		test.log(LogStatus.INFO, "My createUser test is starting.....");
	Response response = RestAssured.given().when().headers(header.defaultHeaders()).body(
			builder.postRequestBody(JavaUtilis.randomStrig(),JavaUtilis.randomStrig()))
			.when().post(ApiPath.apiPath.CREATE_POST);
	
    APIVerification.responseCodeValidation(response, 201);
	System.out.println(response.getBody().asString());
	test.log(LogStatus.INFO, "My createeUser test is ending.....");
	
	}

}
