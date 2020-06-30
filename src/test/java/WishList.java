import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


//Testele nu sunt stabile...la inceput au trecut, la urmatorul Run, au picat si nu inteleg de ce.

public class WishList {
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
    public void addToWishlist(){
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > a")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a")).click();
        WebElement wishlistMessage = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div.my-wishlist > ul > li > ul > li > span"));
        Assert.assertTrue(wishlistMessage.isDisplayed());
    }
    @Test
    public void removeFromWishList() {
       driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
       driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > a")).click();
       driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a")).click();
       driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
       driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(2) > a")).click();
       driver.findElement(By.cssSelector("#item_641 > td.wishlist-cell5.customer-wishlist-item-remove.last > a")).click();
       Alert alert = driver.switchTo().alert();
       alert.accept();
       WebElement removeMessage = driver.findElement(By.cssSelector("#wishlist-view-form > div > p"));
       Assert.assertTrue(removeMessage.isDisplayed());
    }
    @Test
    public void addFromWishlistToCart(){
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > a")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a")).click();
        WebElement wishlistMessage = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div.my-wishlist > ul > li > ul > li > span"));
        Assert.assertTrue(wishlistMessage.isDisplayed());
        driver.findElement(By.cssSelector("#item_657 > td.wishlist-cell4.customer-wishlist-item-cart > div > button > span > span")).click();
        driver.findElement(By.cssSelector("#swatch27 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#swatch77 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();


    }











    @After
    public void quitDriver(){
        driver.quit();
    }


}
