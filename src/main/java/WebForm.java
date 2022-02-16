import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

public class WebForm extends PageObject {

    private final String urun = "Bilgisayar";

    @FindBy(css = "form[action='https://www.gittigidiyor.com/arama/'] div[class='sc-4995aq-4 dNPmGY'] input[type='text']")
    private WebElement search;
    @FindBy(css = "button[data-cy='search-find-button']")
    private WebElement searchbutton;
    @FindBy(xpath = "li[data-testid='pagination-list-item'] span[xpath='1']")
    private WebElement secondpage;
    @FindBy(css = "li[class='sc-1nx8ums-0 dyekHG']")
    private WebElement selectproduct;
    @FindBy(css = "div[class='h1-container']")
    private WebElement productinfo;
    @FindBy(id = "sp-price-discountPrice")
    private WebElement productprice;
    @FindBy(css = "a[class='tyj39b-5 bEEsJG']")
    private WebElement cookie;
    @FindBy(id = "add-to-basket")
    private WebElement addtocart;
    @FindBy(id = "sp-price-discountPrice")
    private WebElement productprice2;
    @FindBy(css = "a[class='dIB']")
    private WebElement cart;
    @FindBy(css = "strong[class='real-discounted-price']")
    private WebElement cartprice;
    @FindBy(css = "select[class='amount']")
    private WebElement amount;
    @FindBy(css = "option[value='2']")
    private WebElement amount2;
    @FindBy(css = "i[class='gg-icon gg-icon-bin-medium']")
    private WebElement delete;
    @FindBy(css = "div[class='gg-ui-button gg-ui-btn-secondary policy-alert-v2-buttons']")
    private WebElement cookie2;
    @FindBy(xpath = "a[class='gg-ui-b//a[contains(text(),'Sepete Git')]']")
    private WebElement getcart;

    WebDriverWait wait = new WebDriverWait(driver,5);
    public WebForm(WebDriver driver) {
        super(driver);
    }

    public void setSearch(){
        this.search.sendKeys(urun);
    }
    public void clickSearch(){
        this.searchbutton.click();
    }
    public void clickSecondPage(){
        driver.get(Utils.BASE_URL2);
    }
    public void clickProduct(){
        this.selectproduct.click();
    }
    public String getProductInfo() {
        return this.productinfo.getText();
    }
    public String getProductPrice() {
        return this.productprice.getText();
    }
    public void clickCookie() {
        this.cookie.click();
    }
    public void scroll(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,5000)");
    }
    public void bekle() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-basket")));
    }
    public String getProductPrice2() {
        String productPrice22 = this.productprice2.getText();
        return productPrice22;
    }
    public void addCart() {
        this.addtocart.click();
    }
    public void getCart() {
        driver.get(Utils.BASE_URL3);
    }
    public String getCartPrice() {
        String CartPrice = this.cartprice.getText();
        return CartPrice;
    }
    public void clickAmount() {
        this.amount.click();
    }
    public void amountUp() {
        this.amount2.click();
    }
    public void setDelete() {
        this.delete.click();
    }
    public void clickCookie2() {
        this.cookie2.click();
    }

}
