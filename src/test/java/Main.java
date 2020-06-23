import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");

       // registerAndLoginTest();
        //addAndRemoveFromWishList();




    }
    public static void registerAndLoginTest(){
        LoginTest loginTest = new LoginTest();
        RegisterTest registerTest = new RegisterTest();
        registerTest.registerSecond();
        loginTest.newLogin();
    }
    public static void addAndRemoveFromWishList(){
        WishListTest wishListTest = new WishListTest();
        wishListTest.addToWishList();
        wishListTest.removeFromWishList();

    }

}

