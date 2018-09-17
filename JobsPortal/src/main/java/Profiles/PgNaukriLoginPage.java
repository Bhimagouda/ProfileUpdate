package Profiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PgNaukriLoginPage {
	
	WebDriver driver;
	String url;
	WebDriverWait wait;
	Properties prop = new Properties();
	FileInputStream fis;

	public PgNaukriLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By loginButton = By.xpath("//div[text()='Login']");
	public By emailID = By.xpath("//input[contains(@id,'eLogin')]");
	public By passKey = By.xpath("//input[contains(@id,'pLogin')]");
	public By submit = By.xpath("(//button[@class='blueBtn'])[1]");
	public By myNaukri = By.xpath("//ul[contains(@class,'rghtSec')]/li[2]");
	public By editProfile = By.xpath("//a[text()='Edit Profile']");
	public By attachResume = By.xpath("//span[text()='Attach Resume']");
	public By resume = By.id("attachCV");
	public By logout = By.xpath("//a[text()='Logout']");
	//(//div[contains(@class,'subMenu c2')]/ul[1]/li[1])[2]
	
	public void login(String naukriSite) throws IOException {
		driver.get(naukriSite);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void clickLogin() {
		//WebElement loginBtn = driver.findElement(loginButton);
		wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
	}
	
	public void enterCredentials(String email, String Pass) throws IOException, InterruptedException {
		
		WebElement passEmailID = driver.findElement(emailID);
		passEmailID.sendKeys(email);
				
		WebElement passPassword = driver.findElement(passKey);
		passPassword.sendKeys(Pass);

	}
	
	public void clickSubmit() {
		WebElement LoginBtn = driver.findElement(submit);
		//LoginBtn.click();
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(LoginBtn)).click();
	}
	
	public void clickMyProfile() {
		
		wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(myNaukri));
		WebElement myNaukriLink = driver.findElement(myNaukri);
		//WebElement editProfileLink = driver.findElement(editProfile);
		Actions action = new Actions(driver);
		action.moveToElement(myNaukriLink).build().perform();
		
	}
	
	public void clickEditProfile() {
		
		wait = new WebDriverWait(driver,15);
		WebElement editProfilelink = driver.findElement(editProfile);
		wait.until(ExpectedConditions.visibilityOfElementLocated(editProfile));
		editProfilelink.click();
		
	}
	
	public void uploadResume(String resumePath) throws InterruptedException, IOException {
		
		WebElement attachResumeLink = driver.findElement(attachResume);
		attachResumeLink.click();
		
		Thread.sleep(2000);
		
		WebElement resumeUpdate = driver.findElement(resume);
		resumeUpdate.sendKeys(resumePath);
		Thread.sleep(5000);
	}
	
	public void clickLogout() throws InterruptedException {
		Thread.sleep(1500);
		WebElement logoutButton = driver.findElement(logout);
		logoutButton.click();
	}
}
