package feature.webclient;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HangmanSteps {
	

	WebDriver driver = new ChromeDriver();
	
	@After 
	public void tearDown()
	{
		driver.quit(); 
	}
	
	@Given("^I am in the (\\w+) page$")
	public void i_am_in_the_hangman_page(String pageName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://localhost:8080/" + pageName + ".html");
	    throw new PendingException();
	}

	@When("^I enter letter [a-zA-Z]$")
	public void i_enter_letter_h(String letter) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.id("newGuesses")).sendKeys(letter);
	        driver.findElement(By.id("submit")).click();
	    throw new PendingException();
	}

	@Then("^I see the letter [a-zA-z] appears on the guess word spot$")
	public void i_see_the_letter_h_appears_on_the_guess_word_spot(String letter) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 (new WebDriverWait(driver, 10))
         .until(ExpectedConditions.textToBe(By.id("pattern"), letter + "........."));
		
	    throw new PendingException();
	}

	
	
//	@Given("^I am in hangman page$")
//	public void i_am_in_hangman_page() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@When("^I enter the letter a$")
//	public void i_enter_the_letter_a() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Then("^Nothing should be displayed on the guess word$")
//	public void nothing_should_be_displayed_on_the_guess_word() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
	}

