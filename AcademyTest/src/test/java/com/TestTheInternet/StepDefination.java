package com.TestTheInternet;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefination {
	
	WebDriver driver;
	String baseUrl="http://the-internet.herokuapp.com/";
	WebElement userName;
	WebElement password;
	WebElement login;
	String keyFirst;
	
	
	
	
	
	
	@Given("^I am on the login page$")
	public void i_am_on_the_login_page() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='content']/ul/li[18]/a")).click();
		
		
	   
	}

	@When("^I enter valid username$")
	public void i_enter_valid_username() {
		
		userName = driver.findElement(By.xpath(".//input[@id='username']"));
		userName.sendKeys("tomsmith");
		
	 
	}

	@And("^I enter invalid password$")
	public void i_enter_invalid_password() {
		
		password = driver.findElement(By.xpath(".//input[@id='password']"));
		password.sendKeys("ABC");
	   
	}

	@And("^Click on Login$")
	public void click_on_Login() {
		
		login = driver.findElement(By.xpath(".//*[@id='login']/button"));
		login.click();
	   
	}
	
	
	
	@When("^I enter invalid username$")
	public void i_enter_invalid_username() {
		
		userName=driver.findElement(By.xpath(".//input[@id='username']"));
		userName.sendKeys("ABC");
	
	}

	@And("^I enter valid password$")
	public void i_enter_valid_password() {
		
		
		password = driver.findElement(By.xpath(".//input[@id='password']"));
		password.click();
		password.sendKeys("SuperSecretPassword!");
	 
	}
	

	
	
	
	@Then("^validate Login Assertion \"([^\"]*)\"$")
	public void validate_Login_Assertion(String expected) throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		String actual = driver.findElement(By.xpath(".//div[@id='flash-messages']")).getText();
		
		System.out.println("text is --->>>" + actual);
			
		assertTrue(actual.contains(expected));
			
			Thread.sleep(5000);
			
			driver.close();
	}
	
	@Then("^Click on Logout Button$")
	public void click_on_Logout_Button() {
		
		
	 driver.findElement(By.xpath(".//div[@id='content']/div/a/i")).click();
	 
	 driver.close();
	 
	}
/////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Given("^Navigate to given URL$")
	public void navigate_to_given_URL() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		
		driver.manage().window().maximize();
		
	   
	}

	@When("^I click on Infinite scroll on Menu$")
	public void i_click_on_Infinite_scroll_on_Menu() {
		
		driver.findElement(By.linkText("Infinite Scroll")).click();
		
	 
	}

	@And("^scroll to the bottom of the page twice$")
	public void scroll_to_the_bottom_of_the_page_twice() throws InterruptedException {
		
		Thread.sleep(1000);
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//js.executeScript("window.scrollTo(0, document.body.)");
		Thread.sleep(3000);
		
	   
	}

	@And("^scroll back to the top of the page$")
	public void scroll_back_to_the_top_of_the_page() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement ele =driver.findElement(By.xpath("//h3"));
		js.executeScript("arguments[0].scrollIntoView();",ele );
	}
	
	@Then("^validate assertation value \"([^\"]*)\"$")
	public void validate_assertation_value(String expectedMessage) throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		String actualMessage = driver.findElement(By.xpath("//h3")).getText();
		
		System.out.println("Actule Text is --->" + actualMessage);
		
		assertTrue(actualMessage.contains(expectedMessage));
		
		Thread.sleep(3000);
		
		driver.close();
		
	}
	
	
	@Given("^I am on Key press page$")
	public void i_am_on_Key_press_page() {
		
		driver.findElement(By.xpath(".//div[@id='content']/ul/li[27]/a")).click();

	}
	
	
	@When("^I press on key \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void i_press_on_key(String expectedkeyFirst, String expectedkeySecond, String expectedkeyThird, String expectedkeyFourth) throws InterruptedException {
		
		
		Actions action = new Actions(driver);
		
		action.sendKeys(Keys.ENTER).build().perform();
		String actualKeyFirst = driver.findElement(By.xpath(".//p[@id='result']")).getText();
		assertTrue(actualKeyFirst.contains(expectedkeyFirst));
		//Assert.assertEquals(actualKeyFirst,expectedkeyFirst);
		String expectedColour1 = "green";
		String colorString = driver.findElement(By.id("result")).getAttribute("style");
		System.out.println( "colour is -->"+colorString);
		assertTrue(colorString.contains(expectedColour1));
		System.out.println("Firstkey test is successfull");
		
		Thread.sleep(3000);
		
		//Actions action = new Actions(driver);
		action.sendKeys(Keys.CONTROL).build().perform();
		String actualKeySecond = driver.findElement(By.xpath(".//p[@id='result']")).getText();
		assertTrue(actualKeySecond.contains(expectedkeySecond));
		//Assert.assertEquals(actualKeySecond, expectedkeySecond);
		String expectedColour2 = "green";
		//String colorString = driver.findElement(By.id("result")).getAttribute("style");
		System.out.println( "colour is -->"+colorString);
		assertTrue(colorString.contains(expectedColour2));
		System.out.println("Secondkey test is successfull");
		
		Thread.sleep(3000);
		
		
		//Actions action = new Actions(driver);
		action.sendKeys(Keys.ALT).build().perform();
		String actualKeyThird = driver.findElement(By.xpath(".//p[@id='result']")).getText();
		assertTrue(actualKeyThird.contains(expectedkeyThird));
		//Assert.assertEquals(actualKeyThird, expectedkeyThird);
		String expectedColour3 = "green";
		//String colorString = driver.findElement(By.id("result")).getAttribute("style");
		System.out.println( "colour is -->"+colorString);
		assertTrue(colorString.contains(expectedColour3));
		System.out.println("Thirdkey test is successfull");
		
		
		Thread.sleep(3000);
		
		//Actions action = new Actions(driver);
		action.sendKeys(Keys.SHIFT).build().perform();
		String actualKeyFourth = driver.findElement(By.xpath(".//p[@id='result']")).getText();
		assertTrue(actualKeyFourth.contains(expectedkeyFourth));
		//Assert.assertEquals(actualKeyFourth, expectedkeyFourth);
		String expectedColour4 = "green";
		//String colorString = driver.findElement(By.id("result")).getAttribute("style");
		System.out.println( "colour is -->"+colorString);
		assertTrue(colorString.contains(expectedColour4));
		System.out.println("Fourthkey test is successfull");
		

		
	}

	@Then("^Confirm Success and close the broweser$")
	public void confirm_Success_and_close_the_broweser() {
		
		System.out.println("All defined keys been pressd and assertion been done for displayed text and colour of text after each key press");
		
		driver.close();
		
	    
	}
	
}

	
	



