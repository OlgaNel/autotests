
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSuite {

    WebDriver driver;


    private final String baseUrl = "https://www.ikea.com/ua/uk/";

    @BeforeClass
    public void setUp(){
        //WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public void setUpDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void cleanDriver(){
        driver.quit();
    }

    @Test
    public void myUiTest2() {
        driver.get(baseUrl);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertEquals(currentUrl, "https://www.ikea.com/ua/uk/", "error!");
    }
}
