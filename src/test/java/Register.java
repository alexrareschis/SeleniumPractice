import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register {

    private WebDriver driver;

    @Before

    public void openDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement accountButton = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();
        WebElement registerButton = driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a"));
        registerButton.click();


    }
    @Test
    public void createAnAccount() {

        WebElement createAnAccountMessage = driver.findElement(By.cssSelector("#form-validate > div.fieldset > p.form-instructions"));
        Assert.assertTrue(createAnAccountMessage.isDisplayed());
        WebElement requiredFields = driver.findElement(By.cssSelector("#form-validate > div.fieldset > p.required"));
        Assert.assertEquals("* Required Fields",requiredFields.getText());
        WebElement firstName = driver.findElement(By.cssSelector("#firstname"));
        firstName.sendKeys("Selenium");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("WebDriver");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("seleniumwebtest@gmail.com");
        driver.findElement(By.id("password")).sendKeys("selenium");
        driver.findElement(By.id("confirmation")).sendKeys("selenium");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
    }
    @Test
    public void alreadyRegistered(){

        WebElement createAnAccountMessage = driver.findElement(By.cssSelector("#form-validate > div.fieldset > p.form-instructions"));
        Assert.assertTrue(createAnAccountMessage.isDisplayed());
        WebElement requiredFields = driver.findElement(By.cssSelector("#form-validate > div.fieldset > p.required"));
        Assert.assertEquals("* Required Fields",requiredFields.getText());
        WebElement firstName = driver.findElement(By.cssSelector("#firstname"));
        firstName.sendKeys("Selenium");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("WebDriver");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("seleniumwebtest@gmail.com");
        driver.findElement(By.id("password")).sendKeys("selenium");
        driver.findElement(By.id("confirmation")).sendKeys("selenium");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        WebElement alreadyRegisteredMessage = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-create > ul > li > ul > li > span"));
        Assert.assertTrue(alreadyRegisteredMessage.isDisplayed());
    }
    @Test
    public void emptyFields(){
        WebElement registerButton = driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button"));
        registerButton.click();
        WebElement message = driver.findElement(By.cssSelector("#advice-required-entry-firstname"));
        Assert.assertEquals("This is a required field.",message.getText());
    }


    @After
    public void quitDriver(){
    driver.quit();
    }



}
