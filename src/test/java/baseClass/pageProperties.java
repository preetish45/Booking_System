package baseClass;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pageProperties {
	 static WebDriver driver=new ChromeDriver();
	 
	 public static WebElement selectPlace() {
		return driver.findElement(By.cssSelector("#ss"));
	}
	
	 public static WebElement checkinDate() {
		 return driver.findElement(By.cssSelector("[data-mode=\"checkin\"]"));
		 
		
	}
	 public static WebElement getCurrentMonth() {
		 return driver.findElement(By.cssSelector("div.bui-calendar__wrapper:nth-child(1) > div"));
		 
	
	}
	 
	 public static WebElement checkoutDate() {
		 return driver.findElement(By.cssSelector("[data-mode=\"checkout\"]"));
		
	}
	 public static WebElement guestCount() {
		 return driver.findElement(By.cssSelector(".xp__guests__count > span:nth-child(1)"));
		
	}
	 public static WebElement roomCount() {
		 return driver.findElement(By.cssSelector(".xp__guests__count > span:nth-child(3) > span:nth-child(1)"));
		
	}
	  
	 public static WebElement searchButton() {
		 return driver.findElement(By.cssSelector(".sb-searchbox__button"));
		
	}
	 public static WebElement searchTitle() {
		 return driver.findElement(By.cssSelector(".sr_header--title"));
		
	}
	 
	 public static WebElement funactivitySauna() {
		 return driver.findElement(By.cssSelector("#filter_popular_activities > div:nth-child(2) > a:nth-child(1) > label:nth-child(1) > div:nth-child(2) > span:nth-child(1)"));
		
	}
	 
	public static List<WebElement> hotelList() {
		return driver.findElements(By.cssSelector(".sr-hotel__name"));
	}
	
	 public static WebElement starRating5stars() {
		 return driver.findElement(By.cssSelector("#filter_class > div:nth-child(2) > a:nth-child(2) > label:nth-child(1) > div:nth-child(2)"));
		
	}
	 
	
}
