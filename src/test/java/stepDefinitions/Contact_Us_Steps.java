/*
package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Contact_Us_Steps {
    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        System.out.println("Test1");
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        System.out.println("Test2");
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        System.out.println("Test3");
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        System.out.println("Test3");
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        System.out.println("Test4");

    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        System.out.println("Test5");
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        System.out.println("Test6");
    }

}

 */

// Define the package for this class
package stepDefinitions;

// Import Cucumber hooks and step annotations
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

// Import Selenium WebDriver classes for browser automation
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// Import JUnit assertion to verify expected results
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.RandomStringUtils;

// Define the step definition class
public class Contact_Us_Steps {
    private WebDriver driver;

    // Hook that runs before each scenario to set up browser
    @Before
    public void setup(){
        // Set the system property to tell Selenium where to find chromedriver binary
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver");
        // Create ChromeOptions to configure ChromeDriver behavior
        ChromeOptions chromeOptions = new ChromeOptions();
        // Set page load strategy (waits for full page load)
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString (int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        // driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("John");
        driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("AutoFN" + generateRandomNumber(5));

    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys("Doe");
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        // driver.findElement(By.cssSelector("input[name='email']")).sendKeys("john.doe@example.com");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("AutoEmail" + generateRandomNumber(10) + "@mail.com");
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        // driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("This is a test comment.");
        driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("This is a test comment." + generateRandomString(12));
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        WebElement body = driver.findElement(By.tagName("body"));
        String bodyText = body.getText();
        assertTrue("Success message not found!", bodyText.contains("Thank You for your Message!"));
    }
}
