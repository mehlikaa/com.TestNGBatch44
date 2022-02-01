package tests.day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;

public class C02_FakerFacebook extends TestBase {

//"https://facebook.com"  Adresine gidin
//“create new account”  butonuna basin
//“firstName” giris kutusuna bir isim yazin
//“surname” giris kutusuna bir soyisim yazin
//“email” giris kutusuna bir email yazin
//“email” onay kutusuna emaili tekrar yazin
//Bir sifre girin
    @Test
    public void testFacebookTesti() {
        driver.get("https://facebook.com");
        WebElement hesapEkle = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        hesapEkle.click();

        WebElement ilkTextBox=driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();               ///2.defa dogrulama istedigi icinaynisini alabilmek icin atadik

        actions.click(ilkTextBox).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().
                        lastName()).sendKeys(Keys.TAB).
                sendKeys(email).sendKeys(Keys.TAB).
                sendKeys(email).sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_DOWN).sendKeys("Jan").sendKeys(Keys.SPACE).sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_DOWN).sendKeys("11").sendKeys(Keys.SPACE).sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_DOWN).sendKeys("1999").sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
//                sendKeys(Keys.ENTER).
//                sendKeys("Mar").sendKeys(Keys.TAB).
//                sendKeys("12").sendKeys(Keys.TAB).
//                sendKeys("1980").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
//                sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_LEFT).
//                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
//                sendKeys(Keys.ENTER).
                perform();

        WebElement selectMaleElemet=driver.findElement(By.xpath("//input[@value='2']"));
        WebElement selectFemaleElemet=driver.findElement(By.xpath("//input[@value='1']"));


        Assert.assertFalse(selectMaleElemet.isSelected());
        Assert.assertTrue(selectFemaleElemet.isSelected());


    }
//Tarih icin gun secin
//Tarih icin ay secin
//Tarih icin yil secin
//Cinsiyeti secin
//Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
//Sayfayi kapatin

}
