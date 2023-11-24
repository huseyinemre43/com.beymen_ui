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





}
