package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObject.AddCustomerPage;
import pageObject.LoginPage;

public class Steps extends BaseClass {
	


@Given("User Launch Chrome Browser")
public void user_launch_chrome_browser() {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Driver/chromedriver.exe");
	
	driver= new ChromeDriver();
    lp=new LoginPage(driver);
}


//login step definition

@When("User Opens URL {string}")
public void user_opens_url(String url) {
	driver.get(url);
	driver.manage().window().maximize();
    
}

@When("User Enters Email as {string} and Password as {string}")
public void user_enters_email_as_and_password_as(String uname, String password) {
    lp.setUserName(uname);
    lp.setPassword(password);
}

@When("Click On Login")
public void click_on_login() throws InterruptedException {
  lp.clickLogin();
  Thread.sleep(3000);
}

@Then("Page Title Should be {string}")
public void page_title_should_be(String title) throws InterruptedException {

	
	if (driver.getPageSource().contains("Login was unsuccessful.")) {
		driver.close();
		Assert.assertTrue(false);
	}else {
			Assert.assertEquals(title,driver.getTitle());
		}
	Thread.sleep(3000);
	}



@When("User Click On Logout link")
public void user_click_on_logout_link() throws InterruptedException {
  lp.clickLogout();
  Thread.sleep(3000);
}



@Then("Close Browser")
public void close_browser() {
    driver.quit();
}



//customer feature step definition

@Then("User can view Dashboard")
public void user_can_view_dashboard() {
    addCust=new AddCustomerPage(driver);
    Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
}
@When("User clicks on customer menu")
public void user_clicks_on_customer_menu() throws InterruptedException {
	Thread.sleep(3000);
	addCust.clickOnCustomersMenu();
} 
@When("click on customers menu Item")
public void click_on_customers_menu_item() throws InterruptedException {
	Thread.sleep(2000);
	addCust.clickOnCustomersMenuItem();
   
}
@When("click on add new button")
public void click_on_add_new_button() throws InterruptedException {
    addCust.clickOnAddnew();
    Thread.sleep(2000);
}
@Then("user can view add new customer page")
public void user_can_view_add_new_customer_page() {
   Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
}
@When("user enter customer info")
public void user_enter_customer_info() throws InterruptedException {
    String email=randomestring()+"@gmail.com";
    addCust.setEmail(email);
    addCust.setPassword("test123");
    
 // Registered - default
    //The customer cannot be both 'Guest' and 'Registered' customer roles
    //Add the customer to 'Guests' or 'Registered' customer role
    addCust.setCustomerRoles("Guest");
    Thread.sleep(3000);
 
    addCust.setManagerOfVendor("Vendor 2");
    addCust.setGender("Female");
    addCust.setFirstName("Dani");
    addCust.setLastName("Chowdhury");
    addCust.setdob("01/01/1988");
    addCust.setCompanyName("busyQA");
    addCust.setAdminContent("This is for testing.......");
}
@When("click on save button")
public void click_on_save_button() throws InterruptedException {
	addCust.clickInSave();
	Thread.sleep(2000);
  
}
@Then("User can view confirmation message {string}")
public void user_can_view_confirmation_message(String msg) {
	Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
			.contains("The new customer has been added successfully"));
    
}




}
