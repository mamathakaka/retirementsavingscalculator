package stepdefinations;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

//import io.cucumber.java.PendingException;
@RunWith(Cucumber.class)
public class steps {
	 WebDriver dr;
	 JavascriptExecutor executor; 
	
	@Given("user is on homepage and enters the details")
	public void user_is_on_homepage_And_enters_the_details() throws Throwable {

	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver.exe");
	 dr = new ChromeDriver();
	 dr.get("https://www.securian.com/insights-tools/retirement-calculator.html");
	 dr.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
	 dr.findElement(By.xpath("//input[@id='current-age']")).sendKeys("40");
	 dr.findElement(By.xpath("//input[@id='retirement-age']")).sendKeys("68");
	 dr.findElement(By.xpath("//input[@id='current-income']")).sendKeys("100000"); 
	 dr.findElement(By.xpath("//input[@id='spouse-income']")).sendKeys("75000");
	 dr.findElement(By.xpath("//input[@id='current-total-savings']")).sendKeys("500000");
	 dr.findElement(By.xpath("//input[@id='current-annual-savings']")).sendKeys("10");
	 dr.findElement(By.xpath("//input[@id='savings-increase-rate']")).sendKeys("1");
	 dr.findElement(By.xpath("////button[@data-tag-id='submit']")).click();
	 
	
	 
	 
	}

	@When("user click on submit button")
	public void user_click_on_submit_button() {
		dr.findElement(By.xpath("////button[@data-tag-id='submit']")).click();
	}

	@Then("selected results should visible")
	public void selected_results_should_visible() {
		WebElement records= dr.findElement(By.xpath("//div[@id='calculator-results-container']"));
		if(records.isDisplayed())
			System.out.println("passed");
		dr.close();
	}
	

}
