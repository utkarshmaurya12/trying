package com.app.Junit.Lesson4project;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LessonProject {


	// Create your own annotation and use
	// Add displayname annotation
	// repeat the test case 3 times
	// Make it a parmeterized test using csvsource
	
	WebDriver driver;
	
	@BeforeAll
	public void startbrowser()
	{
        driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
	}
	
	@ParameterizedTest(name = "CSV source {arguments}")
	
	@CsvSource({
		"admin ,  admin@125",		
})
	
	
	@DisplayName("Facebook Login")
	//@RepeatedTest(2)
	public void Testmethod(String username, String pwd)
	{
        driver.findElement(By.cssSelector("input#email")).sendKeys(username);
		
		driver.findElement(By.cssSelector("input[name='pass']")).sendKeys(pwd);
	}

	
	@AfterAll
	public void closebrowser()
	{
		driver.close();
	}
	
}
	

