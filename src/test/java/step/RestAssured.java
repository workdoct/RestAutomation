package step;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import net.thucydides.core.annotations.Steps;
import page.GetApiResponse;

public class RestAssured {


	@Steps
	GetApiResponse responsePage;
	
	@Given("User should be application Platform <URL>")
	public void userShouldBeOnApplicationPlatform(@Named("URL") String strURL) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Given("Application Test")
	public void applicationTest() {
	//	System.out.println("Application Test");
	}

	@When("user enter username <USERNAME>")
	public void userEnterUsername(@Named("USERNAME") String strUsername) {
//		loginFlow.setUserName(strUsername);
	}

	@When("enter password <PASSWORD> and click on submit button")
	public void enterpasswordAndClickOnSubmitButton(@Named("PASSWORD") String strPassword) {
//		loginFlow.setPassword(strPassword);
//		loginFlow.clickLoginButton();
	}

	@Then("HomePage should be displayed")
	public void homepageShouldBeDisplayed() {
//		loginFlow.verifyHomePageTitle();
	}


/*	@AsParameters
	public static class MyParameters {
		@Parameter(name = "aString")
		private String string;
		@Parameter(name = "anInteger")
		private Integer integer;
		@Parameter(name = "aBigDecimal")
		private BigDecimal bigDecimal;
	}*/

}
