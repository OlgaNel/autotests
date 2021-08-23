import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InvalidLogin {
    WebDriver driver;
    final String LOGIN_FIELD = "standard_user";
    final String PASSWORD_FIELD = "secret_sauce";
    final String expectedLink = "https://www.saucedemo.com/inventory.html";

    @BeforeTest
    public void setUpDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void loginIncorrectUser(){
        openSouce();
        String login = "locked_out_user";
        String password = "secret_sauce";

        login(login, password);

        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        Assert.assertTrue(errorMessage.getText().contains("Epic sadface: Sorry, this user has been locked out."));
    }

    @Test
    public void login(String login, String password){

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement usernamePassword = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys(login);
        usernamePassword.sendKeys(password);
        loginButton.click();
    }

    @Test
    private void openSouce(){
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }
}
