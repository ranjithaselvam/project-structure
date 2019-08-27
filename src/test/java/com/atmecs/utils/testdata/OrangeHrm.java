package com.atmecs.utils.testdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrangeHrm {
	static WebDriver driver;
	static String url;
	static String browser;
	static FileInputStream stream;
	static Properties properties = new Properties();
	static Properties properties1 = new Properties();
	static Properties properties2 = new Properties();


	@BeforeTest
	public void setup() throws IOException {

		stream = new FileInputStream(
				"C:\\Users\\ranjitha.selvam\\eclipse-workspace\\ObjectRepository\\src\\test\\resources\\testdata\\config.properties");
		properties.load(stream);
		String url = properties.getProperty("url");
		String browserName = properties.getProperty("browser");
		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ranjitha.selvam\\eclipse-workspace\\ObjectRepository\\lib\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\ranjitha.selvam\\eclipse-workspace\\ObjectRepository\\lib\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("internetexplorer")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\ranjitha.selvam\\eclipse-workspace\\ObjectRepository\\lib\\geckodriver.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get(url);

		
		
		  }
		  
		  @Test 
		  public void automate() throws IOException {
		 
		
		stream = new FileInputStream(
				"C:\\Users\\ranjitha.selvam\\eclipse-workspace\\ObjectRepository\\src\\test\\resources\\Locators\\path.properties");
		properties1.load(stream);

		stream = new FileInputStream(
				"C:\\Users\\ranjitha.selvam\\eclipse-workspace\\ObjectRepository\\src\\test\\resources\\Locators\\data.properties");
		properties2.load(stream);
		driver.manage().window().maximize();

		driver.findElement(By.xpath(properties1.getProperty("loc_contactsales_btn_xpath"))).click();
		driver.findElement(By.name(properties1.getProperty("loc_firstname_txt_name")))
				.sendKeys(properties2.getProperty("firstname"));
		driver.findElement(By.name(properties1.getProperty("loc_lastname_txt_name")))
				.sendKeys(properties2.getProperty("lastname"));
		driver.findElement(By.name(properties1.getProperty("loc_companyname_txt_name")))
				.sendKeys(properties2.getProperty("companyname"));
		WebElement select = driver.findElement(By.name(properties1.getProperty("loc_numberofemployees_sct_name")));
		Select s = new Select(select);
		s.selectByIndex(3);
		driver.findElement(By.name(properties1.getProperty("loc_phonenumber_txt_name")))
				.sendKeys(properties2.getProperty("phonenumber"));
		driver.findElement(By.name(properties1.getProperty("loc_jobtitle_txt_name")))
				.sendKeys(properties2.getProperty("jobtitle"));
		driver.findElement(By.name(properties1.getProperty("loc_email_txt_name")))
				.sendKeys(properties2.getProperty("email"));
		WebElement findElement = driver.findElement(By.name(properties1.getProperty("loc_country_sct_name")));
		Select s1=new Select(findElement);
		s1.selectByValue("India");
		
		driver.findElement(By.name(properties1.getProperty("loc_comment_txt_name")))
				.sendKeys(properties2.getProperty("comment"));
	}
}
