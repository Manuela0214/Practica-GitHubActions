import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class GoogleSearchTest {

	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.edge.driver", "./src/test/resources/edgedriver/msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGooglePage() {
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.clear();
		searchbox.sendKeys("bioluminiscencia marina");
		searchbox.submit();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		String actualTitle = driver.getTitle();
	    String expectedTitle = "bioluminiscencia marina";
		
	    assertTrue("El título no comienza con la cadena esperada", actualTitle.startsWith(expectedTitle));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
