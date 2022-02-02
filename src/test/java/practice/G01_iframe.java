package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class G01_iframe extends TestBase {

    ////1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
    ////2. “Our Products” butonuna basin
    ////3. “Cameras product”i tiklayin
    @Test
    public void test01() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframe);

        WebElement ourProductElement=driver.findElement(By.xpath("//a[text()='Our Products']"));
        ourProductElement.click();

        WebElement camerasElement=driver.findElement(By.xpath("(//p[@class='sub-heading'])[2]"));
        camerasElement.click();

        Thread.sleep(1500);
        ////4. Popup mesajini yazdirin
        ////5. “close” butonuna basin
        ////6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        ////7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        System.out.println(driver.findElement(By.xpath("//b[text()='NEWCUSTOMER773322']")).getText());
        driver.findElement(By.xpath("//button[text()='Close']")).click();

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("(//a[@class='navbar-brand'])[1]")).click();
       //
        String actualTitle=driver.getTitle();
        String expectedTitle="WebdriverUniversity.com";

        Assert.assertTrue(expectedTitle.equalsIgnoreCase(actualTitle));
        System.out.println("Islem Basarili"+ actualTitle);
    }



}
