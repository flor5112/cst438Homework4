package edu.csumb.cst438fa16.hangman.webclient;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * As a user I want be able to access the hangman page 
 * so I can can have an interactive guess game. 
 * 
 * 
 */
public class HangmanIT {
	 // Requires chromedriver. See:
    // http://docs.seleniumhq.org/docs/03_webdriver.jsp#chromedriver
    // On Mac you can install it with "brew install googledriver" if you have Homebrew.`	qw
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/hangman.html");
    }

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }

    /**
     * Acceptance test:
     *Given that the word is helloworld
     *When the user inputs 'h' 
     *Then the result should h.........
     *
     */
    @Test
    public void chenkForCorrectInput() {
        driver.findElement(By.id("newGuesses")).sendKeys("h");
        driver.findElement(By.id("submit")).click();

        // The greeting is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.textToBe(By.id("pattern"), "h........."));

        // Success
}
    /** 
     * Given that the word is 'helloworld' 
     * When I input the letter a 
     * the page will display the letter picked and .........
     * 
     */
    public void chenkForIncorrectInput() {
    	
        driver.findElement(By.id("newGuesses")).sendKeys("a");
        driver.findElement(By.id("submit")).click();

        // The greeting is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.textToBe(By.id("pattern"), "........."));

        // Success
}

}
