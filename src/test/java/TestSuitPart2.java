import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSuitPart2 {
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
    public void myUiTest4(){
        driver.navigate().to(baseUrl);
        driver.navigate().to("https://www.ikea.com/ua/uk/temp");
        driver.navigate().back();
        driver.navigate().refresh();
        String currentTitle = driver.getTitle();
        System.out.println(currentTitle);

        Assert.assertTrue(currentTitle.contains("IKEA"));
    }
}
