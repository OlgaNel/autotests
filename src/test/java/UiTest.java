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

public class UiTest {
    WebDriver driver;
    final String LOGIN_FIELD = "standard_user";
    final String PASSWORD_FIELD = "secret_sauce";
    final String expectedLink = "https://www.saucedemo.com/inventory.html";
    final String expectedLinkLogin = "https://www.saucedemo.com/";

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
    public void myUiTest(){
        driver.get(baseUrl);
    }

    @Test
    public void myUiTest2(){
        driver.get(baseUrl);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertEquals(currentUrl, "https://www.ikea.com/ua/uk/", "error!");
    }

    @Test
    public void myUiTest3(){
        driver.get(baseUrl);
        String currentTitle = driver.getTitle();
        System.out.println(currentTitle);
        //Assert.assertEquals(currentTitle, "404 - Ой! Щось пішло не так :( - IKEA", "error!");
        Assert.assertTrue(currentTitle.contains("IKEA"));
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


    @Test
    public void standardUserLoginTest() throws InterruptedException {

        openSouce();

        login(LOGIN_FIELD,PASSWORD_FIELD);

        String actualResultLink = driver.getCurrentUrl();

        Assert.assertEquals(actualResultLink, expectedLink, "ERROR");

        logOut();

    }

    private void login(String login, String password) throws InterruptedException {

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement usernamePassword = driver.findElement(By.id("user-name"));
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

    @Test
    private void logOut() throws InterruptedException {
        openSouce();
        login(LOGIN_FIELD,PASSWORD_FIELD);

        WebElement burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenu.click();

        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        Thread.sleep(500);

        logoutButton.click();

        Assert.assertFalse(driver.getCurrentUrl().contains(expectedLink));
    }

}
