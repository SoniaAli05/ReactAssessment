package com.sonia.ali.ReactAssessment.ReactAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {
	@FindBy(xpath ="//*[@id=\"root\"]/div/ul/li[10]/a")
	private WebElement form;
	@FindBy(xpath ="//*[@id=\"root\"]/div/div/input[1]")
	private WebElement name;
	
	public void searchFor() {
		form.click();
		name.sendKeys("heynow");
	}
}
