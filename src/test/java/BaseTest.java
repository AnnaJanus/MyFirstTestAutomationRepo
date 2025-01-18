import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeMethod()
    public void setupBrowser() throws IOException {
        readProperties();

        Configuration.headless = Boolean.parseBoolean(System.getProperty("HEADLESS"));
        Configuration.browserSize = "1920x1080";
        Configuration.savePageSource = false;

        open(System.getProperty("BASE_URL"));

    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        if (!result.isSuccess()) {
            Selenide.screenshot(result.getMethod().getMethodName() + "-" + System.currentTimeMillis());
        }
    }

    private void readProperties() throws IOException {
        Properties appProperties = new Properties();
        appProperties.load(new FileInputStream("src/test/resources/app.properties"));

        Iterator iterator = appProperties.keys().asIterator();

        while (iterator.hasNext()){
            String key = (String) iterator.next();
            System.setProperty(key, appProperties.getProperty(key));
        }
    }
}
