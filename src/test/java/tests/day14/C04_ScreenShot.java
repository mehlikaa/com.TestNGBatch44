package tests.day14;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;

public class C04_ScreenShot extends TestBase {

    @Test
    public void screenTest(){
        driver.get("https://www.google.com");
        TakesScreenshot takeScreenShotElement=(TakesScreenshot) driver;   //obje, hem de bir variabledir
        //abstract obje olusturamadigimiz icin. driver i takescreenshota cast yaptik

        //tum sayfanin screenshotini almak icin, bir file olusturalim ve dosya yolunu belirtelim.
        File tumSayfaSS=new File("/Users/mehlika/Desktop\\1.png");

        //3. adim : olusturdugumuz   file ile iliskilendirelim.

        tumSayfaSS=takeScreenShotElement.getScreenshotAs(OutputType.FILE);



    }

}
