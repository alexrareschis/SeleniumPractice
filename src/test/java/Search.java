import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {

    private WebDriver driver;


    @Before

    public void openDriver() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement accountButton = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("seleniumwebtest@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("selenium");
        WebElement loginButton = driver.findElement(By.cssSelector("#send2 > span > span"));
        loginButton.click();
    }
    @Test
    public void searchByProduct(){
        driver.findElement(By.cssSelector("#search")).sendKeys("OXFORD");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        WebElement searchResults = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul"));
        Assert.assertTrue(searchResults.getText().contains("OXFORD"));
    }
    @Test
    public void searchBySpecialChars(){
        driver.findElement(By.cssSelector("#search")).sendKeys("@@#@#@#@#@");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        WebElement searchMessage = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > p"));
        Assert.assertTrue(searchMessage.isDisplayed());
    }
    @After
    public void quitDriver(){
        driver.quit();
    }

}
