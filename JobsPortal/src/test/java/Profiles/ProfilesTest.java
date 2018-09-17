package Profiles;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProfilesTest extends Base{
 
	@BeforeTest
	public void startBrowser() throws IOException {
		driver = initializeDriver();
	}
	
	@Test
	public void NaukriUpdate() throws IOException, InterruptedException {
		
		PgNaukriLoginPage naukriLogin = new PgNaukriLoginPage(driver);
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Bhim\\JobsPortal\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		String url = prop.getProperty("naukriURL");
		naukriLogin.login(url);
		naukriLogin.clickLogin();
		String email = prop.getProperty("email");
		String Pass = prop.getProperty("Password");
		naukriLogin.enterCredentials(email, Pass);
		naukriLogin.clickSubmit();
		naukriLogin.clickMyProfile();
		naukriLogin.clickEditProfile();
		String resumePath = prop.getProperty("resume");
		naukriLogin.uploadResume(resumePath);
		naukriLogin.clickMyProfile();
		naukriLogin.clickLogout();
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
