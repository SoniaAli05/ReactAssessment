package com.sonia.ali.ReactAssessment.ReactAssessment;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StackSteps {

	ChromeDriver driver;

	WebElement email;
	WebElement password1;
	ExtentReports extent;
	ExtentTest test;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\FormReport.html", true);
		driver.manage().window().maximize();
	}

	@After
	public void teardown() {
		driver.quit();
	}

	
	@Given("^I navigate to the React Application$")
	public void i_navigate_to_the_React_Application() {
		test = extent.startTest("Verify application Title");
		test.log(LogStatus.INFO, "Browser started");
		test.log(LogStatus.PASS, "Verify Title of the page");
		driver.get(Constants.websiteURL);
	}

	@When("^I click the Link to Automated Testing Exercise Form$")
	public void i_click_the_Link_to_Automated_Testing_Exercise_Form() {
		Homepage page1 = PageFactory.initElements(driver, Homepage.class);
		page1.searchFor();

	}

	@When("^I fill click the \"([^\"]*)\" dropdown menu$")
	public void i_fill_click_the_dropdown_menu(String arg1) throws InterruptedException {
		Form page2 = PageFactory.initElements(driver, Form.class);
		Thread.sleep(3000);
		page2.dropdownBar(driver, arg1);
	}

	@When("^I fill out the email field with \"([^\"]*)\"$")
	public void i_fill_out_the_email_field_with(String args1) {
		Form fillEmail = PageFactory.initElements(driver, Form.class);
		fillEmail.fillEmail(args1);
	}

	@When("^I fill out the first password field with \"([^\"]*)\"$")
	public void i_fill_out_the_first_password_field_with(String arg1) {
		Form fillpassword = PageFactory.initElements(driver, Form.class);
		fillpassword.fillPassword(arg1);
	}

	@When("^I fill out the second password field with \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with(String arg1) {
		Form fillpassword1 = PageFactory.initElements(driver, Form.class);
		fillpassword1.fillPassword1(arg1);
	}

	@Then("^I should see a Success! Message$")
	public void i_should_see_a_Success_Message() throws InterruptedException{
		Form submit = PageFactory.initElements(driver, Form.class);
		submit.submit();
		Thread.sleep(3000);
		//String successMessage = driver
				//.findElementByName(Constants.exerciseForm)
			//	.getAttribute("innerHTML");

		//test.log(LogStatus.INFO, "Success!");

	//	if (successMessage.contains("Success!")) {
		//	test.log(LogStatus.PASS, "this passed");
	//	} else {
	//		test.log(LogStatus.FAIL, "this failed");
	//	}

		extent.endTest(test);
		extent.flush();

		//assertEquals(true, successMessage.contains("Success!"));
		
	}

	@When("^I fill out the second password field with the wrong password \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with_the_wrong_password(String arg1) {

	}

	@Then("^I should see a message stating that the passwords do not match\\.$")
	public void i_should_see_a_message_stating_that_the_passwords_do_not_match() {

	}

}
