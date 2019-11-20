import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HappyDawnTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.firefox.driver","C:\\Users\\cleme\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

        String baseUrl = "http://happydawn.be/";
        String tagName = "";
        String expectedResponse = "Mail envoyé";



        driver.get(baseUrl);

       driver.findElement(By.id("name")).sendKeys("TestSelenium");
       driver.findElement(By.id("mail")).sendKeys("popol@gmail.com");
       driver.findElement(By.id("message")).sendKeys("Bonjour je suis un test");



       driver.findElement(By.id("envoyer")).click();

       try{
			Thread.sleep(5000);
			}
			catch(InterruptedException ie){
			}

       WebElement confirmation = driver.findElement(By.id("conf"));
       String confirmationText = confirmation.getText();
       //assertEquals(expectedResponse, confirmationText);

       if (confirmationText.contentEquals(expectedResponse)){
           System.out.println("Test Passed!");
       } else {
           System.out.println("Test Failed");
       }


	}

}
