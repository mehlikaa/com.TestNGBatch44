package practice;

import com.github.javafaker.Faker;
import jdk.dynalink.linker.LinkerServices;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import java.util.List;
import java.util.Random;

    public class Q11_suatBey_twitter extends TestBase {
        WebElement emailBox, fulnameBox, usernameBox, pasworDbox;
        List<WebElement> hataMesaji;
        Faker faker = new Faker();
        @Test
        public void instegramTest() throws InterruptedException {
            driver.get("https://www.instagram.com/");
            driver.findElement(By.cssSelector("[data-testid=\"sign-up-link\"]")).click();
            Thread.sleep(2000);
            emailBox = driver.findElement(By.cssSelector("[name=\"emailOrPhone\"]"));
            fulnameBox = driver.findElement(By.cssSelector("[name=\"fullName\"]"));
            usernameBox = driver.findElement(By.cssSelector("[name=\"username\"]"));
            pasworDbox = driver.findElement(By.cssSelector("[name=\"password\"]"));
            Faker faker = new Faker();
            emailyaz(driver);
            fullnameyaz(driver);
            usernameyaz(driver);
            paswordyaz(driver);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            WebElement ayDropBox = driver.findElement(By.cssSelector("[title=\"Ay:\"]"));
            WebElement gunDropBox = driver.findElement(By.cssSelector("[title=\"Gün:\"]"));
            WebElement yilDropBox = driver.findElement(By.cssSelector("[title=\"Yıl:\"]"));
            Select select = new Select(ayDropBox);
            select.selectByIndex(faker.random().nextInt(1, 12));
            Select select1 = new Select(gunDropBox);
            select1.selectByIndex(faker.random().nextInt(1, 30));
            Select select2 = new Select(yilDropBox);
            select2.selectByIndex(faker.random().nextInt(1, 109));
            driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
            WebElement onayKoduGirYazisi = driver.findElement(By.xpath("//div[text()='Onay Kodunu Gir']"));
            Assert.assertTrue(onayKoduGirYazisi.isDisplayed());
            driver.close();
        }
        private void paswordyaz(WebDriver driver) {
            pasworDbox.click();
            hataMesaji = driver.findElements(By.cssSelector("[class=\"coreSpriteInputError gBp1f\"]"));
            if (hataMesaji.size() != 0) {
                driver.findElement(By.cssSelector("[class=\"coreSpriteInputRefresh Szr5J\"]")).click();
            }
            pasworDbox.click();
            pasworDbox.sendKeys(faker.internet().password());
        }
        private void usernameyaz(WebDriver driver) {
            usernameBox.click();
            usernameBox.sendKeys(faker.name().username());
        }
        private void fullnameyaz(WebDriver driver) {
            fulnameBox.click();
            hataMesaji = driver.findElements(By.cssSelector("[class=\"coreSpriteInputError gBp1f\"]"));
            if (hataMesaji.size() != 0) {
                emailyaz(driver);
            }
            fulnameBox.click();
            fulnameBox.sendKeys(faker.name().fullName());
        }
        private void emailyaz(WebDriver driver) {
            emailBox.sendKeys(Keys.CONTROL + "a");
            emailBox.sendKeys(Keys.DELETE);
            emailBox.sendKeys(faker.internet().emailAddress());
        }
    }
