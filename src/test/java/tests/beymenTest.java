package tests;

import org.apache.poi.ss.usermodel.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.ProductPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSutilities;
import utilities.ReusableMethods;

import java.io.*;
import java.util.logging.Logger;



public class beymenTest {


    String gomlek;
    String sort;
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();

    private static Logger log = Logger.getLogger(beymenTest.class.getName());

    @Before
    public void setUp() {

        Driver.getDriver().get(ConfigReader.getProperty("beymenUrl"));
        log.info("Anasayfaya gidildi");

        if (homePage.cookiesReject.isDisplayed()) {
            homePage.cookiesReject.click();


        if(homePage.closeIcon.isDisplayed()){
            homePage.closeIcon.click();
        }

        }
    }

    @After
    public void close() {
        Driver.closeDriver();
    }


    @Test
    public void selectrandomProduct() throws IOException, InterruptedException {


        Assert.assertTrue(homePage.beymenLogo.isDisplayed());
        log.info("Anasayfaya gidildigi dogrulandi");


        homePage.searchBox1.click();
        homePage.searchBox2.sendKeys("şort");
        ReusableMethods.waitFor(3);
        homePage.searchBox2.clear();

        log.info("Arama kutucuguna şort kelimesi girildi ve silindi");

        ReusableMethods.waitFor(2);

        homePage.searchBox2.sendKeys("gömlek", Keys.ENTER);
        log.info("gömlek kelimesi aratıldı");


        String path = "src/test/java/tests/Urunler.xlsx";

        FileInputStream product = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(product);

        Sheet urun = workbook.getSheet("Sheet1");

        Row row = urun.getRow(0);

        Cell cell = row.getCell(0);

        sort = cell.toString();

        cell = row.getCell(1);

        gomlek = cell.toString();

        log.info(" gömlek ve şort kelimesi excel dosyası üzerinden  istenilen satır ve sütundan alınarak  yazıldı");


        ReusableMethods.waitFor(2);
        productPage.selectedProduct.click();

        log.info("sergilenen ürünlerden  rastgele bir tanesi seçildi.");


        File file = new File("urunDosyasi.txt");
        if (!file.exists()) ;
        file.createNewFile();

        String productInfo = productPage.productInfo.getText();
        String priceInfo = productPage.priceInfo.getText();

        FileWriter fWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fWriter);
        bWriter.write(productInfo + "\n\n");
        bWriter.write(priceInfo);
        bWriter.close();

        log.info("Seçilen ürününün tutar ve ürün bilgisi txt dosyasına yazıldı");


        productPage.selectSize.click();
        ReusableMethods.scrollDown(1);
        ReusableMethods.waitFor(3);
        productPage.addBasket.click();

        log.info("seçilen ürün sepete eklendi");


        ReusableMethods.waitFor(5);
        JSutilities.scrollToTop(Driver.getDriver());
        productPage.myBasket.click();

        String expectedPrice = ConfigReader.getProperty("gercekFiyat");
        String actualPrice = productPage.priceinBasket.getText();
        Assert.assertEquals(expectedPrice, actualPrice);

        log.info("Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırıldı.");


        productPage.selectButton.click();
        WebElement urunAdedi = productPage.selectButton;
        Select select = new Select(urunAdedi);
        select.selectByValue("2");
        productPage.selectButton.click();


        String expectedQuantity = ConfigReader.getProperty("gercekAdet");
        String actualQuantity = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedQuantity, actualQuantity);

        log.info("Adet arttırılarak ürün adedinin 2 olduğu doğrulandı");


        ReusableMethods.waitFor(2);
        productPage.removeButton.click();
        ReusableMethods.waitFor(2);
        productPage.emptymessageTitle.isDisplayed();

        log.info("Ürün sepetten silinerek sepetin boş olduğu kontrol edildi");


    }
}
