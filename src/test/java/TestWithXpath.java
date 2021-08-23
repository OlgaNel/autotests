import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TestWithXpath {

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
    public void xpathTest(){
        driver.get("https://theautomationzone.blogspot.com/2020/07/xpath-practice.html");
        WebElement test1 = driver.findElement(By.xpath("//*[@id='id1']"));
        System.out.println(test1.getText());

        WebElement test2 = driver.findElement(By.xpath("//div[@class='class1']"));
        System.out.println(test2.getText());

        WebElement test3 = driver.findElement(By.xpath("//p[@name='a' and @id='b']"));
        System.out.println(test3.getText());

        WebElement test4 = driver.findElement(By.xpath("//div[@id='div1']/div[2]"));
        System.out.println(test4.getText());

        WebElement test5 = driver.findElement(By.xpath("//span[@id='link']/.."));
        System.out.println(test5.getText());

        WebElement test6 = driver.findElement(By.xpath("//*[@id='f1']/div[@id='divC']/span/input"));
        test6.sendKeys("it's work");
        System.out.println(test6.getText());

        WebElement test7 = driver.findElement(By.xpath("//button[text()='change time']"));
        System.out.println(test7.getText());

        String myLabel = "time";
        String myString = "//button[contains(text()," + myLabel + "')]";

        WebElement test8 = driver.findElement(By.xpath("//button[contains(text(), 'change time')]"));
        System.out.println(test8.getText());


    }

}
