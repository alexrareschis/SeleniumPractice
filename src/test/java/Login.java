import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    private WebDriver driver;

    @Before
    public void openDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement accountButton = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
    }

    @Test
    public void validLogin(){
        driver.findElement(By.cssSelector("#email")).sendKeys("seleniumwebtest@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("selenium");
        WebElement loginButton = driver.findElement(By.cssSelector("#send2 > span > span"));
        loginButton.click();
        WebElement welcomeMessage = driver.findElement(By.cssSelector("body > div > div.page > div.header-language-background > div > p"));
        Assert.assertTrue(welcomeMessage.isDisplayed());
    }
    @Test
    public void invalidEmailLogin(){
        driver.findElement(By.cssSelector("#email")).sendKeys("seleniumwebtest@gmail");
        driver.findElement(By.cssSelector("#pass")).sendKeys("selenium");
        WebElement loginButton = driver.findElement(By.cssSelector("#send2 > span > span"));
        loginButton.click();
        WebElement invalidEmailMessage = driver.findElement(By.cssSelector("#advice-validate-email-email"));
        Assert.assertEquals("Please enter a valid email address. For example johndoe@domain.com.",invalidEmailMessage.getText());
    }
    @Test
    public void invalidPassLogin(){
        driver.findElement(By.cssSelector("#email")).sendKeys("seleniumwebtest@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("selenium222");
        WebElement loginButton = driver.findElement(By.cssSelector("#send2 > span > span"));
        loginButton.click();
        WebElement invalidPassMessage = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-login > ul > li > ul > li > span"));
        Assert.assertTrue(invalidPassMessage.isDisplayed());
    }

    @After
    public void quitDriver(){
    driver.quit();

    }


}
