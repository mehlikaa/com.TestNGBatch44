package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ScreenShotKlasoru extends TestBase {

    //amazona gidin
    //3 farkli test methodu ile java, nutella ve elma aratip
    //sonuc sayfasini screenshot'i kaydedin

    @Test
    public void test01() throws IOException {
        driver.get("https://www.amazon.com");

        //nutella aramasi yapalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java" + Keys.ENTER);
        tumSayfaScreenShot();
    }
    @Test
    public void test02() throws IOException {
       // driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        searchBox.sendKeys("Nutella" + Keys.ENTER);
        tumSayfaScreenShot();
    }
    @Test
    public void test03() throws IOException {
        // driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        searchBox.sendKeys("Elma" + Keys.ENTER);
        tumSayfaScreenShot();
    }

}
