import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cart {

    private WebDriver driver;
    @Before
    public void openDriver(){
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
    public void addToCart(){
        driver.findElement(By.cssSelector("#search")).sendKeys("shirt");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a")).click();
        driver.findElement(By.cssSelector("#swatch26 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch77 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        WebElement elementWasAdded = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > ul > li > ul > li"));
        Assert.assertTrue(elementWasAdded.isDisplayed());
    }
    @Test
    public void moveToWishlistFromCart(){
        driver.findElement(By.cssSelector("#search")).sendKeys("shirt");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a")).click();
        driver.findElement(By.cssSelector("#swatch26 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch77 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        WebElement elementWasAdded = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > ul > li > ul > li"));
        Assert.assertTrue(elementWasAdded.isDisplayed());
        driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > ul > li:nth-child(2) > a")).click();
        WebElement elementHasBeenMoved = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart-empty > ul > li > ul > li"));
        Assert.assertTrue(elementHasBeenMoved.isDisplayed());

    }
    @Test
    public void addToCartAndproceedToCheckout(){
        driver.findElement(By.cssSelector("#header > div > a > img.large")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.std > div.widget.widget-new-products > div.widget-products > ul > li:nth-child(4) > a > img")).click();
        driver.findElement(By.cssSelector("#swatch20 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch77 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > div.page-title.title-buttons > ul > li > button > span > span")).click();
    }
    @After
    public void quitDriver(){
        driver.quit();

    }


}
