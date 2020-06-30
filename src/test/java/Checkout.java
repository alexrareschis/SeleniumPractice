import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkout {
    private WebDriver driver;
    @Before
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
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
    public void checkoutFirstTest(){
        driver.findElement(By.cssSelector("#header > div > a > img.large")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.std > ul > li:nth-child(3) > a > img")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(3) > div > div.actions > button")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > div.cart-totals-wrapper > div > ul > li > button > span > span")).click();
        driver.findElement(By.cssSelector("#billing\\:firstname")).sendKeys("Alex");
        driver.findElement(By.cssSelector("#billing\\:lastname")).sendKeys("C");
        driver.findElement(By.cssSelector("#billing\\:street1")).sendKeys("street 2.0");
        driver.findElement(By.cssSelector("#billing\\:city")).sendKeys("Cluj");


    }




    }

