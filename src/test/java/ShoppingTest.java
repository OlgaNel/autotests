import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShoppingTest {
    WebDriver driver;

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
    public void openDresses(){
        driver.get("http://automationpractice.com/index.php");

        WebElement dressTab = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]/a[@title='Dresses']"));
        dressTab.click();

        WebElement eveningDresses = driver.findElement(By.xpath("//div[@id='categories_block_left']/div/ul/li/a[@title='Browse our different dresses to choose the perfect dress for an unforgettable evening!']"));
        eveningDresses.click();

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");

        //WebElement addToCart = driver.findElement(By.xpath("//div[@id='center_column']/ul/li[1]/div/div[@class='right-block']/div[@class='button-container']/a[@data-id-product='4']"));
        //addToCart.click();



        //WebElement addToCart = driver.findElement(By.xpath("//div[@id='center_column']/ul/li/div/div[@class='right-block']/div[@class='button-container']/a[@title='Add to cart']"));
        //addToCart.click();




    }


}
