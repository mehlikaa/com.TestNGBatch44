package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenShotWebElement extends TestBase {

    @Test
    public void ScreenShotTest() throws InterruptedException, IOException {
        //amazon ana sayfaya gidelim
        driver.get("https://www.amazon.com");

        //nutella aramasi yapalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        // sonuclarin nutella icerdigini test edelim
        WebElement sonucYazisiElement = driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        String sonucSayisiStr = sonucYazisiElement.getText();

        Assert.assertTrue(sonucSayisiStr.contains("Nutella"));

        TakesScreenshot tss=(TakesScreenshot) driver;

        File webElementSS=new File("target/ScreenShot/webElement.jpeg");

        File geciciResim=sonucYazisiElement.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim,webElementSS);



    }
}
