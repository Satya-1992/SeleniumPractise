import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class SanityTest {

  public WebDriver driver;


  @BeforeClass

  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver.get("https://www.goibibo.com/");

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test

  public void Test1()
  {

    WebDriverWait wait= new WebDriverWait(driver,10);

    WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='gosuggest_inputSrc']")));

    driver.findElement(By.xpath("//input[@id='gosuggest_inputSrc']")).sendKeys("DEL");
    driver.findElement(By.xpath("(//*[starts-with(@class,'formWrap')]/div/input)[1]")).click();
    driver.findElement(By.xpath("//input[@id='gosuggest_inputDest']")).sendKeys("BOM");
    driver.findElement(By.xpath("(//*[starts-with(@class,'formWrap')]/div/input)[2]")).click();
    element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='form-control inputTxtLarge widgetCalenderTxt'])[1]")));
    driver.findElement(By.xpath("(//input[@class='form-control inputTxtLarge widgetCalenderTxt'])[1]")).click();
    driver.findElement(By.xpath("(//div[contains(text(),'8')])[1]")).click();
  }


  @AfterClass
  public void broswerInit() {
//driver.close();

  }


}























