package com.facebook.login;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class PageRepository {
 WebDriver driver;
By username=By.xpath("//input[@class='inputtext _55r1 _6luy']");
By password=By.xpath("//input[@class='inputtext _55r1 _6luy _9npi']");
By loginButton=By.xpath("//button[@name='login']");
By Errormsg=By.xpath("//div[@class='_9ay7']");
By Err1=By.xpath("//div[@class='_9ay7']");
public PageRepository(WebDriver driver) throws IOException {
	this.driver=driver;
	this.shot(driver,"C:\\Users\\VISWA SYSTEMS\\eclipse\\com.facebook.login\\pic.png");
	
}
public void shot(WebDriver driver2, String path) throws IOException {
	// TODO Auto-generated method stub
	TakesScreenshot tss=((TakesScreenshot)driver2);
	File file=tss.getScreenshotAs(OutputType.FILE);
	File dfile=new File(path);
	 Files.copy(file,dfile);
}
public void typeUserName(String user) {
	driver.findElement(username).sendKeys(user);
}
public void typePassword(String pass) {
	driver.findElement(password).sendKeys(pass);
}
public void typeLogin() {
	driver.findElement(loginButton).click();
}
public  String Error() {
	return driver.findElement(Errormsg).getText();
}
public String Err() {
	return driver.findElement(Err1).getText();
}
}
