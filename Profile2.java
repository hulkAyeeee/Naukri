import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Profile2 {
	
	public static void main(String[] args) throws AWTException {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "D:\\Classes 2025\\ChromeDriver Jenkins Check\\chromedriver-win32\\chromedriver.exe");

		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.naukri.com/");
		
		
		List<WebElement> cookies = driver.findElements(By.xpath("//span[text()='Got it']"));
		if (!cookies.isEmpty() && cookies.get(0).isDisplayed()) {
		    cookies.get(0).click();
		}

		List<WebElement> qrError = driver.findElements(By.xpath("//div[starts-with(@id,'scan-qr-overlay')]"));
		if (!qrError.isEmpty() && qrError.get(0).isDisplayed()) {
		    driver.navigate().refresh();
		}
		
		driver.findElement(By.xpath("//a[text()='Login']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//input[@placeholder='Enter your active Email ID / Username']")
		));
		emailField.sendKeys("hulkenikhil7@gmail.com");

		WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
		passwordField.sendKeys("#NewHome007");

		driver.findElement(By.xpath("//button[text()='Login']")).click();

		
//		driver.findElement(By.xpath("//span[text()='Search jobs here']")).click();
		
//		driver.findElement(By.xpath("(//input[@class=\"suggestor-input \"])[1]")).sendKeys("Automation Test Engineer");
		WebDriverWait waitChat = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
		    // Wait for chatbot container, but timeout quickly if not present
		    WebElement chatbot = waitChat.until(ExpectedConditions.presenceOfElementLocated(
		            By.xpath("//div[contains(@class,'chatbot_Drawer')]")));
		    
		    if (chatbot.isDisplayed()) {
		        WebElement closeBtn = driver.findElement(
		            By.xpath("//div[contains(@class,'crossIcon') and contains(@class,'chatBot-ic-cross')]"));
		        closeBtn.click();
		        System.out.println("Chatbot closed successfully");
		    }
		} catch (Exception e) {
		    System.out.println("No chatbot appeared, continuing...");
		}
		
		driver.findElement(By.xpath("//div[@class=\"nI-gNb-drawer__icon\"]")).click();
		driver.findElement(By.xpath("//a[text()='View & Update Profile']")).click();
		
		driver.findElement(By.xpath("//input[contains(@class,\"dummyUpload\")]")).click();
		
		StringSelection s=new StringSelection("C:\\Users\\Nikhil\\Downloads\\Resume_Nikhil Hulke_TestEngineer.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
	
		Robot r=new Robot();
		r.delay(2000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		driver.findElement(By.xpath("(//span[@class=\"edit icon\"])[1]")).click();
		WebElement textArea=driver.findElement(By.xpath("//textarea[@id=\"resumeHeadlineTxt\"]"));
		
		String a = textArea.getAttribute("value");
		if(a.contains("."))
		{
			textArea.clear();
			textArea.sendKeys("Immediate Joiner | Seasoned QA Tester with 4+ years' "
					+ "experience (2 in automation) in Selenium WebDriver (Java), manual & API testing, "
					+ "regression, BDD (Cucumber, TestNG), CI/CD (Jenkins), Agile, and defect management (Azure DevOps, Jira)");
		}
		else
		{
			textArea.clear();
			textArea.sendKeys("Immediate Joiner | Seasoned QA Tester with 4+ years' "
					+ "experience (2 in automation) in Selenium WebDriver (Java), manual & API testing, "
					+ "regression, BDD (Cucumber, TestNG), CI/CD (Jenkins), Agile, and defect management (Azure DevOps, Jira).");
		}
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		driver.findElement(By.xpath("//div[@class=\"nI-gNb-drawer__icon\"]")).click();
		driver.findElement(By.xpath("(//a[@class=\"nI-gNb-list-cta\"])[4]")).click();
		
		driver.quit();
	}


}
