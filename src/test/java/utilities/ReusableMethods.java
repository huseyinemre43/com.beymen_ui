package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ReusableMethods {


     HomePage homepage = new HomePage();

    public static void waitFor(int saniye) {

        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {

        }
    }
    public static void scrollDown(int distance) {
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < distance; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
        }
    }

}