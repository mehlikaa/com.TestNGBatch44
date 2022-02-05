package practice;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class G02_Twitter extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.twitter.com");
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//span[text()='Accepter tous les cookies']")).click();
        WebElement signUp=driver.findElement(By.xpath("//a[@data-testid='signupButton']"));
        signUp.click();
        WebElement emailInstead=driver.findElement(By.xpath("//span[text()='Use email instead']"));
                emailInstead.click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@type='text']")).click();

        Faker faker=new Faker();
        Actions actions=new Actions(driver);
        String randomMonth=faker.random().nextInt(1,12).toString();
        //String randomMonth=faker.random().nextInt(1,12)+"";
        actions.sendKeys(faker.name().fullName()).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN).sendKeys("March").sendKeys(Keys.ENTER).sendKeys(Keys.TAB)
                .sendKeys(randomMonth)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN).sendKeys("1990").sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("(//div[@dir='auto'])[7]")).click();
        //actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//span[text()='Sign up']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='We sent you a code']")).isDisplayed());
        Thread.sleep(2000);
        driver.close();
    }
}
