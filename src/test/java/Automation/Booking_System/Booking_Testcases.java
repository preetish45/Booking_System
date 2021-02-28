package Automation.Booking_System;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import baseClass.commonMethods;
import baseClass.pageProperties;
import Utility.testData;

public class Booking_Testcases extends commonMethods {
	 static WebDriver driver=new ChromeDriver();
	
	@BeforeClass	
	 public static void navigateToURL() throws InterruptedException 
	    { 
		 System.setProperty("webdriver.chrome.driver", testData.chromePath);
		 driver.get(testData.URL);
		 driver.manage().window().maximize();
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 System.out.println("Navigated to the booking system page");
		 

	    }
	 //Test cases to search property, enter the check-in, check-out dates, guest count, room count and validate the search results
	 @Test
	 public void firstTestcase_searchProperty() throws InterruptedException
	 {
	 pageProperties.selectPlace().click();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 pageProperties.selectPlace().sendKeys(testData.Place);
	 pageProperties.checkinDate().click();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 commonMethods.selectCheckindate();
	 pageProperties.checkoutDate().click();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 commonMethods.selectCheckoutdate();
	 pageProperties.guestCount().sendKeys("2");
	 pageProperties.roomCount().sendKeys("1");
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 pageProperties.searchButton().click();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 String expected=testData.expectedPlace;
	 String actual=pageProperties.searchTitle().getText();;
	 assertEquals(expected,actual );
	
	 }
	 
	 @Test
	 public void searchbyFilter_Sauna()
	 {
		 pageProperties.funactivitySauna().click();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 List<WebElement> Hotellist=pageProperties.hotelList();
		 assertTrue(Hotellist.contains(testData.Hotellist1));
		 assertFalse(Hotellist.contains(testData.Hotellist2));
		 
	 }
	 
	 @Test
	 public void searchbyFilter_Starrating()
	 {
		 pageProperties.starRating5stars().click();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 List<WebElement> Hotellist=pageProperties.hotelList();
		 assertTrue(Hotellist.contains(testData.Hotellist3));
		 assertFalse(Hotellist.contains(testData.Hotellist4));
		 
	 }
	 
	 @AfterClass
	 public static void closeBrowser()
	 {
	  driver.quit();
	 }
}
