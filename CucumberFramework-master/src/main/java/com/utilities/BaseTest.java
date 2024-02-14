package com.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	public static WebDriver driver;
	public static Properties pro;

	public static WebDriver initializeBrowser() {

		try {
			pro = new Properties();
			FileReader file = new FileReader("src/main/java/com/utilities/config.properties");
			pro.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String browser = pro.getProperty("browser");

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				LoggerLoad.info("Initializing Chrome Browser...");
				driver = new ChromeDriver();
				driver.get(pro.getProperty("url"));
				driver.manage().window().maximize();
			}
			else if (browser.equalsIgnoreCase("firefox")) {
				LoggerLoad.info("Initializing Firefox Browser...");
				driver = new FirefoxDriver();
				driver.get(pro.getProperty("url"));
				driver.manage().window().maximize();
			} else if (browser.equals("IE")) {
				LoggerLoad.info("Initializing IE Browser...");
				driver = new EdgeDriver();
				driver.get(pro.getProperty("url"));
				driver.manage().window().maximize();
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}

}
