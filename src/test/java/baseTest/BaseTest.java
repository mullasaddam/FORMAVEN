package baseTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import io.restassured.RestAssured;
import utils.ExtentReportListener;
import utils.GetEnvInfo;

@Listeners(ExtentReportListener.class)
public class BaseTest extends ExtentReportListener {
	
	@BeforeClass
    public void baseTest() {
		
		RestAssured.baseURI = GetEnvInfo.envAndFile().get("ServerUrl");
	}
	
	

}
