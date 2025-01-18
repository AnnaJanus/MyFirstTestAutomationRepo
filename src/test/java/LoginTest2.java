import DataProviders.LoginDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest2 extends BaseTest {

    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    public void positiveLoginTest(String username, String password) {

        //provide username
        loginPage.usernameFill(username);

        //provide password
        loginPage.passwordFill(password);

        //click login button
        loginPage.loginButtonClick();

        //check list of products
        Assert.assertEquals(productPage.getSize(), 6);
    }
}
