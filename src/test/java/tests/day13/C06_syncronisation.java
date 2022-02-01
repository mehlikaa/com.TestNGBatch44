package tests.day13;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_syncronisation extends TestBase {

    @Test
    public void test01() throws InterruptedException {
       driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();



//        Thread.sleep(1000);
//        driver.findElement(By.id("file-submit")).click();

        //driver.get("https://www.youtube.com");


    }
}
