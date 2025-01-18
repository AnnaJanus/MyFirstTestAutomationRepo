import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest{

    @Test()
    public void positiveLoginTest(){
        open("https://www.saucedemo.com");

        //provide username
        $("#user-name").sendKeys("standard_user");
        //$x("xpathSelector").sendKeys("standard_user");

        //provide password
        $("#password").sendKeys("secret_sauce");

        //click login button
        $("#login-button").click();

        //check list of products
        Assert.assertEquals($$(".inventory_item_name").size(),6);
    }

    @Test
    public void browserConfiguration(){
        // headless - tryb bez podglądu
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
//        Configuration.browser = "safari";
        Configuration.timeout = 8000; // timeout na czekanie na elementy

        Configuration.savePageSource = false; // usuwa raport selenide

        open("https://www.saucedemo.com");

        //provide username
        $("#user-name").sendKeys("standard_user");
        //$x("xpathSelector").sendKeys("standard_user");

        //provide password
        $("#password").sendKeys("secret_sauce");

        //click login button
        $("#login-button").click();

        //check list of products
        Assert.assertEquals($$(".inventory_item_name").size(),6);

        Selenide.screenshot("BrowserConfiguration-"+System.currentTimeMillis());
    }
}
