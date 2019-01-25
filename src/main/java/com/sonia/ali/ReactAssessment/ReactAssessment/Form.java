package com.sonia.ali.ReactAssessment.ReactAssessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Form {
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/button")
	private WebElement country;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[1]")
	private WebElement uk1;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[2]")
	private WebElement f1;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[3]")
	private WebElement g1;
	@FindBy(xpath = "//*[@id=\"nameInput\"]")
	private WebElement email;
	@FindBy(xpath = "//*[@id=\"passInput\"]")
	private WebElement password;
	@FindBy(xpath = "//*[@id=\"passInput2\"]")
	private WebElement password1;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/button")
	private WebElement submit;

	public void dropdownBar(WebDriver driver, String arg1) {

		Actions action = new Actions(driver);
		action.moveToElement(country).click().perform();
		
		if (country.equals("United Kingdom")) {
			uk1.click();
		}
		if (country.equals("France")) {
			f1.click();
		}
		if (country.equals("Germany")) {
			g1.click();
		}
	}

	public void fillEmail(String args1) {
		email.sendKeys(args1);
	}

	public void fillPassword(String arg1) {
		password.sendKeys(arg1);
	}

	public void fillPassword1(String arg1) {
		password1.sendKeys(arg1);
	}
	
	public void submit() {
		submit.click();
	}
}
