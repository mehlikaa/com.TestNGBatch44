package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_Tekrar extends TestBase {
    // Yeni bir class olusturalim: MouseActions2

    @Test
    public void test01() throws InterruptedException {
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions=new Actions(driver);
        WebElement tasinacakElement=driver.findElement(By.xpath("//div[text()='Drag me']"));
        WebElement tasinacakHedefElement= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(tasinacakElement,tasinacakHedefElement).perform();
        System.out.println(tasinacakHedefElement.getText());
        Assert.assertEquals(tasinacakHedefElement.getText(),"Dropped!");
        Thread.sleep(2000);
        driver.close();
    }
}
