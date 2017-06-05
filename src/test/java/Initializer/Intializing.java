package Initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Intializing {
	/**
	 * @author dell
	 * 
	 *en load properties
	 */
	public static Properties enprop;
	public static FileInputStream enfis;

	/**
	 * @author dell Locator properties
	 */
	public static Properties locatorprop;
	public static FileInputStream locatorfis;

	public static WebDriver wd;

	public static void initialise() throws IOException {
		enfis = new FileInputStream(new File("D:" + File.separator+ "WORKSPACE" + File.separator + "website-test"+ File.separator + "src" + File.separator + "test"+ File.separator + "resources" + File.separator + "config"+ File.separator + "en.properties"));
		enprop = new Properties();
		enprop.load(enfis);

		locatorfis = new FileInputStream(new File("D:" + File.separator
				+ "WORKSPACE" + File.separator + "website-test"
				+ File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "config"
				+ File.separator + "locator.properties"));
		locatorprop = new Properties();
		locatorprop.load(locatorfis);

		if (enprop.getProperty("BROWSER").equals("FIREFOX")) {
			wd = new FirefoxDriver();
		} else if (enprop.getProperty("BROWSER").equals("CHROME")) {
			wd = new ChromeDriver();

		}
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
