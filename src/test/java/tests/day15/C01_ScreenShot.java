package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_ScreenShot extends TestBase {

    @Test
    public void ScreenShotTest() throws InterruptedException, IOException {
        //amazon ana sayfaya gidelim
        driver.get("https://www.amazon.com");

        //nutella aramasi yapalim
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);

        // sonuclarin nutella icerdigini test edelim
        WebElement sonucYazisiElement=driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        String sonucSayisiStr=sonucYazisiElement.getText();

        Assert.assertTrue(sonucSayisiStr.contains("Nutella"));
        // testin calistigini ispati icin tum sayfanin ekran resmini alalim

        // 1-
        TakesScreenshot tss=(TakesScreenshot) driver;

       // 2- Kaydedecegimiz dosyayi olusturalim
        File tumSayfaSS= new File("target/ScreenShot/tumSayfa.jpg");        //dosya olusturacagimiz icin path istiyor. direk isim projenin altina ekler.

        //3- bir dosya daha olusturup ScreenShot objesi ile ScreenShoti alalim
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);

        // 4- gecici resmi kaydetmek istedigimiz asil dosyaya copy yapalim
        FileUtils.copyFile(geciciResim,tumSayfaSS);







        Thread.sleep(5000);
    }
}

