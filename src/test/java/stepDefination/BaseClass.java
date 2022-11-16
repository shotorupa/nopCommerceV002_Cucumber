package stepDefination;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObject.AddCustomerPage;
import pageObject.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addCust;
	
	//created for generating rendom string for Unique email
	   public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
	    return (generatedString1);
	}   

}
