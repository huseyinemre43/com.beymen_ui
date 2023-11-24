package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductPage {

    public ProductPage() {PageFactory.initElements(Driver.getDriver(), this);}

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

    @FindBy(id ="removeCartItemBtn0-key-0")
    public WebElement removeButton;

    @FindBy(xpath ="(//strong[@class='m-empty__messageTitle'])[1]")
    public WebElement emptymessageTitle;





}
