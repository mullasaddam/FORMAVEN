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
import pojo.PostAPIPojo;


public class PostUsersTestwithPojo extends BaseTest {
	
	HeaderConfigs header = new HeaderConfigs();
	PostAPIBuilder builder = new PostAPIBuilder();
	PostAPIPojo pojo = new PostAPIPojo("pojoname", "pojojob");
	@Test
	public void createUser() {
		test.log(LogStatus.INFO, "My createUser test is starting.....");
	Response response = RestAssured.given().when().headers(header.defaultHeaders()).body(pojo)
			.when().post(ApiPath.apiPath.CREATE_POST);
	
	System.out.println(response.getBody().asString());
	APIVerification.responseCodeValidation(response, 201);
	System.out.println(pojo.getJob());
	System.out.println(pojo.getName());
	test.log(LogStatus.INFO, "My createUser test is ending.....");
	
	}

}
