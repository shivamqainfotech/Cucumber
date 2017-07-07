package stepDefinition;

import java.util.List;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {

	int tweetNumber = 4;
	WebDriver driver;
	static ResourceBundle rs = ResourceBundle.getBundle("Resources.credentials");

	@Given("^I am on twitter home page$")
	public void i_am_on_twitter_home_page() throws Throwable {

		System.setProperty(rs.getString("driverName"), rs.getString("driverPath"));
		driver = new ChromeDriver();
		driver.get(rs.getString("url"));

	}

	@When("^I nevigate to LogIn page$")
	public void i_nevigate_to_LogIn_page() throws Throwable {

		WebElement ele2 = driver.findElement(By.cssSelector(".StreamsLogin.js-login"));
		ele2.click();

	}

	@When("^I enters valid username and password$")
	public void i_enters_valid_username_and_password() throws Throwable {
		WebElement ele3 = driver.findElement(By.cssSelector(".text-input.email-input.js-signin-email"));
		ele3.click();
		ele3.sendKeys(rs.getString("userid"));

		WebElement ele4 = driver.findElement(By.name("session[password]"));
		ele4.click();
		ele4.sendKeys(rs.getString("password"));

	}

	@Then("^page should be updated with feeds$")
	public void page_should_be_updated_with_feeds() throws Throwable {
		WebElement ele5 = driver.findElement(By.cssSelector(".EdgeButton--medium.submit"));
		boolean status = ele5.isEnabled();
		boolean displayed = ele5.isDisplayed();
		if (status && displayed) {
			ele5.submit();
		}

	}

	@Then("^feed number four should be selected$")
	public void feed_number_four_should_be_selected() throws Throwable {

		List<WebElement> ele6 = driver.findElements(By.cssSelector(".tweet .js-tweet-text-container p"));

		WebElement e1 = ele6.get(tweetNumber - 1);
		e1.click();

	}

}
