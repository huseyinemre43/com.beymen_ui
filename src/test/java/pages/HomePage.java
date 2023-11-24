package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//button[text()='Tüm Çerezleri Reddet'])[1]")
    public WebElement cookiesReject;

    @FindBy(xpath ="(//button[@type='button'])[4]")
    public WebElement closeIcon;

    @FindBy (xpath ="//img[@class='o-header__logo--img --blue']")
    public WebElement beymenLogo;

    @FindBy(xpath ="//div[@class='o-header__search--wrapper']")
    public WebElement searchBox1;

    @FindBy(xpath = "//input[@id='o-searchSuggestion__input']")
    public WebElement searchBox2;

    @FindBy(xpath = "(//div[@class='m-productImageList'])[2]")
    public WebElement selectedProduct;

    @FindBy(xpath = "//h1[@class='o-productDetail__title']")
    public WebElement productInfo;

    @FindBy(xpath ="//div[@class='m-price onlyOnePrice']")
    public WebElement priceInfo;

    @FindBy(xpath ="(//span[@class='m-variation__item'])[1]")
    public WebElement selectSize;

    @FindBy(id="addBasket")
    public WebElement addBasket;

    @FindBy(xpath = "//a[@title='Sepetim']")
    public WebElement  myBasket;

    @FindBy(xpath ="//div[@class='m-productPrice__content']")
    public WebElement priceinBasket;

    @FindBy(id="quantitySelect0-key-0")
    public WebElement selectButton;

    @FindBy(xpath = "//div[@class='m-basket__quantity']")
    public WebElement basketQuantity;

    @FindBy(id ="removeCartItemBtn0-key-0")
    public WebElement removeButton;

    @FindBy(xpath ="(//strong[@class='m-empty__messageTitle'])[1]")
    public WebElement emptymessageTitle;



}
