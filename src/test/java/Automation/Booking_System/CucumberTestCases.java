package Automation.Booking_System;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.testData;
import baseClass.commonMethods;
import baseClass.pageProperties;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberTestCases {
	static WebDriver driver=new ChromeDriver();
	
	@Given("^user is on booking\\.com page$")
	public void user_is_on_booking_com_page() throws Throwable {
			System.setProperty("webdriver.chrome.driver", testData.chromePath);
			driver.get(testData.URL);
			driver.manage().window().maximize();
			Alert alert = driver.switchTo().alert();
			alert.accept();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			System.out.println("Navigated to the booking system page");
	    
	}

	@When("^search by location is entered as \"([^\"]*)\"$")
	public void search_by_location_is_entered_as(String arg1) throws Throwable {
		pageProperties.selectPlace().click();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 pageProperties.selectPlace().sendKeys(testData.Place);
	}

	@When("^Dates entered is One night stay \\((\\d+) months from today’s date\\)$")
	public void dates_entered_is_One_night_stay_months_from_today_s_date(int arg1) throws Throwable {
		 pageProperties.checkinDate().click();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 commonMethods.selectCheckindate();
		 pageProperties.checkoutDate().click();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 commonMethods.selectCheckoutdate();
	}

	@When("^Number of People is (\\d+) adults$")
	public void number_of_People_is_adults(int arg1) throws Throwable {
		 pageProperties.guestCount().sendKeys("2");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("^Room: (\\d+) Room$")
	public void room_Room(int arg1) throws Throwable {
		pageProperties.roomCount().sendKeys("1");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@When("^Search is performed$")
	public void search_is_performed() throws Throwable {
		 pageProperties.searchButton().click();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 String expected=testData.expectedPlace;
		 String actual=pageProperties.searchTitle().getText();;
		 assertEquals(expected,actual );
	}
	@When("^Filter by selected as Sauna$")
	public void filter_by_selected_as_Sauna() throws Throwable {
		 pageProperties.funactivitySauna().click();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Then("^Limerick Strand Hotel should be Listed and George Limerick Hotel should not be Listed$")
	public void limerick_Strand_Hotel_should_be_Listed_and_George_Limerick_Hotel_should_not_be_Listed() throws Throwable {
		 List<WebElement> Hotellist=pageProperties.hotelList();
		 assertTrue(Hotellist.contains(testData.Hotellist1));
		 assertFalse(Hotellist.contains(testData.Hotellist2));
	}

	@When("^Filter by selected as (\\d+) star$")
	public void filter_by_selected_as_star(int arg1) throws Throwable {
		 pageProperties.starRating5stars().click();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Then("^The Savoy Hotel should be Listed and George Limerick Hotel should not be Listed$")
	public void the_Savoy_Hotel_should_be_Listed_and_George_Limerick_Hotel_should_not_be_Listed() throws Throwable {
		List<WebElement> Hotellist=pageProperties.hotelList();
		 assertTrue(Hotellist.contains(testData.Hotellist3));
		 assertFalse(Hotellist.contains(testData.Hotellist4));
	}


}
