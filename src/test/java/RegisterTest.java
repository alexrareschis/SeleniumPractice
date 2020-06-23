import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {


    public void register() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/customer/account/create/");
        driver.findElement(By.cssSelector("#firstname")).sendKeys("A");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("C");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("test");
        driver.findElement(By.cssSelector("#password")).sendKeys("0000");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("0000");
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        driver.quit();
    }
    public void registerSecond(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("QAtester");
        driver.findElement(By.id("lastname")).sendKeys("Manual Automation");
        driver.findElement(By.id("email_address")).sendKeys("testing@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.cssSelector("#form-validate > div.fieldset > ul > li.control > label")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        driver.quit();

    }


}
