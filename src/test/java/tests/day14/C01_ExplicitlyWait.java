package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {
    //1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()

    @Test
    public void implicitlyWaitTesti(){
        //     Iki metod icin de asagidaki adimlari test edin.
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[.='Remove']")).click();


    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin
    }

    @Test
    public void explicitlyWaitTesti() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement itsGoneElementi=driver.findElement(By.xpath("//button[text()=\"It's Gone\"]"));
        Assert.assertTrue(itsGoneElementi.isDisplayed());

        driver.findElement(By.xpath("//button[text()='Add']"));
        WebElement itsBackText=driver.findElement(By.xpath("//p[@id='message']"));

        Assert.assertTrue(itsBackText.isDisplayed());
        Thread.sleep(2000);
    }
}
