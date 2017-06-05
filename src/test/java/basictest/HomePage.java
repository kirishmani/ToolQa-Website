package basictest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Initializer.Intializing;

public class HomePage extends Intializing {
	@BeforeClass
	public void openpage() throws IOException, InterruptedException {
		initialise();
		wd.get(enprop.getProperty("url"));
	}
	@BeforeMethod
	public void mouseover()
	{
		wd.findElement(By.xpath(locatorprop.getProperty("HOMEBUTTON_URL_XPATH"))).click();
		WebElement mouse = wd.findElement(By.xpath(locatorprop.getProperty("PRODUCT_HOME_XPATH")));
		Actions a = new Actions(wd);
		a.moveToElement(mouse).build().perform();
	}
	@Test(priority=0)
	public void accessories()
	{
		 wd.findElement(By.xpath(locatorprop.getProperty("PRODUCT_ACCESSORIES_HOME_XPATH"))).click();
	}
	@Test(priority=1)
	public void imacs()
	{
		 wd.findElement(By.xpath(locatorprop.getProperty("PRODUCT_IMACS_HOME_XPATH"))).click();
	}
	@Test(priority=2)
	public void ipads()
	{
		 wd.findElement(By.xpath(locatorprop.getProperty("PRODUCT_IPADS_HOME_XPATH"))).click();
	}
	@Test(priority=3)
	public void iphone()
	{
		 wd.findElement(By.xpath(locatorprop.getProperty("PRODUCT_IPHONES_HOME_XPATH"))).click();
	}
	@Test(priority=4)
	public void ipods()
	{
		 wd.findElement(By.xpath(locatorprop.getProperty("PRODUCT_IPODS_HOME_XPATH"))).click();
	}
	@Test(priority=5)
	public void macbook()
	{
		 wd.findElement(By.xpath(locatorprop.getProperty("PRODUCT_MACBOOKS_HOME_XPATH"))).click();
	}
	
}
