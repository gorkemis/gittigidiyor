import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();
    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Gitti gidiyor")
    public static void gittiGidiyor() throws InterruptedException {
        driver.get(Utils.BASE_URL);
        WebForm webForm = new WebForm(driver);
        WebDriverWait wait = new WebDriverWait(driver,30);
        webForm.setSearch();
        webForm.clickSearch();
        webForm.clickCookie();
        webForm.clickSecondPage();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,"https://www.gittigidiyor.com/arama?k=Bilgisayar&sf=2");
        webForm.clickProduct();
        try {
            File file = new File("file");
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
                bw.write(webForm.getProductInfo() + webForm.getProductPrice());
            bw.close();
        }
        catch (
    IOException e) {
            e.printStackTrace();
        }
        String productPrice = webForm.getProductPrice2();
        webForm.clickCookie2();
        webForm.addCart();
        Thread.sleep(2000);
        webForm.getCart();
        String productCartPrice = webForm.getCartPrice();
        Assert.assertEquals(productPrice,productCartPrice);
        webForm.clickAmount();
        webForm.amountUp();
        webForm.setDelete();
    }
}
