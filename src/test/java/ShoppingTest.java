import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class ShoppingTest {
    WebDriver driver;


    @BeforeTest
    public void setUpDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @AfterTest
    public void cleanDriver(){
        driver.quit();
    }

    @Test
    public void openDresses(){

        driver.get("http://automationpractice.com/index.php");

        WebElement dressTab = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li/a[@title='Dresses']"));
        dressTab.click();

        String eveningDressesTitle = "Browse our different dresses to choose the perfect dress for an unforgettable evening!";
        WebElement eveningDresses = driver.findElement(By.xpath("//div[@id='categories_block_left']/div/ul/li/a[@title='" + eveningDressesTitle + "']"));
        eveningDresses.click();

        JavascriptExecutor jse = (JavascriptExecutor)driver;


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        jse.executeScript("window.scrollBy(0,750)");

        WebElement item = driver.findElement(By.xpath("//ul[@class='product_list grid row']/li[1]"));


        Actions actions = new Actions(driver);
        actions.moveToElement(item);

        WebElement addToCart = driver.findElement(By.xpath("//div[@class='product-container']/div[@class='right-block']/div[@class='button-container']/a[1]"));

        actions.moveToElement(addToCart);

        actions.click().build().perform();


        WebElement continueShopping = driver.findElement(By.xpath("//div[@class='clearfix']/div[2]/div[@class='button-container']/span/span"));
        continueShopping.click();

        jse.executeScript("window.scrollBy(0,-550)");

        WebElement shoppingCart = driver.findElement(By.xpath("//div[@class='shopping_cart']/a"));
        shoppingCart.click();

        WebElement cartSummary = driver.findElement(By.xpath("//table[@id='cart_summary']/tbody/tr[1]"));
        String idItem = cartSummary.getAttribute("id");

        Assert.assertTrue(idItem.contains("product_4_16_0_0"));

    }


}
