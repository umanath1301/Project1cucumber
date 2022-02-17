package com.facebook.login;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FacebookLogin {
public WebDriver driver;
public ExtentReports report;
public ExtentTest test;
@BeforeClass
public void ExtentRep() {
	report=new ExtentReports(System.getProperty("user+dir")+"ExtendReportresult.html");
	report.assignProject("Validate the facebook login function");
}
@Test
public void login() throws InterruptedException, IOException {
	test=report.startTest("Testcase id=1");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\VISWA SYSTEMS\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.navigate().to("https://www.facebook.com/");
	driver.manage().window().maximize();
	PageRepository page=new PageRepository(driver);
	page.typeUserName("9791055437");
	page.typePassword("1234567");
	page.typeLogin();
	Thread.sleep(5000);
	page.shot(driver, "C:\\Users\\VISWA SYSTEMS\\eclipse\\com.facebook.login\\pic.png");
	String title=driver.getTitle();
	System.out.println(title);
//	page.shot(driver, "C:\\Users\\VISWA SYSTEMS\\eclipse\\com.facebook.login");
	if(!title.equals("Facebook")) {
		test.log(LogStatus.FAIL,"testcase filed");
	}else {
Assert.assertEquals(driver.getTitle(),"Facebook");
	
test.log(LogStatus.PASS,"testcase pass");}
	Thread.sleep(5000);
driver.quit();
}
@Test
public void Logerror() throws IOException, InterruptedException {
	test=report.startTest("Testcase id=2");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\VISWA SYSTEMS\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.navigate().to("https://www.facebook.com/");
	driver.manage().window().maximize();
	PageRepository page=new PageRepository(driver);
	page.typeUserName("umanathdhon");
	page.typePassword("msdhoni");
	page.typeLogin();
	Thread.sleep(5000);
	page.shot(driver, "C:\\Users\\VISWA SYSTEMS\\eclipse\\com.facebook.login\\pic1.png");
	String testt=page.Error();
	System.out.println(testt);
	String test1="The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
	if(testt.equals(test1)) {	
		test.log(LogStatus.PASS, "testcase id =2 is passed");
	}else {
		test.log(LogStatus.FAIL,"testcase id=2 is failed");
	}
	Thread.sleep(5000);
	driver.quit();
}
@Test
public void LogError1() throws IOException, InterruptedException {
	test=report.startTest("testcase id=3");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\VISWA SYSTEMS\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.navigate().to("https://www.facebook.com/");
	driver.manage().window().maximize();
	PageRepository page=new PageRepository(driver);
	page.typeUserName("9791055437");
	page.typeLogin();
	Thread.sleep(5000);
	page.shot(driver, "C:\\Users\\VISWA SYSTEMS\\eclipse\\com.facebook.login\\pic2.png");
	String errms=page.Err();
	System.out.println(errms);
	String test2="The password that you've entered is incorrect. ";
	if(errms.equals(test2)) {
		test.log(LogStatus.PASS,"testcase id =3 is passed");
	}else {
		test.log(LogStatus.FAIL, "testcase id =3 is failed");
	}
	Thread.sleep(5000);
	driver.quit();
}
@Test
public void LogError2() throws IOException, InterruptedException {
	test=report.startTest("testcase id=4");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\VISWA SYSTEMS\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.navigate().to("https://www.facebook.com/");
	driver.manage().window().maximize();
	PageRepository page=new PageRepository(driver);
	page.typePassword("1234567");
	page.typeLogin();
	Thread.sleep(5000);
	page.shot(driver, "C:\\Users\\VISWA SYSTEMS\\eclipse\\com.facebook.login\\pic3.png");
	String msg=page.Err();
	System.out.println(msg);
	String test3="The email address or mobile number you entered isn't connected to an account. ";
	if(msg.equals(test3)) {
		test.log(LogStatus.PASS,"testcase id =4 is passed");
	}else {
		test.log(LogStatus.FAIL, "testcase id =4 is failed");
	}
	Thread.sleep(5000);
	driver.quit();
}

@AfterClass
public void end() {
	report.endTest(test);
	report.flush();
}

}
