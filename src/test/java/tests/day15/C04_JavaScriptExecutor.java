package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_JavaScriptExecutor extends TestBase {
//amazon anasayfaya gidip
//sell linkine JSExecuter ile tiklayin
//ilgil sayfaya gittigimizi test edelim

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
// 1-
        JavascriptExecutor jse=(JavascriptExecutor) driver;

        WebElement sellElement=driver.findElement(By.xpath("//a[normalize-space()='Sell']"));

        // 3- adim ile ilgili script ve argument(bizim web elementimiz) uzerinden execute script metodunu calistiralim.

        jse.executeScript("arguments[0].click();",sellElement);
        Thread.sleep(3000);

        }
    }

