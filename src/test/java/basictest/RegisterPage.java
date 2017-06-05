package basictest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Initializer.Intializing;

public class RegisterPage extends Intializing {
	@BeforeClass
	public void openpage() throws IOException, InterruptedException {
		initialise();
		wd.get(enprop.getProperty("url"));
	}
	@Test(priority=0)
public void account() throws IOException
{
	wd.findElement(By.xpath(locatorprop.getProperty("HOME_ACCOUNT_XPATH"))).click();
}
	@Test(priority=1)
	public void clickregister()
	{
		wd.findElement(By.xpath(locatorprop.getProperty("HOME_REGISTER_XPATH"))).click();
	}
	@Test(priority=2)
	public void enterusername()
	{
		wd.findElement(By.xpath(locatorprop.getProperty("HOME_USERNAME_XPATH"))).sendKeys("Manikandan");
	}
	@Test(priority=3)
	public void enteremail()
	{
		wd.findElement(By.xpath(locatorprop.getProperty("HOME_EMAIL_XPATH"))).sendKeys("mani2423@gmail.com");
	}
}
